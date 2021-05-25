package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long>{

	List<Patient> findByNom(String nom);

	List<Patient> findByMalade(boolean b);
	
	Page<Patient> findByNomContains(String mc,Pageable pageable);

	
	
}
