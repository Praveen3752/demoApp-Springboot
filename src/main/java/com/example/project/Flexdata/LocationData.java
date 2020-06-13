package com.example.project.Flexdata;


public class LocationData 
{
	  public LocationData(String data,String flag) 
	  { 
		  if(flag.equalsIgnoreCase("location"))
		  {
			  this.location = data;
		  }
		  else if(flag.equalsIgnoreCase("department"))
		  {
			  this.department = data;
		  }
		  else if(flag.equalsIgnoreCase("category"))
		  {
			  this.category = data;
		  }
	  }
	  
	  public LocationData(String namedata,String locationdata,String departmentdata,String categorydata,String subcategorydata)
	  {
		  this.name = namedata;
		  this.location = locationdata;
		  this.department = departmentdata;
		  this.category = categorydata;
		  this.subcategory = subcategorydata;
	  }
	 
	
	public String name;
	public String location;
	public String department;
	public String category;
	public String subcategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	
}
