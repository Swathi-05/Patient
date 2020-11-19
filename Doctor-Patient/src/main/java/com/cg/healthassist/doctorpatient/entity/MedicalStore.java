package com.cg.healthassist.doctorpatient.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
		private int StoreId;
	@Column
		private String StoreName;
	@Column
		private String StoreAddress;
	
	public MedicalStore() {
		super();
	}
	

    public MedicalStore(int storeId, String storeName, String storeAddress) {
	    super();
	    this.StoreId = storeId;
	    this.StoreName = storeName;
	    this.StoreAddress = storeAddress;
    }

	public int getStoreId() {
		return StoreId;
	}

	public void setStoreId(int storeId) {
		StoreId = storeId;
	}

	public String getStoreName() {
		return StoreName;
	}

	public void setStoreName(String storeName) {
		StoreName = storeName;
	}

	public String getStoreAddress() {
		return StoreAddress;
	}

	public void setStoreAddress(String storeAddress) {
		StoreAddress = storeAddress;
	}


	@Override
	public String toString() {
		return "MedicalStore [StoreId=" + StoreId + ", StoreName=" + StoreName + ", StoreAddress=" + StoreAddress + "]";
	}


}
		