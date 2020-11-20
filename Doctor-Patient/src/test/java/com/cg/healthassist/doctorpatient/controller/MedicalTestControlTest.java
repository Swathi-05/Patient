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

import com.cg.healthassist.doctorpatient.entity.MedicalTest;
import com.cg.healthassist.doctorpatient.service.MedicalTestServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** This class is for MedicalTest controller Test
 * 
 * @author Swathi
 * 
 * */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MedicalTestControl.class)
class MedicalTestControlTest {


	 @Autowired
	 private MockMvc mockMvc;

	 @MockBean
	 private MedicalTestServiceImpl medicalTestService;

	    /** This method is to test add MedicalTest in the Controller class */
	    
	@Test
	void testAddMedicalTest() throws Exception {
		String URI = "/MedicalTest/addMedicalTest";
		MedicalTest medicalTest = new MedicalTest();
		medicalTest.setMedicalTestId(524);
		medicalTest.setMedicalTestName("BloodTest");
		medicalTest.setMedicalTestCost(800);
        String jsonInput = this.converttoJson(medicalTest);

        Mockito.when(medicalTestService.addMedicalTest(Mockito.any(MedicalTest.class))).thenReturn(medicalTest);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	/** This method is to test get MedicalTest in the Controller class */
	
	@Test
    void testGetMedicalTestById() throws Exception{
      String URI= "/MedicalTest/getMedicalTestById/{TestId}";
      MedicalTest medicalTest = new MedicalTest();
      medicalTest.setMedicalTestId(5246);
      medicalTest.setMedicalTestName("BloodTest");
      medicalTest.setMedicalTestCost(800);

      Mockito.when(medicalTestService.findMedicalTestById(Mockito.any())).thenReturn(medicalTest);
      MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
      MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
      String jsonOutput = mockHttpServletResponse.getContentAsString();
      assertNotNull(jsonOutput);
      
  }

	/** This method is to test getAll MedicalTest in the Controller class */

	@Test
	void testGetAllMedicalTests() throws Exception {
		 String URI = "/MedicalTest/getAllMedicalTests";
		 MedicalTest medicalTest = new MedicalTest();
	     medicalTest.setMedicalTestId(624);
	     medicalTest.setMedicalTestName("diabetes");
		 medicalTest.setMedicalTestCost(2000);
			
		 MedicalTest mt = new MedicalTest();
		 mt.setMedicalTestId(524);
		 mt.setMedicalTestName("BloodTest");
		 mt.setMedicalTestCost(800);

	     List<MedicalTest> medicalTestList = new ArrayList<>();
	     medicalTestList.add(medicalTest);
	     medicalTestList.add(mt);
	      
         String jsonInput = this.converttoJson(medicalTestList);

         Mockito.when(medicalTestService.getAllMedicalTests()).thenReturn(medicalTestList);
         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
         String jsonOutput = mockHttpServletResponse.getContentAsString();
         assertThat(jsonInput).isEqualTo(jsonOutput);
         Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}

	  /**
   * Convert Object into Json String by using Jackson ObjectMapper
   * @param ticket
   * @return
   * @throws JsonProcessingException
   */
  private String converttoJson(Object medicalTest) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(medicalTest);
  }


}
