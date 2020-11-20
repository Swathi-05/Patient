package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**this is entity class for medicine with getters and setters
 * 
 * @author Swathi
 * 
 * **/

@Entity
@Table(name = "MEDICINE")

public class Medicine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int medicineId;
	@Column
	private String medicineName;
	@Column
	private long medicineCost;
	
	public Medicine() {
		super();
	}
	
	public Medicine(int medicineId, String medicineName, long medicineCost) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public long getMedicineCost() {
		return medicineCost;
	}

	public void setMedicineCost(long medicineCost) {
		this.medicineCost = medicineCost;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ medicineCost + "]";
	}

}
