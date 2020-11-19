package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.exception.MedicalStoreNotFoundException;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicalStoreServiceImpl;

/** This class is for MedicalStore Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/MedicalStore")

public class MedicalStoreControl {
	
	@Autowired
	MedicalStoreServiceImpl storeService;
	
	@PostMapping("/addMedicalStore")
	public MedicalStore addMedicalStore(@RequestBody MedicalStore medicalStore)
	{
		return storeService.addMedicalStore(medicalStore);
	}
	@GetMapping("/getMedicalStoreById/{StoreId}")
	public MedicalStore getStoreById(@PathVariable Integer StoreId) throws MedicalStoreNotFoundException 
	{
		return storeService.findStoreById(StoreId);
	}
	@GetMapping("/getAllMedicalStores")
	public List<MedicalStore> getAllMedicalStores(){
		return(List<MedicalStore>) storeService.getAllMedicalStores();
	}
	
	
}
