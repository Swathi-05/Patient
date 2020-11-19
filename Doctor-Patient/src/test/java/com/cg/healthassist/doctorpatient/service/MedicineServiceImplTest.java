package com.cg.healthassist.doctorpatient.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.exception.OrderNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicineRepository;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicineServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicineServiceImplTest {


    @MockBean
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineServiceImpl medicineService;

	@Test
	void testaddMedicine() {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(1001);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);
		
        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
        assertThat(medicineService.addMedicine(medicine)).isEqualTo(medicine);
	}

  @Test 
  void testGetMedicineById() throws OrderNotFoundException { 
	  Medicine medicine = new Medicine();
		medicine.setMedicineId(134);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);
		
		assertThat(medicine.getMedicineId()).isEqualTo(134);
  }
 
  @Test
   void testremoveMedicineById() throws Exception{
	  Medicine medicine = new Medicine();    
	  medicine.setMedicineId(1345);
		medicine.setMedicineName("Calcium");
		medicine.setMedicineCost(300);
		
		medicineRepository.deleteById(medicine.getMedicineId());
	    Assert.assertTrue(medicineRepository.findById(1345).isEmpty());   
  }
  
  @Test
   void testupdateMedicineById() throws Exception{

	  Medicine medicine = new Medicine();
			medicine.setMedicineId(134);
			medicine.setMedicineName("crosin");
			medicine.setMedicineCost(200);
			
	        Mockito.when(medicineRepository.findById(134).get()).thenReturn(medicine);
	        medicine.setMedicineName("Calcium");
	        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
	        assertThat(medicineService.updateMedicineById(134)).isEqualTo(medicine);

  }

  @Test 
  void testGetAllMedicines() { 
	  Medicine medicine = new Medicine();    
	  medicine.setMedicineId(1345);
		medicine.setMedicineName("Calcium");
		medicine.setMedicineCost(300);
	  
		  Medicine med = new Medicine();
		    med.setMedicineId(134);
		    med.setMedicineName("crosin");
		    med.setMedicineCost(200);
		    
      List<Medicine> medicineList = new ArrayList<>();
      medicineList.add(medicine);
      medicineList.add(med);

      Mockito.when(medicineRepository.findAll()).thenReturn(medicineList);
      assertThat(medicineService.getAllMedicines()).isEqualTo(medicineList);
  }
}
