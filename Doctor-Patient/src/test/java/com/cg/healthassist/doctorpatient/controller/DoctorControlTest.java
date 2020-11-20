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
import com.cg.healthassist.doctorpatient.entity.Doctor;
import com.cg.healthassist.doctorpatient.service.DoctorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** This class is for Doctor Controller Test
 * 
 * @author Swathi
 * 
 * */

@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorControl.class)
class DoctorControlTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private DoctorServiceImpl doctorService;

	    /** This method is to test add Doctor in the Controller class */
	    
	@Test
	void testAddDoctor() throws Exception {
		String URI = "/Doctor/addDoctor";
        Doctor doctor = new Doctor();
        doctor.setDoctorId(100);
		doctor.setDoctorName("Kumar");
		doctor.setDoctorSpeciality("Dermatologist");
		doctor.setDoctorExperience(6);
        String jsonInput = this.converttoJson(doctor);

        Mockito.when(doctorService.addDoctor(Mockito.any(Doctor.class))).thenReturn(doctor);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	/** This method is to test get Doctor in the Controller class */
	
	@Test
     void testGetDoctorById() throws Exception{
        String URI= "/Doctor/getDoctorById/{DoctorId}";
        Doctor doctor = new Doctor();
  	    doctor .setDoctorId(126);
  	    doctor .setDoctorName("Ram");
  	    doctor .setDoctorSpeciality("cardiologist");
  	    doctor .setDoctorExperience(6);

        Mockito.when(doctorService.findDoctorById(Mockito.any())).thenReturn(doctor);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);
     
    }

	/** This method is to test getAll Doctor in the Controller class */
	
	@Test
	void testGetAllDoctors() throws Exception {
		String URI = "/Doctor/getAllDoctors";
		 Doctor doctor = new Doctor();
		 doctor.setDoctorId(126);
		 doctor.setDoctorName("Ram");
		 doctor.setDoctorSpeciality("cardiologist");
		 doctor.setDoctorExperience(6);
		  
		 Doctor doc = new Doctor();
		 doc.setDoctorId(758);
		 doc.setDoctorName("Sam");
		 doc.setDoctorSpeciality("neurologist");
		 doc.setDoctorExperience(6);
		  
		 Doctor d = new Doctor();
		 d.setDoctorId(741);
		 d.setDoctorName("john");
		 d.setDoctorSpeciality("psychiatrists");
		 d.setDoctorExperience(6);
		  
	     List<Doctor> doctorList = new ArrayList<>();
	     doctorList.add(doctor);
	     doctorList.add(doc);
	     doctorList.add(d);
	      
         String jsonInput = this.converttoJson(doctorList);
 
         Mockito.when(doctorService.getAllDoctors()).thenReturn(doctorList);
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
	
    private String converttoJson(Object doctor) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(doctor);
    }

}
