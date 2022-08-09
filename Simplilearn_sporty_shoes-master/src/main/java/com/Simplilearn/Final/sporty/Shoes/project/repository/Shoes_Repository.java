package com.Simplilearn.Final.sporty.Shoes.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Simplilearn.Final.sporty.Shoes.project.model.Shoe_Data;

@Repository
public interface Shoes_Repository extends JpaRepository<Shoe_Data, Integer>{
	
}
