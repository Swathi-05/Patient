package com.cg.healthassist.doctorpatient.controller;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.healthassist.doctorpatient.entity.Medicine;
import com.cg.healthassist.doctorpatient.service.MedicineServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** This class is for Medicine controller Test
 * 
 * @author Swathi
 * 
 * */

@RunWith(SpringRunner.class)
@WebMvcTest(value = MedicineControl.class)
class MedicineControlTest {


	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private MedicineServiceImpl medicineService;

	    /** This method is to test add Medicine in the Controller class */
	    
	@Test
	void testAddMedicine() throws Exception {
		String URI = "/medicine/addMedicine";
		Medicine medicine = new Medicine();
		medicine.setMedicineId(1001);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);
        String jsonInput = this.converttoJson(medicine);

        Mockito.when(medicineService.addMedicine(Mockito.any(Medicine.class))).thenReturn(medicine);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);
      
	}


	  /** This method is to test cancel Medicine in the Controller class */
    
    @Test
     void testRemoveMedicineById() throws Exception{
        String URI = "/medicine/delete/{medicineId}";
        Medicine medicine = new Medicine();    
  	    medicine.setMedicineId(1345);
  		medicine.setMedicineName("Calcium");
  		medicine.setMedicineCost(300);
  		
	    Mockito.when(medicineService.cancelMedicineById(1345)).thenReturn(true);
	    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1345).accept(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertNotNull(jsonOutput);
    }

    /** This method is to test update Medicine in the Controller class */
    
    @Test
     void testUpdateMedicine() throws Exception{

        String URI = "/medicine/update/{medicineId}";
        Medicine medicine = new Medicine();
		medicine.setMedicineId(134);
		medicine.setMedicineName("crosin");
		medicine.setMedicineCost(200);
		
		String jsonInput = this.converttoJson(medicine);
        Mockito.when(medicineService.updateMedicineById(Mockito.any(),Mockito.anyString())).thenReturn(medicine);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI ,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);
    }
    
    /** This method is to test get Medicine in the Controller class */
    
	@Test
    void testGetMedicineById() throws Exception{
       String URI= "/medicine/get/{medicineId}";
       Medicine medicine = new Medicine();
	   medicine.setMedicineId(134);
	   medicine.setMedicineName("crosin");
	   medicine.setMedicineCost(200);

       Mockito.when(medicineService.findMedicineById(Mockito.any())).thenReturn(medicine);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();
       assertNotNull(jsonOutput);
   }

	  /** This method is to test getAll Medicine in the Controller class */
    
	@Test
	void testGetAllMedicines() throws Exception {
		String URI = "/medicine/getall";
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

        Mockito.when(medicineService.getAllMedicines()).thenReturn(medicineList);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);

	}

	  /**
    * Convert Object into Json String by using Jackson ObjectMapper
    * @param ticket
    * @return
    * @throws JsonProcessingException
    */
   private String converttoJson(Object medicine) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.writeValueAsString(medicine);
   }

}
