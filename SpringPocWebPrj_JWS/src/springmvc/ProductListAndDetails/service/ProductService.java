package springmvc.ProductListAndDetails.service;
 
import java.util.List;
 
import springmvc.ProductListAndDetails.model.Product;
 
public interface ProductService {
     
    Product findById(long id);
     
    List<Product> findByName(String name);
    
    List<Product> findBySubCategory(long subcategory_id);
     
    void saveProduct(Product productObj);
     
    void updateProduct(Product productObj);
     
    void deleteProductById(long id);
 
    List<Product> findAllProducts(); 
     
    void deleteAllProducts();
     
    public boolean isProductExist(Product productObj);
     
}