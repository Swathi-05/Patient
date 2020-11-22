package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.exception.MedicineNotFoundException;
import com.cg.healthassist.doctorpatient.service.MedicineServiceImpl;

/** This class is for Medicine Controller 
 * 
 * @author Swathi
 * 
 * */

@RestController
@RequestMapping("/api/medicine")
@Validated
public class MedicineControl {
	
	@Autowired
	 MedicineServiceImpl medicineService;
	
	@PostMapping("/add")
	public Medicine addMedicine(@Valid @RequestBody Medicine medicineId)
	{
		return medicineService.addMedicine(medicineId);
	}
	
	@PutMapping("/update/{medicineId}")
	public Medicine updateMedicineById(@Valid @PathVariable Integer medicineId,String medicineName) throws MedicineNotFoundException
	{
		return medicineService.updateMedicineById(medicineId,medicineName);
	}
	
	@DeleteMapping("delete/{medicineId}")
	public boolean removeMedicineById(@Valid @PathVariable int medicineId) throws MedicineNotFoundException {
		return medicineService.cancelMedicineById(medicineId);
	}

	@GetMapping("/get/{medicineId}")
	public Medicine getMedicineById(@Valid @PathVariable Integer medicineId) throws MedicineNotFoundException 
	{
		return medicineService.findMedicineById(medicineId);
	}
	
	@GetMapping("/getall")
	public List<Medicine> getAllMedicines(){
        return medicineService.getAllMedicines();
	}
	
}
