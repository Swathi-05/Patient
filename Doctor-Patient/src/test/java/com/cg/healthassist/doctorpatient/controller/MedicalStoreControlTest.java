package com.cg.healthassist.doctorpatient.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.healthassist.doctorpatient.entity.MedicalStore;
import com.cg.healthassist.doctorpatient.service.MedicalStoreServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/** This class is for MedicalStore controller Test
 * 
 * @author Swathi
 * 
 * */

@RunWith(SpringRunner.class)
@WebMvcTest(value = MedicalStoreControl.class)
class MedicalStoreControlTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private MedicalStoreServiceImpl medicalStoreService;

	    /** This method is to test add MedicalStore in the Controller class */
	    
	@Test
	void testAddMedicalStore() throws Exception {
	    String URI = "/medicalStore/add";
		MedicalStore medicalStore = new MedicalStore();
		medicalStore.setStoreId(564);
		medicalStore.setStoreName("MedPlus");
		medicalStore.setStoreAddress("Whitefield, Bangalore");
        String jsonInput = this.converttoJson(medicalStore);

        Mockito.when(medicalStoreService.addMedicalStore(Mockito.any(MedicalStore.class))).thenReturn(medicalStore);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	 /** This method is to test get MedicalStore in the Controller class */
	
	@Test
    void testGetMedicalStoreById() throws Exception{
       String URI= "/medicalStore/get/{storeId}";
       MedicalStore medicalStore = new MedicalStore();
	   medicalStore.setStoreId(584);
	   medicalStore.setStoreName("Apollo Pharmacy");
	   medicalStore.setStoreAddress("Btm Layout, Bangalore");

       Mockito.when(medicalStoreService.findStoreById(Mockito.any())).thenReturn(medicalStore);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();
       assertNotNull(jsonOutput);
       
   }

	/** This method is to test getAll MedicalStore in the Controller class */

	@Test
	void testGetAllMedicalStores() throws Exception {
		String URI = "/medicalStore/getall";
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
	      
         Mockito.when(medicalStoreService.getAllMedicalStores()).thenReturn(medicalStoreList);
         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
         String jsonOutput = mockHttpServletResponse.getContentAsString();
         assertNotNull(jsonOutput);
         Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}

	  /**
    * Convert Object into Json String by using Jackson ObjectMapper
    * @param ticket
    * @return
    * @throws JsonProcessingException
    */
	
   private String converttoJson(Object medicalStore) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.writeValueAsString(medicalStore);
   }

}
