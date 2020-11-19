package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** this is entity class for doctor with getters and setters
 * 
 * @author swathi
 * 
 * */

@Entity
@Table(name = "Doctor")

public class Doctor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column
		private int DoctorId;
	@Column
		private String DoctorName;
	@Column
		private String DoctorSpeciality;
	@Column
		private int Experience;
	
	public Doctor(){
		super();
	}
	
		public Doctor(int doctorId, String doctorName, String doctorSpeciality, int experience) {
			super();
			this.DoctorId = doctorId;
			this.DoctorName = doctorName;
			this.DoctorSpeciality = doctorSpeciality;
			this.Experience = experience;
		}

		public int getDoctorId() {
			return DoctorId;
		}
		public void setDoctorId(int doctorId) {
			DoctorId = doctorId;
		}
		public String getDoctorName() {
			return DoctorName; 
		}
		public void setDoctorName(String doctorName) {
			DoctorName = doctorName;
		}
		public String getDoctorSpeciality() {
			return DoctorSpeciality;
		}
		public void setDoctorSpeciality(String doctorSpeciality) {
			DoctorSpeciality = doctorSpeciality;
		}
		public int getExperience() {
			return Experience;
		}
		public void setExperience(int experience) {
			Experience = experience;
		}

		@Override
		public String toString() {
			return "Doctor [DoctorId=" + DoctorId + ", DoctorName=" + DoctorName + ", DoctorSpeciality="
					+ DoctorSpeciality + ", Experience=" + Experience + "]";
		}

}
