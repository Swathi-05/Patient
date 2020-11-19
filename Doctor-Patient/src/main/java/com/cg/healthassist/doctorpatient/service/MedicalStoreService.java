package com.cg.healthassist.doctorpatient.service;

import java.util.List;

import com.cg.healthassist.doctorpatient.entity.MedicalStore;

public interface MedicalStoreService {

	MedicalStore addMedicalStore(MedicalStore medicalStore);
	MedicalStore findStoreById(Integer StoreId);
    List<MedicalStore> getAllMedicalStores();
}
