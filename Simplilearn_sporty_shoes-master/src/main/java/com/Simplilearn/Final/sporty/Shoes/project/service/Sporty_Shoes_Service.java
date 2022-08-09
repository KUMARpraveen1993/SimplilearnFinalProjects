package com.Simplilearn.Final.sporty.Shoes.project.service;

import java.util.Date;
import java.util.List;

import com.Simplilearn.Final.sporty.Shoes.project.exceptionHandler.Exception_handler;
import com.Simplilearn.Final.sporty.Shoes.project.model.Report_Purchase;
import com.Simplilearn.Final.sporty.Shoes.project.model.Shoe_Data;

public interface Sporty_Shoes_Service {
	
	public Shoe_Data createShoe(Shoe_Data shoe_Data) throws Exception_handler;
	public Shoe_Data getShoeById(int id) throws Exception_handler;
	public Shoe_Data updateShoe(Shoe_Data shoe_Data);
	public void deleteShoeById(int id) throws Exception_handler;
	public List<Shoe_Data> getAllShoes();
	
	public Report_Purchase createPurchaseReport(Report_Purchase pr) throws Exception_handler;
	public Report_Purchase getPurchaseReportById(int id) throws Exception_handler;
	public Report_Purchase updatePurchaseReport(Report_Purchase pr);
	public void deletePurchaseReportById(int id) throws Exception_handler;
	public List<Report_Purchase> getAllPurchaseReports();
	public List<Report_Purchase> getAllPurchaseReportsByCategory(String category);
	public List<Report_Purchase> getAllPurchaseReportsByDOP(Date dop);

}
