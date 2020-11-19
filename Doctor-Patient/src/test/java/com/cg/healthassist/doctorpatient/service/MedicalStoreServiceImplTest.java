package com.cg.healthassist.doctorpatient.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.exception.MedicalStoreNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicalStoreRepository;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicalStoreServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class MedicalStoreServiceImplTest {


    @MockBean
    private MedicalStoreRepository medicalStoreRepository;

    @Autowired
    private MedicalStoreServiceImpl medicalStoreService;

	@Test
	void testaddMedicalStore() {
		MedicalStore medicalStore = new MedicalStore();
		medicalStore.setStoreId(564);
		medicalStore.setStoreName("MedPlus");
		medicalStore.setStoreAddress("Whitefield, Bangalore");

        Mockito.when(medicalStoreRepository.save(medicalStore)).thenReturn(medicalStore);
        assertThat(medicalStoreService.addMedicalStore(medicalStore)).isEqualTo(medicalStore);
	}

  @Test 
  void testGetStoreById() throws MedicalStoreNotFoundException { 
	  MedicalStore medicalStore = new MedicalStore();
		medicalStore.setStoreId(584);
		medicalStore.setStoreName("Apollo Pharmacy");
		medicalStore.setStoreAddress("Btm Layout, Bangalore");
		
		assertThat(medicalStore.getStoreId()).isEqualTo(584);
  }
 

  @Test 
  void testGetAllMedicalStores() { 
	  MedicalStore medicalStore = new MedicalStore();
		medicalStore.setStoreId(584);
		medicalStore.setStoreName("Apollo Pharmacy");
		medicalStore.setStoreAddress("Btm Layout, Bangalore");
	  
		MedicalStore medS = new MedicalStore();
		medS.setStoreId(564);
		medS.setStoreName("MedPlus");
		medS.setStoreAddress("Whitefield, Bangalore");
		
		MedicalStore ms = new MedicalStore();
		ms.setStoreId(568);
		ms.setStoreName("Pharmacy");
		ms.setStoreAddress("maratahalli, Bangalore");
	  
      List<MedicalStore> medicalStoreList = new ArrayList<>();
      medicalStoreList.add(medicalStore);
      medicalStoreList.add(medS);
      medicalStoreList.add(ms);

      Mockito.when(medicalStoreRepository.findAll()).thenReturn(medicalStoreList);
      assertThat(medicalStoreService.getAllMedicalStores()).isEqualTo(medicalStoreList);
  }
}
