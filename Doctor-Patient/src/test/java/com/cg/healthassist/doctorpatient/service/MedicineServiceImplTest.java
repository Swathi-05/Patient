package com.cg.healthassist.doctorpatient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
import com.cg.healthassist.doctorpatient.exception.MedicineNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicineRepository;

/** This class is for medicine Service Implementation Test
 * 
 * @author Swathi
 * 
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class MedicineServiceImplTest {

    @MockBean
    private MedicineRepository medicineRepository;

    @Autowired
    private MedicineServiceImpl medicineService;

    /** This method is to test add medicine in the Service implementation class **/
    
	@Test
	void testaddMedicine() {
		Medicine medicine = new Medicine();
		medicine.setMedicineId(1001);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);
		
        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
        assertThat(medicineService.addMedicine(medicine)).isEqualTo(medicine);
	}

	/** This method is to test get medicine by id in the Service implementation class **/
	
  @Test 
  void testGetMedicineById() throws MedicineNotFoundException { 
	    Medicine medicine = new Medicine();
		medicine.setMedicineId(134);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);	
		assertThat(medicine.getMedicineId()).isEqualTo(134);
  }
 
  /** This method is to test remove medicine by id in the Service implementation class **/
  
  @Test
   void testremoveMedicineById() throws Exception{
	    Medicine medicine = new Medicine();    
	    medicine.setMedicineId(1345);
		medicine.setMedicineName("Calcium");
		medicine.setMedicineCost(300);	
		medicineRepository.deleteById(medicine.getMedicineId());
	    Assert.assertTrue(medicineRepository.findById(1345).isEmpty());   
  }
  
  /** This method is to test getAll medicine in the Service implementation class **/
  
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
