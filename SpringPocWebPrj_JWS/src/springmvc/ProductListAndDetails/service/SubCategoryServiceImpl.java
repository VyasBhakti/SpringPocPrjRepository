package springmvc.ProductListAndDetails.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.ProductListAndDetails.dao.GetSubCategoryDetailsDAO;
import springmvc.ProductListAndDetails.model.SubCategory;
 
@Service("subcategoryService")
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<SubCategory> subcategoryLst;
     
    static{
    	//System.out.println(" in static block implementation...  ");
    	GetSubCategoryDetailsDAO subcategoryDaoObj = new GetSubCategoryDetailsDAO();
    	subcategoryLst = subcategoryDaoObj.populateDummyCategories(counter);
    	//System.out.println(" subcategory List....." + subcategoryLst.toString());
    }
 
    public List<SubCategory> findAllCategories() {
    	//System.out.println(" in findAllCategories implementation... subcategory list is... " + subcategoryLst.toString());
        return subcategoryLst;
    }
     
    public SubCategory findById(long id) {
        for(SubCategory subcategoryObj : subcategoryLst){
            if(subcategoryObj.getId() == id){
                return subcategoryObj;
            }
        }
        return null;
    }
     
    public List<SubCategory> findByName(String subcategory_name) {
        List<SubCategory> subcategoryLstTemp = new ArrayList<SubCategory>();
		for(SubCategory subcategoryObj : subcategoryLst){
            if(subcategoryObj.getSubcategory_name().contains(subcategory_name)){
               subcategoryLstTemp.add(subcategoryObj);
            }
        }
        return subcategoryLstTemp;
    }

	public List<SubCategory> findByCategory(long category_id) {
		List<SubCategory> subcategoryLstTemp = new ArrayList<SubCategory>();
		for(SubCategory subcategoryObj : subcategoryLst){
            if(subcategoryObj.getCategory_id() == category_id){
               subcategoryLstTemp.add(subcategoryObj);
            }
        }
		return subcategoryLstTemp;
    }	
	
    public void saveSubCategory(SubCategory subcategoryReqObj) {
        subcategoryReqObj.setId(counter.incrementAndGet());
        subcategoryLst.add(subcategoryReqObj);
    }
 
    public void updateSubCategory(SubCategory subcategoryReqObj) {
        int index = subcategoryLst.indexOf(subcategoryReqObj);
        subcategoryLst.set(index, subcategoryReqObj);
    }
 
    public void deleteSubCategoryById(long id) {
         
        for (Iterator<SubCategory> iterator = subcategoryLst.iterator(); iterator.hasNext(); ) {
            SubCategory subcategoryObj = iterator.next();
            if (subcategoryObj.getId() == id) {
                iterator.remove();
            }
        }
    }
 
	public void deleteSubCategoryByCategoryId(long category_id) {
         
        for (Iterator<SubCategory> iterator = subcategoryLst.iterator(); iterator.hasNext(); ) {
            SubCategory subcategoryObj = iterator.next();
            if (subcategoryObj.getCategory_id() == category_id) {
                iterator.remove();
            }
        }
    }
	
    public boolean isSubCategoryExist(SubCategory subcategoryReqObj) {
        return findByName(subcategoryReqObj.getSubcategory_name())!=null;
    }
 
    public void deleteAllCategories() {
        subcategoryLst.clear();
    }
 
}