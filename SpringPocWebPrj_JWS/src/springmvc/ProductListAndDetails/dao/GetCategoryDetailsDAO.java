package springmvc.ProductListAndDetails.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import springmvc.ProductListAndDetails.model.Category;

public class GetCategoryDetailsDAO {
	
	public List<Category> categoryLst;
	public List<Category> populateDummyCategories(AtomicLong counter){
        List<Category> categoryLst = new ArrayList<Category>();
        //System.out.println(" in populateDummyCategories...  ");
        categoryLst.add(new Category(counter.incrementAndGet(),"Furniture","V"));
        categoryLst.add(new Category(counter.incrementAndGet(),"Electricle","V"));
        categoryLst.add(new Category(counter.incrementAndGet(),"Paint","V"));
        categoryLst.add(new Category(counter.incrementAndGet(),"Mobile-Devices","V"));
        return categoryLst;
   }
 
	
}
