package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** this is entity class for doctor with getters and setters
 * 
 * @author swathi
 * 
 * */

@Entity
@Table(name = "DOCTOR")
public class Doctor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    
	@Id
	@Column
	private int doctorId;
	@Column
	private String doctorName;
	@Column
	private String doctorSpeciality;
	@Column
	private int doctorExperience;

	public Doctor(){
		super();
	}
	
		public Doctor(int doctorId, String doctorName, String doctorSpeciality, int doctorExperience) {
			super();
			this.doctorId = doctorId;
			this.doctorName = doctorName;
			this.doctorSpeciality = doctorSpeciality;
			this.doctorExperience = doctorExperience;
		}


		public int getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}

		public String getDoctorName() {
			return doctorName;
		}

		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public String getDoctorSpeciality() {
			return doctorSpeciality;
		}

		public void setDoctorSpeciality(String doctorSpeciality) {
			this.doctorSpeciality = doctorSpeciality;
		}

		public int getDoctorExperience() {
			return doctorExperience;
		}

		public void setDoctorExperience(int doctorExperience) {
			this.doctorExperience = doctorExperience;
		}

		@Override
		public String toString() {
			return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpeciality="
					+ doctorSpeciality + ", doctorExperience=" + doctorExperience + "]";
		}
		
}
