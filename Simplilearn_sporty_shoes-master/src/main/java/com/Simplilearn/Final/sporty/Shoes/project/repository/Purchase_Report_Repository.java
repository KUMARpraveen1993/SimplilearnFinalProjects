package com.Simplilearn.Final.sporty.Shoes.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Simplilearn.Final.sporty.Shoes.project.model.Report_Purchase;

@Repository
public interface Purchase_Report_Repository extends JpaRepository<Report_Purchase, Integer>{
	public List<Report_Purchase> findByDop(Date dop);
	public List<Report_Purchase> findByCategory(String category);

}
