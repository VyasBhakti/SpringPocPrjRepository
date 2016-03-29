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
 
import springmvc.ProductListAndDetails.model.SubCategory;
import springmvc.ProductListAndDetails.service.SubCategoryService;
 
@RestController
public class GetSubCategoryDetailsController {
 
    @Autowired
    SubCategoryService subcategoryService;  //Service which will do all data retrieval/manipulation work
      
    //-------------------Retrieve All SubCategory--------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> listAllCategories() {
        List<SubCategory> categoriesLst = subcategoryService.findAllCategories();
        if(categoriesLst.isEmpty()){
            return new ResponseEntity<List<SubCategory>>(HttpStatus.NO_CONTENT);// many return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SubCategory>>(categoriesLst, HttpStatus.OK);
    }
  
    //-------------------Retrieve Single SubCategory--------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory/{category_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SubCategory>> getSubCategory(@PathVariable("category_id") long category_id) {
        List<SubCategory> subcategoryLst = subcategoryService.findByCategory(category_id);
        if (subcategoryLst == null) {
            return new ResponseEntity<List<SubCategory>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SubCategory>>(subcategoryLst, HttpStatus.OK);
    }
      
    //-------------------Create a SubCategory--------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubCategory(@RequestBody SubCategory subcategoryReqObj,    UriComponentsBuilder ucBuilder) {
        if (subcategoryService.isSubCategoryExist(subcategoryReqObj)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        subcategoryService.saveSubCategory(subcategoryReqObj);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ProductSubCategory/{id}").buildAndExpand(subcategoryReqObj.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
      
    //------------------- Update a SubCategory --------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable("id") long id, @RequestBody SubCategory subcategoryReqObj) {
        SubCategory subcategoryObjToEdit = subcategoryService.findById(id);
         
        if (subcategoryObjToEdit==null) {
            return new ResponseEntity<SubCategory>(HttpStatus.NOT_FOUND);
        }
 
        subcategoryObjToEdit.setSubcategory_name(subcategoryReqObj.getSubcategory_name());
        subcategoryService.updateSubCategory(subcategoryObjToEdit);
        return new ResponseEntity<SubCategory>(subcategoryObjToEdit, HttpStatus.OK);
    }
 
    //------------------- Delete a SubCategory --------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SubCategory> deleteSubCategory(@PathVariable("id") long id) {
        SubCategory subcategoryObjToDelete = subcategoryService.findById(id);
        if (subcategoryObjToDelete == null) {
            return new ResponseEntity<SubCategory>(HttpStatus.NOT_FOUND);
        }
 
        subcategoryService.deleteSubCategoryById(id);
        return new ResponseEntity<SubCategory>(HttpStatus.OK);
    }
      
    //------------------- Delete All Categories --------------------------------------------------------
     
    @RequestMapping(value = "/ProductSubCategory", method = RequestMethod.DELETE)
    public ResponseEntity<SubCategory> deleteAllCategories() {
        subcategoryService.deleteAllCategories();
        return new ResponseEntity<SubCategory>(HttpStatus.NO_CONTENT);
    }
 
}