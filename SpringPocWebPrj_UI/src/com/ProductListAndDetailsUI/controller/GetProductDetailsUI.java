package com.ProductListAndDetailsUI.controller;


import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ProductListAndDetailsUI.model.Category;

@RestController
public class GetProductDetailsUI {
	
	@RequestMapping(value ="/SearchProduct/{searchByVal}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> getDetailsOnSearch(@PathVariable("searchByVal") String search_by_val, HttpServletRequest req){
		System.out.println("here.... in getDetailsOnSearch");
		RestTemplate restTemplate = new RestTemplate();
		String url =  "http://" + req.getServerName() + ":" + req.getLocalPort() +  "/SpringPocWebPrj_JWS/ProductCategory/"+ search_by_val;
		System.out.println("url...." + url);
		String detail_str_to_return ="";
		List<Category> categoryLstObj = restTemplate.getForObject(url, List.class);
		if(categoryLstObj!=null && categoryLstObj.size()>0){
			//ListIterator<Category> ite = categoryLstObj.listIterator();
			detail_str_to_return= " Category : \n \t\t" ;
			System.out.println("categoryLstObj...." + categoryLstObj);
			System.out.println("categoryLstObj element...." + categoryLstObj.get(1).getCategory_name());
			/*for(int i=0; i< categoryLstObj.size(); i++){
				Category tempObj = categoryLstObj.get(i);
				detail_str_to_return += "\n \t\t" + tempObj.getCategory_name();
			}*/
			/*while(ite.hasNext()){
				Category tempObj = ite.next();
				detail_str_to_return += "\n \t\t" + tempObj.getCategory_name();
				//detail_str_to_return += "\n \t\t" + (ite.next()).getCategory_name();
			} */
			/*for(Category tempObj : categoryLstObj){
				detail_str_to_return += "\n \t\t" + tempObj.getCategory_name();
			}*/
			
		}
		return new ResponseEntity<String>(detail_str_to_return, HttpStatus.OK);
	}
	
	
}
