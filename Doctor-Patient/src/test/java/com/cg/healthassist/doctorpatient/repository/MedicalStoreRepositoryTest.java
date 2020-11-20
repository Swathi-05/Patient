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
import com.cg.healthassist.doctorpatient.entity.MedicalStore;

    /** This class is for MedicalStore Repository Test
     * 
     * @author Swathi
     * 
     **/

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class MedicalStoreRepositoryTest {

	 @Autowired
	 private MedicalStoreRepository medicalStoreRepository;

	 @Autowired
	 private TestEntityManager testEntityManager;

	    /** This method is to test add MedicalStore in the repository class */
	    
	 @Test
	 void testAddMedicalStore() throws Exception{
	     MedicalStore medicalStore = getMedicalStore();
	     MedicalStore saveInDb = testEntityManager.persist(medicalStore);
	     MedicalStore getInDb = medicalStoreRepository.findById(saveInDb.getStoreId()).get();
		 assertThat(getInDb).isEqualTo(saveInDb);
	 }
	
	 private MedicalStore getMedicalStore() {
	    MedicalStore medicalStore = new MedicalStore();
	    medicalStore.setStoreId(564);
		medicalStore.setStoreName("MedPlus");
		medicalStore.setStoreAddress("Whitefield, Bangalore");
		return(medicalStore);
	 }

	    /** This method is to test  get MedicalStore in repository class**/
	    
	  @Test
	  void testGetStoreById() throws Exception{
	     MedicalStore medicalStore = new MedicalStore();
	 	 medicalStore.setStoreId(584);
	 	 medicalStore.setStoreName("Apollo Pharmacy");
	 	 medicalStore.setStoreAddress("Btm Layout, Bangalore");
	 		
	 	 MedicalStore saveInDb = testEntityManager.persist(medicalStore);
	 	 MedicalStore getInDb = medicalStoreRepository.findById(medicalStore.getStoreId()).get();        
	     assertThat(getInDb).isEqualTo(saveInDb);
	  }

	    /** This method is to test  getAll MedicalStore in repository class**/
	    
	   @Test
	   void testGetAllMedicalStores() throws Exception{
	       MedicalStore medicalStore = new MedicalStore();
	  	   medicalStore.setStoreId(584);
	  	   medicalStore.setStoreName("Apollo Pharmacy");
	  	   medicalStore.setStoreAddress("Btm Layout, Bangalore");
	  	  
	  	   MedicalStore ms = new MedicalStore();
	  	   ms.setStoreId(568);
	  	   ms.setStoreName("Pharmacy");
	  	   ms.setStoreAddress("maratahalli, Bangalore");
	  		
	  	   testEntityManager.persist(medicalStore);
		   testEntityManager.persist(ms);
		   List<MedicalStore> medicalStoreList = (List<MedicalStore>) medicalStoreRepository.findAll();
		   Assert.assertEquals(2, medicalStoreList.size());
	   }
}
