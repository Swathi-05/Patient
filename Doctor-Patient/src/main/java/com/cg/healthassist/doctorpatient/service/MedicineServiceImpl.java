package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.exception.MedicineNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicineRepository;

/** The MedicineServiceImpl class provides methods to add, find and view all medicine
 *  
 * @author Swathi
 * 
 * **/

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;

	/** This method is to add medicine details **/
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	/** This method is to cancel medicine details By Id 
	 * @throws MedicineNotFoundException **/
	
	@Override
	public boolean cancelMedicineById(Integer medicineId) throws MedicineNotFoundException {
		boolean flag=false;
		medicineRepository.deleteById(medicineId);
        Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(() -> new MedicineNotFoundException(" Medicine not found for this id  " + medicineId));
        if(null == medicine) {
             flag = true;
        }
		return flag;
		
	}

	/** This method is to update medicine details By Id 
	 * @throws MedicineNotFoundException **/
	
	@Override
	public Medicine updateMedicineById(Integer medicineId, String medicineName) throws MedicineNotFoundException {
		Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(() -> new MedicineNotFoundException("Medicine not found for this id :: " + medicineId));
		medicine.setMedicineName(medicineName);
	    return medicineRepository.save(medicine);
	}

	/** This method is to find medicine details By Id 
	 * @throws MedicineNotFoundException **/
	
	@Override
	public Medicine findMedicineById(Integer medicineId) throws MedicineNotFoundException {
		return medicineRepository.findById(medicineId).orElseThrow(() -> new MedicineNotFoundException("Medicine not found for this id :: " + medicineId));
	}

	/** This method is to gatAll medicine details **/
	
	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}
}
	