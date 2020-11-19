package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import com.cg.healthassist.doctorpatient.entity.Medicine;

public interface MedicineService {

	Medicine addMedicine(Medicine medicine);
	boolean cancelMedicineById(Integer MedicineId);
	Medicine updateMedicineById(Integer MedicineId);
	Medicine findMedicineById(Integer MedicineId);
    List<Medicine> getAllMedicines();
   
    
    
    
}
