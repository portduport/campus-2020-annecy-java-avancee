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
    private String model;
 
    public Car() {
 
    }
 
	public Car(String brand, String model) {
		this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
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
 
    public String getModel() {
        return model;
    }
 
    public void setModel(String model) {
        this.model = model;
    }

    @Override

    public String toString(){
        return "Car{" +
                "id= " + id +
                ", brand= " + brand + '\'' +
                ", model= " + model + '}';
    }
 
}