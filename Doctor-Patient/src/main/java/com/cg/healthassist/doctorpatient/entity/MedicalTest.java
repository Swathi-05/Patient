package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**this is entity class for medical test with getters and setters*
 * 
 * 
 * @author Swathi
 * 
 * */

@Entity
@Table(name = "MEDICALTEST")
public class MedicalTest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)   
	@NotNull(message="Please provide Id value")
	private int medicalTestId;
	@Column(nullable = false)   
	@NotNull(message="Please provide medical test name")
	private String medicalTestName;
	@Column(nullable = false)   
	@NotNull(message="Please provide medical test cost")
	private long medicalTestCost;
	
	public MedicalTest() {
		super();
	}
	
	public MedicalTest(int medicalTestId, String medicalTestName, long medicalTestCost) {
		super();
		this.medicalTestId = medicalTestId;
		this.medicalTestName = medicalTestName;
		this.medicalTestCost = medicalTestCost;
	}
	public int getMedicalTestId() {
		return medicalTestId;
	}
	public void setMedicalTestId(int medicalTestId) {
		this.medicalTestId = medicalTestId;
	}
	public String getMedicalTestName() {
		return medicalTestName;
	}
	public void setMedicalTestName(String medicalTestName) {
		this.medicalTestName = medicalTestName;
	}
	public long getMedicalTestCost() {
		return medicalTestCost;
	}
	public void setMedicalTestCost(long medicalTestCost) {
		this.medicalTestCost = medicalTestCost;
	}

	@Override
	public String toString() {
		return "MedicalTest [medicalTestId=" + medicalTestId + ", medicalTestName=" + medicalTestName
				+ ", medicalTestCost=" + medicalTestCost +  "]";
	}

}