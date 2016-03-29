package springmvc.ProductListAndDetails.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import springmvc.ProductListAndDetails.model.SubCategory;

public class GetSubCategoryDetailsDAO {
	
	public List<SubCategory> subcategoryLst;
	public List<SubCategory> populateDummyCategories(AtomicLong counter){
        List<SubCategory> subcategoryLst = new ArrayList<SubCategory>();
        //System.out.println(" in populateDummyCategories...  ");
        subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Doors",1,"V"));
        subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Windows",1,"V"));
        subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Primers",3,"V"));
        subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Fans",2,"V"));
		subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Lights",2,"V"));
		subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Refrigerators",2,"V"));
		subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Coolers",2,"V"));
		subcategoryLst.add(new SubCategory(counter.incrementAndGet(),"Air-conditioners",2,"V"));
        return subcategoryLst;
   }
 
	
}
