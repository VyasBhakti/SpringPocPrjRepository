package springmvc.ProductListAndDetails.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.ProductListAndDetails.dao.GetCategoryDetailsDAO;
import springmvc.ProductListAndDetails.model.Category;
 
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Category> categoryLst;
     
    static{
    	//System.out.println(" in static block implementation...  ");
    	GetCategoryDetailsDAO categoryDaoObj = new GetCategoryDetailsDAO();
    	categoryLst = categoryDaoObj.populateDummyCategories(counter);
    	//System.out.println(" category List....." + categoryLst.toString());
    }
 
    public List<Category> findAllCategories() {
    	//System.out.println(" in findAllCategories implementation... category list is... " + categoryLst.toString());
        return categoryLst;
    }
     
    public Category findById(long id) {
        for(Category categoryObj : categoryLst){
            if(categoryObj.getId() == id){
                return categoryObj;
            }
        }
        return null;
    }
     
    public List<Category> findByName(String category_name) {
        List<Category> categoryLstObjTemp= new ArrayList<Category>();
    	for(Category categoryObj : categoryLst){
            if(categoryObj.getCategory_name().contains(category_name)){
            	categoryLstObjTemp.add(categoryObj);
            }
        }
        return categoryLstObjTemp;
    }
     
    public void saveCategory(Category categoryReqObj) {
        categoryReqObj.setId(counter.incrementAndGet());
        categoryLst.add(categoryReqObj);
    }
 
    public void updateCategory(Category categoryReqObj) {
        int index = categoryLst.indexOf(categoryReqObj);
        categoryLst.set(index, categoryReqObj);
    }
 
    public void deleteCategoryById(long id) {
         
        for (Iterator<Category> iterator = categoryLst.iterator(); iterator.hasNext(); ) {
            Category categoryObj = iterator.next();
            if (categoryObj.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isCategoryExist(Category categoryReqObj) {
        return findByName(categoryReqObj.getCategory_name())!=null;
    }
 
    public void deleteAllCategories() {
        categoryLst.clear();
    }
 
}