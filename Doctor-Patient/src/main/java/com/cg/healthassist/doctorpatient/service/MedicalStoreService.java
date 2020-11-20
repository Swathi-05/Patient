package com.cg.healthassist.doctorpatient.service;

import java.util.List;
import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.exception.MedicalStoreNotFoundException;

/** This is service interface for doctor
 * 
 * @author Swathi
 * 
 * **/

public interface MedicalStoreService {

	/** method is to add medicalStore **/
	MedicalStore addMedicalStore(MedicalStore medicalStore) throws MedicalStoreNotFoundException;
	
	/** method is to find medicalStore by Id **/
	MedicalStore findStoreById(Integer storeId) throws MedicalStoreNotFoundException;
	
	/** method is to getAll medicalStores **/
    List<MedicalStore> getAllMedicalStores() throws MedicalStoreNotFoundException;
}
