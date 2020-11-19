package com.cg.healthassist.doctorpatient.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.repository.MedicalStoreRepository;
import com.cg.healthassist.doctorpatient.service.MedicalStoreService;

@Service
@Transactional
public class MedicalStoreServiceImpl implements MedicalStoreService{
	@Autowired
	private MedicalStoreRepository medicalStoreRepository;

	@Override
	public MedicalStore addMedicalStore(MedicalStore medicalStore) {
		return medicalStoreRepository.save(medicalStore);
	}

	@Override
	public MedicalStore findStoreById(Integer StoreId) {
		return medicalStoreRepository.findById(StoreId).get();
	}

	@Override
	public List<MedicalStore> getAllMedicalStores() {
		 return medicalStoreRepository.findAll();
	}
	
}
