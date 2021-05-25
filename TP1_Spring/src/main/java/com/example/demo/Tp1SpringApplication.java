package com.example.demo;

import java.util.Date;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PatientRepository;
import com.example.demo.model.Patient;

@SpringBootApplication
public class Tp1SpringApplication implements CommandLineRunner{
	
	@Autowired
    private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Tp1SpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1) Ajouter des patients
		this.patientRepository.save(new Patient(null,"younes",new Date(),12,100,false));
		this.patientRepository.save(new Patient(null,"yassine",new Date(),18,1000,true));
		this.patientRepository.save(new Patient(null,"amine",new Date(),20,200,false));
		this.patientRepository.save(new Patient(null,"mohammed",new Date(),19,10,true));
		this.patientRepository.save(new Patient(null,"salah",new Date(),10,600,false));
		
		//2) Afficher des patients
		
		System.out.println("---------------------Patient(s) :--------------------");
		
		this.patientRepository.findAll().forEach(p ->{
			System.out.println(p.toString());
		});
		
		
		// 3) Consulter un patient
		Scanner sc =new Scanner(System.in);
		System.out.println("Donner le id du patient que vous voulez consulter : ");
		 Long id=sc.nextLong();
		
	     if(!this.patientRepository.findById(id).isEmpty()) {
	    	 System.out.println(this.patientRepository.findById(id).get().toString());
	     }
	     
	     //4) Mettre à jour un patient
	     System.out.println("Donner le id du patient que vous voulez modifier : ");
			id=sc.nextLong();
	     Patient updatedP=this.patientRepository.findById(id).get();
	    	
	     
	     
	     updatedP.setMalade(true);
	    
	     updatedP.setScore(000);
	     this.patientRepository.save(updatedP);
	    
	    
	     
	    
			System.out.println("---------------------Patient(s) :--------------------");
			
			this.patientRepository.findAll().forEach(p ->{
				System.out.println(p.toString());
			});
			
	     
	     //5) Supprimer un patient
	     System.out.println("Donner le id du patient que vous voulez supprimer : ");
			id=sc.nextLong();
			this.patientRepository.deleteById(id);
			
			System.out.println("---------------------Patient(s) :--------------------");
			
			this.patientRepository.findAll().forEach(p ->{
				System.out.println(p.toString());
			});
			
	     
	     //6) Chercher des patients
		     System.out.println("Donner le nom de patient que vous voulez consulter : ");
				String nom=sc.toString();
				
			this.patientRepository.findByNom(nom).forEach(p->{
				System.out.println(p.toString());
			});
			
		//7) Chercher des patients malade
		     System.out.println("Personnes malade : ");
			
				
			this.patientRepository.findByMalade(true).forEach(p->{
				System.out.println(p.toString());
			});
			sc.close();
			
		/*
		 * 1) Ajouter des patients
		 * 2) Afficher des patients
		 * 3) Consulter un patient
		 * 4) Mettre à jour un patient
		 * 5) Supprimer un patient
		 * 6) Chercher des patients
		 * 7) Chercher des patients malade
		 * 
		 * */
		

	}

}
