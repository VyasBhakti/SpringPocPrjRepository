package springmvc.ProductListAndDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 
import springmvc.ProductListAndDetails.model.Category;
import springmvc.ProductListAndDetails.service.CategoryService;
 
@RestController
public class GetCategoryDetailsController {
 
    @Autowired
    CategoryService categoryService;  //Service which will do all data retrieval/manipulation work
      
    //-------------------Retrieve All Category--------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategories() {
        //System.out.println(" in listAllCategories...  ");
    	List<Category> categoriesLst = categoryService.findAllCategories();
        if(categoriesLst.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);// many return HttpStatus.NOT_FOUND
        }else{ 
        	return new ResponseEntity<List<Category>>(categoriesLst, HttpStatus.OK);
        }
    }
  
    //-------------------Retrieve Single Category--------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory/{category_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategory(@PathVariable("category_name") String category_name) {
        //System.out.println(" here in getCategory .............");
    	List<Category> categoryLstObj = categoryService.findByName(category_name);
        if (categoryLstObj == null) {
            return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Category>>(categoryLstObj, HttpStatus.OK);
    }
      
    //-------------------Create a Category--------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category categoryReqObj,    UriComponentsBuilder ucBuilder) {
        if (categoryService.isCategoryExist(categoryReqObj)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        categoryService.saveCategory(categoryReqObj);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ProductCategory/{id}").buildAndExpand(categoryReqObj.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
      
    //------------------- Update a Category --------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category categoryReqObj) {
        Category categoryObjToEdit = categoryService.findById(id);
        if (categoryObjToEdit==null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
 
        categoryObjToEdit.setCategory_name(categoryReqObj.getCategory_name());
        categoryService.updateCategory(categoryObjToEdit);
        return new ResponseEntity<Category>(categoryObjToEdit, HttpStatus.OK);
    }
 
    //------------------- Delete a Category --------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id) {
        Category categoryObjToDelete = categoryService.findById(id);
        if (categoryObjToDelete == null) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
 
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<Category>(HttpStatus.OK);
    }
      
    //------------------- Delete All Categories --------------------------------------------------------
     
    @RequestMapping(value = "/ProductCategory", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteAllCategories() {
        categoryService.deleteAllCategories();
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
 
}