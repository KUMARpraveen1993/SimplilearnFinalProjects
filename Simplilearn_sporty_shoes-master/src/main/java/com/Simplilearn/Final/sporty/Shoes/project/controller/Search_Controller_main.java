package com.Simplilearn.Final.sporty.Shoes.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Simplilearn.Final.sporty.Shoes.project.model.Report_Purchase;
import com.Simplilearn.Final.sporty.Shoes.project.model.Shoe_Data;
import com.Simplilearn.Final.sporty.Shoes.project.service.Sporty_Shoes_Service;

@RestController
public class Search_Controller_main {
	
	@Autowired
	private Sporty_Shoes_Service service;
	
	
	
	@GetMapping("/admin/shoe/all")
	public ResponseEntity<List<Shoe_Data>> getAllShoes(){
		return new ResponseEntity<List<Shoe_Data>>(service.getAllShoes(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<Report_Purchase>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<Report_Purchase>>(service.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<Report_Purchase>> getAllPurchaseReportsByDop(@PathVariable Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<Report_Purchase>>(service.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/purchaseReport/all")
	public ResponseEntity<List<Report_Purchase>> getAllPurchaseReport(){
		return new ResponseEntity<List<Report_Purchase>>(service.getAllPurchaseReports(), HttpStatus.OK);
	}
}
