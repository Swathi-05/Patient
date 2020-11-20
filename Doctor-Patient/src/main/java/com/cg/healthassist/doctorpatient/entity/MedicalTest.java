package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column
	private int medicalTestId;
	@Column
	private String medicalTestName;
	@Column
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