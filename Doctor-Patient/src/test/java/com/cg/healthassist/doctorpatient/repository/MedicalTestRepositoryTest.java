package com.cg.healthassist.doctorpatient.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.healthassist.doctorpatient.entity.MedicalTest;

/** This class is for MedicalTest Repository Test
 * 
 * @author Swathi
 * 
 * */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class MedicalTestRepositoryTest {

	 @Autowired
	 private MedicalTestRepository medicalTestRepository;

	 @Autowired
	 private TestEntityManager testEntityManager;

	 /** This method is to test add MedicalTest in the repository class */
	 
	  @Test
	  void testaddMedicalTest() throws Exception{
	    	MedicalTest medicalTest = getMedicalTest();
	    	MedicalTest saveInDb = testEntityManager.persist(medicalTest);
	    	MedicalTest getInDb = medicalTestRepository.findById(saveInDb.getMedicalTestId()).get();
		    assertThat(getInDb).isEqualTo(saveInDb);
	  }
	
	   private MedicalTest getMedicalTest() {
	        MedicalTest medicalTest = new MedicalTest();
	 	    medicalTest.setMedicalTestId(5246);
	 		medicalTest.setMedicalTestName("BloodTest");
	 		medicalTest.setMedicalTestCost(800);
	 		return(medicalTest);
		}

	   /** This method is to test get MedicalTest by id in the repository class */
	   
		@Test
	    void testGetMedicalTestById() throws Exception{
			MedicalTest medicalTest = new MedicalTest();
			medicalTest.setMedicalTestId(524);
			medicalTest.setMedicalTestName("diabetis");
			medicalTest.setMedicalTestCost(800);
			
			MedicalTest saveInDb = testEntityManager.persist(medicalTest);
			MedicalTest getInDb = medicalTestRepository.findById(medicalTest.getMedicalTestId()).get();        
	        assertThat(getInDb).isEqualTo(saveInDb);
	    }

		 /** This method is to test getAll MedicalTest in the repository class */
		
	    @Test
	     void testGetAllMedicalTests() throws Exception{
	    	
	    	MedicalTest medicalTest = new MedicalTest();
	        medicalTest.setMedicalTestId(624);
			medicalTest.setMedicalTestName("diabetes");
			medicalTest.setMedicalTestCost(2000);

	        MedicalTest mt = new MedicalTest();
	        mt.setMedicalTestId(524);
	        mt.setMedicalTestName("BloodTest");
	        mt.setMedicalTestCost(800);
	  	
		    testEntityManager.persist(medicalTest);
		    testEntityManager.persist(mt);

		    List<MedicalTest> medicalTestList = (List<MedicalTest>) medicalTestRepository.findAll();
		    Assert.assertEquals(2, medicalTestList.size());
	    }
}
