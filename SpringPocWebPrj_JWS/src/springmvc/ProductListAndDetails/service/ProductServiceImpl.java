package springmvc.ProductListAndDetails.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.ProductListAndDetails.dao.GetProductDetailsDAO;
import springmvc.ProductListAndDetails.model.Product;
 
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Product> productLst;
     
    static{
    	//System.out.println(" in static block implementation...  ");
    	GetProductDetailsDAO productDaoObj = new GetProductDetailsDAO();
    	productLst = productDaoObj.populateDummyProducts(counter);
    	//System.out.println(" product List....." + productLst.toString());
    }
 
    public List<Product> findAllProducts() {
    	//System.out.println(" in findAllProducts implementation... product list is... " + productLst.toString());
        return productLst;
    }
     
    public Product findById(long id) {
        for(Product productObj : productLst){
            if(productObj.getProductId() == id){
                return productObj;
            }
        }
        return null;
    }
     
    public List<Product> findByName(String product_name) {
    	List<Product> productLstTemp = new ArrayList<Product>();
    	for(Product productObj : productLst){
            if(productObj.getProductName().contains(product_name)){
            	productLstTemp.add(productObj);
            }
        }
        return productLstTemp;
    }
     
    public List<Product> findBySubCategory(long subcategory_id) {
    	List<Product> productLstTemp = new ArrayList<Product>();
    	for(Product productObj : productLst){
            if(productObj.getSubCategoryId() == subcategory_id){
            	productLstTemp.add(productObj);
            }
        }
        return productLstTemp;
    }
    
    public void saveProduct(Product productReqObj) {
        productReqObj.setProductId(counter.incrementAndGet());
        productLst.add(productReqObj);
    }
 
    public void updateProduct(Product productReqObj) {
        int index = productLst.indexOf(productReqObj);
        productLst.set(index, productReqObj);
    }
 
    public void deleteProductById(long id) {
         
        for (Iterator<Product> iterator = productLst.iterator(); iterator.hasNext(); ) {
            Product productObj = iterator.next();
            if (productObj.getProductId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isProductExist(Product productReqObj) {
        return findByName(productReqObj.getProductName())!=null;
    }
 
    public void deleteAllProducts() {
        productLst.clear();
    }
 
}