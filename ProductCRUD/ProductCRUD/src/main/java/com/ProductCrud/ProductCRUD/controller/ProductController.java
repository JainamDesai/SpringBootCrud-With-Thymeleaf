package com.ProductCrud.ProductCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import com.ProductCrud.ProductCRUD.helper.HelperInter;
import com.ProductCrud.ProductCRUD.model.Product;

@Controller
public class ProductController {
	@Autowired
	HelperInter helper;
	
	@RequestMapping("/home")
	public String homePage() {
		
		return "Home";
	}
	@RequestMapping("/saveProductData")
	public String productData() {		
		return "AddProduct";	
}
	@RequestMapping("/addProduct")
	public ModelAndView saveProductData(Product product,Model m) {
		helper.save(product);
		ModelAndView mv = new ModelAndView("ShowRecord");
		mv.setViewName("ShowRecord.html");
		mv.addObject("obj",product);
		return mv;	
	}
	@RequestMapping("/showAll")
	public ModelAndView getAllRecords() {
		
		List<Product> list = helper.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShowSaveAllRecords");
		mv.addObject("objs",list);
		return mv;
	}
	@RequestMapping("/deleteData")
	public String deleteById(int id) {
		 helper.deleteById(id);
		return "DeleteData";
	}
	@RequestMapping("/updateDone")
	public ModelAndView updateMyData(int id) {

		Product product = helper.findById(id).orElse(new Product());
		ModelMap map = new ModelMap();
		map.addAttribute("id",product.getId());
		map.addAttribute("name",product.getName());
		map.addAttribute("description",product.getDescription());
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",map);
		mv.setViewName("UpdataData");
		return mv;
	}
	@RequestMapping("/updateData")
	public String updateProductData(Product product) {
		
		Product p = helper.findById(product.getId()).orElse(new Product());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		helper.save(p);
		return "UpdateMsg";
	}
}
