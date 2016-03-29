package springmvc.ProductListAndDetails.service;
 
import java.util.List;
 
import springmvc.ProductListAndDetails.model.Category;
 
 
 
public interface CategoryService {
     
    Category findById(long id);
     
    List<Category> findByName(String name);
     
    void saveCategory(Category categoryObj);
     
    void updateCategory(Category categoryObj);
     
    void deleteCategoryById(long id);
 
    List<Category> findAllCategories(); 
     
    void deleteAllCategories();
     
    public boolean isCategoryExist(Category categoryObj);
     
}