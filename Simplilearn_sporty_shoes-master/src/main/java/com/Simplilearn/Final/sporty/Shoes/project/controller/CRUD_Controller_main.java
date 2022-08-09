package com.Simplilearn.Final.sporty.Shoes.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Simplilearn.Final.sporty.Shoes.project.exceptionHandler.Exception_handler;
import com.Simplilearn.Final.sporty.Shoes.project.model.Report_Purchase;
import com.Simplilearn.Final.sporty.Shoes.project.model.Shoe_Data;
import com.Simplilearn.Final.sporty.Shoes.project.service.Sporty_Shoes_Service;

@RestController
public class CRUD_Controller_main {

	@Autowired
	private Sporty_Shoes_Service service;

	private MultiValueMap<String, String> errorMap;

	@PostMapping("/admin/shoe")
	public ResponseEntity<Shoe_Data> createShoe(@RequestBody Shoe_Data shoe_Data) {
		try {
			return new ResponseEntity<>(service.createShoe(shoe_Data), HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/admin/shoe/{id}")
	public ResponseEntity<Shoe_Data> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getShoeById(id), HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	
	@PutMapping("/admin/shoe")
	public ResponseEntity<Shoe_Data> updateShoe(@RequestBody Shoe_Data shoe_Data) {
		return new ResponseEntity<>(service.updateShoe(shoe_Data), HttpStatus.OK);
	}

	@DeleteMapping("/admin/shoe/{id}")
	public ResponseEntity<String> deleteShoeById(@PathVariable int id) {
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id: " + id, HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@PostMapping("/admin/purchaseReport")
	public ResponseEntity<Report_Purchase> createPurchaseReport(@RequestBody Report_Purchase pr) {
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr), HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}

	
	@GetMapping("/admin/purchaseReport/id/{id}")
	public ResponseEntity<Report_Purchase> getPurchaseReportById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<Report_Purchase> updatePurchaseReport(@RequestBody Report_Purchase pr) {
		return new ResponseEntity<>(service.updatePurchaseReport(pr), HttpStatus.OK);
	}

	
	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id) {
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id: " + id, HttpStatus.OK);
		} catch (Exception_handler e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage:", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
		}
	}
}
