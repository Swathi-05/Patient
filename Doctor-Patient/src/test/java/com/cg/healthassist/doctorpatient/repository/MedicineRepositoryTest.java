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
import com.cg.healthassist.doctorpatient.entity.Medicine;

/** This class is for Medicine Repository Test
 * 
 * @author Swathi
 * 
 * */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class MedicineRepositoryTest {

		    @Autowired
		    private MedicineRepository medicineRepository;

		    @Autowired
		    private TestEntityManager testEntityManager;

		    /** This method is to test add medicine in the repository class */
		    
		    @Test
		    void testAddMedicine() {
				Medicine medicine = getMedicine();
				Medicine saveInDb = testEntityManager.persist(medicine);
				Medicine getInDb = medicineRepository.findById(medicine.getMedicineId()).get();
			    assertThat(getInDb).isEqualTo(saveInDb);
		    }

			private Medicine getMedicine() { 
				Medicine medicine = new Medicine();
				medicine.setMedicineId(1001);
				medicine.setMedicineName("crosin");
				medicine.setMedicineCost(200);
				return(medicine);
			}
	
			 /** This method is to test delete medicine by id in the repository class */
			
			@Test
			void testDeleteMedicineById()throws Exception{
				
			    Medicine medicine = new Medicine();    
				medicine.setMedicineId(1345);
				medicine.setMedicineName("Calcium");
				
			    medicine.setMedicineCost(300);		
				Medicine med = testEntityManager.persist(medicine);	       
				testEntityManager.remove(med);
				List<Medicine> m = (List<Medicine>) medicineRepository.findAll();
				Assert.assertEquals(0,m.size());
			}
				 
			 /** This method is to test update medicine by id in the repository class */
			
			@Test
			void testupdateMedicineById() throws Exception{

				Medicine medicine = new Medicine();
				medicine.setMedicineId(134);
				medicine.setMedicineName("crosin");
				medicine.setMedicineCost(200);
				testEntityManager.persist(medicine);
				Medicine getFromDb = medicineRepository.findById(medicine.getMedicineId()).get();
				getFromDb.setMedicineId(103);
				testEntityManager.persist(getFromDb);
				assertThat(getFromDb.getMedicineId()).isEqualTo(103);
			}

			 /** This method is to test get medicine by id in the repository class */
			
		    @Test
		    void testGetMedicineById() throws Exception{
		    	Medicine medicine = new Medicine();
		 		medicine.setMedicineId(134);
		 		medicine.setMedicineName("crosin");
		 		medicine.setMedicineCost(200);
		        
		 		Medicine saveInDb = testEntityManager.persist(medicine);
		 		Medicine getInDb = medicineRepository.findById(medicine.getMedicineId()).get();        
		        assertThat(getInDb).isEqualTo(saveInDb);
		    }
		    
		    /** This method is to test getAll medicine in the repository class */
		    
		    @Test
		     void testGetAllMedicines() throws Exception{
		    	  Medicine medicine = new Medicine();    
		    	  medicine.setMedicineId(1345);
		    	  medicine.setMedicineName("Calcium");
		    	  medicine.setMedicineCost(300);
		    	  
		    	  Medicine med = new Medicine();
		    	  med.setMedicineId(134);
		    	  med.setMedicineName("crosin");
		    	  med.setMedicineCost(200);
		    		    
			      testEntityManager.persist(medicine);
			      testEntityManager.persist(med);

			      List<Medicine> medicineList = (List<Medicine>) medicineRepository.findAll();
                  Assert.assertEquals(2, medicineList.size());
		    }
}
