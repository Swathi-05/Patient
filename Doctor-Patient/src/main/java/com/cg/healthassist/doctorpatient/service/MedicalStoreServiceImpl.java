package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.exception.MedicalStoreNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicalStoreRepository;

/** The MedicalStoreServiceImpl class provides methods to add, find and view all medicalStores
 *  
 * @author Swathi
 * 
 * **/

@Service
@Transactional
public class MedicalStoreServiceImpl implements MedicalStoreService{
	
	@Autowired
	private MedicalStoreRepository medicalStoreRepository;

	/** this method is to add medicalStore details **/
	
	@Override
	public MedicalStore addMedicalStore(MedicalStore medicalStore) {
		return medicalStoreRepository.save(medicalStore);
	}

	/** this method is to find medicalStore details by Id 
	 * @throws MedicalStoreNotFoundException **/
	
	@Override
	public MedicalStore findStoreById(Integer storeId) throws MedicalStoreNotFoundException {
		return medicalStoreRepository.findById(storeId).orElseThrow(() -> new MedicalStoreNotFoundException("Medical Store not found for this id :: " + storeId));
	}

	/** this method is to getAll medicalStore details **/
	
	@Override
	public List<MedicalStore> getAllMedicalStores() {
		 return medicalStoreRepository.findAll();
	}
	
}
