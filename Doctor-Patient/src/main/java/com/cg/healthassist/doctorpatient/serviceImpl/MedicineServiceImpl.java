package com.cg.healthassist.doctorpatient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.repository.MedicineRepository;
import com.cg.healthassist.doctorpatient.service.MedicineService;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public Medicine addMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public boolean cancelMedicineById(Integer MedicineId) {
		medicineRepository.deleteById(MedicineId);
        Medicine medicine = medicineRepository.findById(MedicineId).get();
        if(null == medicine){
            return true;
        }
        return false;
	}

	@Override
	public Medicine updateMedicineById(Integer MedicineId) {
		Medicine medicine = medicineRepository.findById(MedicineId).get();
		medicine.setMedicineId(MedicineId);
	        return medicineRepository.save(medicine);
	}

	@Override
	public Medicine findMedicineById(Integer MedicineId) {
		return medicineRepository.findById(MedicineId).get();
	}

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}
}
	