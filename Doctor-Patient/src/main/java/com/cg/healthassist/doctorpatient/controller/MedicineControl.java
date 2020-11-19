package com.cg.healthassist.doctorpatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.exception.OrderNotFoundException;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicineServiceImpl;

@RestController
@RequestMapping("/Medicine")

public class MedicineControl {
	
	@Autowired
	 MedicineServiceImpl medicineService;
	
	@PostMapping("/addMedicine")
	public Medicine addMedicine(@RequestBody Medicine MedicineId)
	{
		return medicineService.addMedicine(MedicineId);
	}
	
	@PutMapping("/updateMedicineById/{MedicineId}")
	public Medicine updateMedicineById(@PathVariable Integer medicineId)
	{
		return medicineService.updateMedicineById(medicineId);
	}
	
	@DeleteMapping("DeleteMedicineById/{MedicineId}")
	public boolean removeMedicineById(@PathVariable int MedicineId) {
		return medicineService.cancelMedicineById(MedicineId);
	}

	@GetMapping("/getMedicineById/{MedicineId}")
	public Medicine getMedicineById(@PathVariable Integer MedicineId) throws OrderNotFoundException 
	{
		return medicineService.findMedicineById(MedicineId);
	}
	
	@GetMapping("/getAllMedicines")
	public List<Medicine> getAllMedicines(){
        return (List<Medicine>) medicineService.getAllMedicines();
	}
	
}
