package com.Simplilearn.Final.sporty.Shoes.project.service.impl;

import java.util.Date;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Simplilearn.Final.sporty.Shoes.project.exceptionHandler.Exception_handler;
import com.Simplilearn.Final.sporty.Shoes.project.model.Report_Purchase;
import com.Simplilearn.Final.sporty.Shoes.project.model.Shoe_Data;
import com.Simplilearn.Final.sporty.Shoes.project.repository.Purchase_Report_Repository;
import com.Simplilearn.Final.sporty.Shoes.project.repository.Shoes_Repository;
import com.Simplilearn.Final.sporty.Shoes.project.service.Sporty_Shoes_Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class Sporty_Shoes_Service_Implement implements Sporty_Shoes_Service{
	
	@Autowired
	private Shoes_Repository shoesRepo;
	
	@Autowired
	private Purchase_Report_Repository prRepo;
	
	@PostConstruct
	public void init() {
		Shoe_Data s1 = new Shoe_Data(1,"Shoe Name 1","Basketball",1000.24);
		Shoe_Data s2 = new Shoe_Data(2,"Shoe Name 2","Cricket",1100.24);
		Shoe_Data s3 = new Shoe_Data(3,"Shoe Name 3","Running",900.24);
		Shoe_Data s4 = new Shoe_Data(4,"Shoe Name 4","Football",1900.24);
		
		shoesRepo.save(s1);
		shoesRepo.save(s2);
		shoesRepo.save(s3);
		shoesRepo.save(s4);
		
		Date d = new Date(0);
		Report_Purchase pr1 = new Report_Purchase(5,"user_1","Running",d,"adidas_runner:5,nike_airmax:10");
		Report_Purchase pr2 = new Report_Purchase(6,"user_2","Cricket",d,"adidas_cricket:5,nike_cricket:10");
		Report_Purchase pr3 = new Report_Purchase(7,"user_3","Basketball",d,"adidas_basketball:5,nike_basketball:10");
		Report_Purchase pr4 = new Report_Purchase(8,"user_4","Football",d,"adidas_football:5,nike_football:10");
		
		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
	}

	public Shoe_Data createShoe(Shoe_Data shoe_Data) throws Exception_handler {
		int id = shoe_Data.getId();
		Shoe_Data oldShoe = null;
		try {
			oldShoe = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoe!=null) throw new Exception_handler("Shoe already exists with id: "+id);
		return shoesRepo.save(shoe_Data);
	}

	public Shoe_Data getShoeById(int id) throws Exception_handler {
		Shoe_Data shoe_Data = null;
		try {
			if(id<=0) throw new Exception_handler("Shoe Id can not be negative or zero");
			shoe_Data = shoesRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new Exception_handler("Shoe not found with Id: "+id);
		}
		return shoe_Data;
	}
	
	public Shoe_Data updateShoe(Shoe_Data shoe_Data) {
		return shoesRepo.save(shoe_Data);
	}

	public void deleteShoeById(int id) throws Exception_handler {
		try {
			shoesRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new Exception_handler("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new Exception_handler("SHoe does not exist with id: "+id);
		}
	}

	public List<Shoe_Data> getAllShoes() {
		return shoesRepo.findAll();
	}

	public Report_Purchase createPurchaseReport(Report_Purchase pr) throws Exception_handler {
		int id = pr.getId();
		Report_Purchase oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new Exception_handler("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	
	}

	public Report_Purchase getPurchaseReportById(int id) throws Exception_handler {
		Report_Purchase pr = null;
		try {
			if(id<=0) throw new Exception_handler("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new Exception_handler("Purchase Report not found with Id: "+id);
		}
		return pr;
	}
	
	public Report_Purchase updatePurchaseReport(Report_Purchase pr) {
		return prRepo.save(pr);
	}
	
	public void deletePurchaseReportById(int id) throws Exception_handler {
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new Exception_handler("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new Exception_handler("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<Report_Purchase> getAllPurchaseReports() {
		return prRepo.findAll();
	}

	public List<Report_Purchase> getAllPurchaseReportsByCategory(String category) {
		return prRepo.findByCategory(category);
	}
	

	public List<Report_Purchase> getAllPurchaseReportsByDOP(Date dop) {
		return prRepo.findByDop(dop);
	}

}
