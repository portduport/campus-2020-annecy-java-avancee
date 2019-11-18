package com.campus2020.projetJavaAvancee.model;


import java.util.UUID;

/**
 *
 */
public class Car {
    /**
     *
     */
	private String id;
    private String brand;
    private String version;
 
    public Car() {
 
    }
 
	public Car(String brand, String version) {
		this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.version = version;
    }
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
 
    public String getBrand() {
        return brand;
    }
 
    public void setBrand(String brand) {
        this.brand = brand;
    }
 
    public String getVersion() {
        return version;
    }
 
    public void setVersion(String version) {
        this.version = version;
    }

    @Override

    public String toString(){
        return "Car{" +
                "id= " + id +
                ", brand= " + brand + '\'' +
                ", version= " + version + '}';
    }
 
}