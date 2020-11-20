package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.exception.MedicineNotFoundException;


/** This is service interface for medicine
 * 
 * @author Swathi
 * 
 * **/

public interface MedicineService {

	/** This method is to add medicine **/
	Medicine addMedicine(Medicine medicine) throws MedicineNotFoundException;
	
	/** This method is to cancel medicine By Id **/
	boolean cancelMedicineById(Integer medicineId) throws MedicineNotFoundException;
	
	/** This method is to update medicine By Id **/
	Medicine updateMedicineById(Integer medicineId, String medicineName) throws MedicineNotFoundException;
	
	/** This method is to find medicine By Id **/
	Medicine findMedicineById(Integer medicineId) throws MedicineNotFoundException;
	
	/** This method is to getAll medicine **/
    List<Medicine> getAllMedicines() throws MedicineNotFoundException;
   
    
    
    
}
