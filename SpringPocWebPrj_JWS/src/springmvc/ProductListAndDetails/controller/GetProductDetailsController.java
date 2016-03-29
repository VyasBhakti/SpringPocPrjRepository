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
 
import springmvc.ProductListAndDetails.model.Product;
import springmvc.ProductListAndDetails.service.ProductService;
 
@RestController
public class GetProductDetailsController {
 
    @Autowired
    ProductService productService;  //Service which will do all data retrieval/manipulation work
      
    //-------------------Retrieve All Product--------------------------------------------------------
     
    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> productsLst = productService.findAllProducts();
        if(productsLst.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// many return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(productsLst, HttpStatus.OK);
    }
  
    //-------------------Retrieve Single Product--------------------------------------------------------
     
    @RequestMapping(value = "/Product/{subcategory_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProduct(@PathVariable("subcategory_id") long subcategory_id) {
        List<Product> productLst = productService.findBySubCategory(subcategory_id);
        if (productLst == null) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(productLst, HttpStatus.OK);
    }
      
    //-------------------Create a Product--------------------------------------------------------
     
    @RequestMapping(value = "/Product", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody Product productReqObj,    UriComponentsBuilder ucBuilder) {
        if (productService.isProductExist(productReqObj)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        productService.saveProduct(productReqObj);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/Product/{id}").buildAndExpand(productReqObj.getProductId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
      
    //------------------- Update a Product --------------------------------------------------------
     
    @RequestMapping(value = "/Product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product productReqObj) {
        Product productObjToEdit = productService.findById(id);
         
        if (productObjToEdit==null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        productObjToEdit.setProductName(productReqObj.getProductName());
        productService.updateProduct(productObjToEdit);
        return new ResponseEntity<Product>(productObjToEdit, HttpStatus.OK);
    }
 
    //------------------- Delete a Product --------------------------------------------------------
     
    @RequestMapping(value = "/Product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        Product productObjToDelete = productService.findById(id);
        if (productObjToDelete == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        productService.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
      
    //------------------- Delete All Products --------------------------------------------------------
     
    @RequestMapping(value = "/Product", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAllProducts() {
        productService.deleteAllProducts();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
 
}