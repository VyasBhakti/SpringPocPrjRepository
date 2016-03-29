package springmvc.ProductListAndDetails.service;
 
import java.util.List;
 
import springmvc.ProductListAndDetails.model.SubCategory;
 
 
 
public interface SubCategoryService {
     
    SubCategory findById(long id);
     
    List<SubCategory> findByName(String name);
	
    List<SubCategory> findByCategory(long category_id);
     
    void saveSubCategory(SubCategory subcategoryObj);
     
    void updateSubCategory(SubCategory subcategoryObj);
     
    void deleteSubCategoryById(long id);
	
	void deleteSubCategoryByCategoryId(long category_id);
 
    List<SubCategory> findAllCategories(); 
     
    void deleteAllCategories();
     
    public boolean isSubCategoryExist(SubCategory subcategoryObj);
     
}