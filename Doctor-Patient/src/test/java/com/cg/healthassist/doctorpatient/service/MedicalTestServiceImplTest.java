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

import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.exception.MedicalTestNotFoundException;
import com.cg.healthassist.doctorpatient.repository.MedicalTestRepository;
import com.cg.healthassist.doctorpatient.serviceImpl.MedicalTestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class MedicalTestServiceImplTest {

    @MockBean
    private MedicalTestRepository medicalTestRepository;

    @Autowired
    private MedicalTestServiceImpl medicalTestService;

	@Test
	void testaddMedicalTest() {
		MedicalTest medicalTest = new MedicalTest();
		medicalTest.setMedicalTestId(524);
		medicalTest.setMedicalTestName("BloodTest");
		medicalTest.setMedicalTestCost(800);

        Mockito.when(medicalTestRepository.save(medicalTest)).thenReturn(medicalTest);
        assertThat(medicalTestService.addMedicalTest(medicalTest)).isEqualTo(medicalTest);
	}

  @Test 
  void testGetMedicalTestById() throws MedicalTestNotFoundException { 
	  MedicalTest medicalTest = new MedicalTest();
	    medicalTest.setMedicalTestId(5246);
		medicalTest.setMedicalTestName("BloodTest");
		medicalTest.setMedicalTestCost(800);
		

		assertThat(medicalTest.getMedicalTestId()).isEqualTo(5246);
  }
 
  @Test 
  void testGetAllMedicalTests() { 
	  MedicalTest medicalTest = new MedicalTest();
	        medicalTest.setMedicalTestId(624);
			medicalTest.setMedicalTestName("diabetes");
			medicalTest.setMedicalTestCost(2000);

	  MedicalTest medT = new MedicalTest();
	        medT.setMedicalTestId(5246);
	        medT.setMedicalTestName("BloodTest");
	        medT.setMedicalTestCost(800);
	  MedicalTest mt = new MedicalTest();
	      mt.setMedicalTestId(524);
	      mt.setMedicalTestName("BloodTest");
	      mt.setMedicalTestCost(800);

      List<MedicalTest> medicalTestList = new ArrayList<>();
      medicalTestList.add(medicalTest);
      medicalTestList.add(medT);
      medicalTestList.add(mt);

      Mockito.when(medicalTestRepository.findAll()).thenReturn(medicalTestList);
      assertThat(medicalTestService.getAllMedicalTests()).isEqualTo(medicalTestList);
  }
}