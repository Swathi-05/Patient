package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**this is entity class for Medical Store with getters and setters
 * 
 * 
 * @author Swathi
 * 
 * **/

@Entity
@Table(name = "MEDICALSTORE")
public class MedicalStore implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)   
	@NotNull(message="Please provide Id value")
	private int storeId;
	@Column(nullable = false)   
	@NotNull(message="Please provide store name")
	private String storeName;
	@Column(nullable = false)   
	@NotNull(message="Please provide store address")
	private String storeAddress;
	
	public MedicalStore() {
		super();
	}
	

    public MedicalStore(int storeId, String storeName, String storeAddress) {
	    super();
	    this.storeId = storeId;
	    this.storeName = storeName;
	    this.storeAddress = storeAddress;
    }


	public int getStoreId() {
		return storeId;
	}


	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreAddress() {
		return storeAddress;
	}


	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}


	@Override
	public String toString() {
		return "MedicalStore [storeId=" + storeId + ", storeName=" + storeName + ", storeAddress=" + storeAddress + "]";
	}
	
}

		