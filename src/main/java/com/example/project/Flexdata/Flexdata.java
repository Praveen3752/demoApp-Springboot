package com.example.project.Flexdata;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class Flexdata {
	public String flag1;
	public String flag2;
	public String location;
	public String department;
	public String category;
	public String subcategory;
	public List<String> singlelist;
	public List<List<String>> doublelist;

	public String getFlag1() {
		return flag1;
	}

	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}

	public List<String> getSinglelist() {
		return singlelist;
	}

	public void setSinglelist(List<String> singlelist) {
		this.singlelist = singlelist;
	}

	public List<List<String>> getDoublelist() {
		return doublelist;
	}

	public void setDoublelist(List<List<String>> doublelist) {
		this.doublelist = doublelist;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getFlag2() {
		return flag2;
	}

	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	
	
}
