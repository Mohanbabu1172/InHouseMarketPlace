package com.cg.InHouseMarketPlace.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resId;
	private String title;
	private String description;
	private String category; // Service/Product/Help
	private LocalDate date;
	private String type; // Buy/Sell/Rent/Hire
	private double price;
	private int empId;

	
	public Resource(int i, String string, String string2, String string3, Date date2, String string4, float f, int j) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(int resId, String title, String description, String category, LocalDate date, String type,
			double price, int empId) {
		super();
		this.resId = resId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.date = date;
		this.type = type;
		this.price = price;
		this.empId = empId;
	}

	public Resource() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
