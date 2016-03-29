package springmvc.ProductListAndDetails.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import springmvc.ProductListAndDetails.model.Product;

public class GetProductDetailsDAO {
	
	public List<Product> productLst;
	public List<Product> populateDummyProducts(AtomicLong counter){
        List<Product> productLst = new ArrayList<Product>();
        //System.out.println(" in populateDummyCategories...  ");
        productLst.add(new Product(1, 3, 5, "001", "LED Light", "xxx", 55.0, 30.0, 80));
        productLst.add(new Product(2, 3, 5, "002", "Tube Light", "xxx", 155.0, 30.0, 80));
        productLst.add(new Product(3, 3, 5, "003", "Bulb", "xxx", 95.0, 30.0, 80));
        productLst.add(new Product(4, 4, 3, "004", "Interior Paint", "description", 234, 0, 1));
        productLst.add(new Product(5, 4, 3, "005", "Exterior Paint", "description xxx", 321, 0,1));
        
        return productLst;
   }
 
	
}
