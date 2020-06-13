package com.example.project.Service;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Bean.ProjectBean;
import com.example.project.Dao.ProjectDao;
import com.example.project.Flexdata.Flexdata;

@Service
public class ProjectService 
{

	@Autowired
	ProjectDao dao;
	
	
	
	public Flexdata getLocation() 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getLocation();
		return fd;
	}



	public Flexdata getLocationId(String locationid) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getLocationId(locationid);
		return fd;
	}



	public Flexdata getDepartment(String locationid) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getDepartment(locationid);
		return fd;
	
	}



	public Flexdata getDepartmentId(String locationid, String departmentid) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getDepartmentId(locationid,departmentid);
		return fd;
	}



	public Flexdata getCategory(String locationid, String departmentid) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getCategory(locationid,departmentid);
		return fd;
	}



	public Flexdata getCategoryId(String locationid, String departmentid, String categoryid) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getCategoryId(locationid,departmentid,categoryid);
		return fd;
	}



	public Flexdata locationfilter() 
	{
		Flexdata fd = new Flexdata();
		fd = dao.locationfilter();
		return fd;
	}



	public Flexdata departmentfilter() 
	{
		Flexdata fd = new Flexdata();
		fd = dao.departmentfilter();
		return fd;
	}



	public Flexdata categoryfilter() 
	{
		Flexdata fd = new Flexdata();
		fd = dao.categoryfilter();
		return fd;
	}



	public Flexdata subcategoryfilter() 
	{
		Flexdata fd = new Flexdata();
		fd = dao.subcategoryfilter();
		return fd;
	}



	public Flexdata getdata(String location,String department,String category,String subcategory) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.getdata(location,department,category,subcategory);
		return fd;
	}



	public Flexdata deletedata(String name) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.deletedata(name);
		return fd;
	}



	public Flexdata createrecord(ProjectBean bean)
	{
		Flexdata fd = new Flexdata();
		fd = dao.createrecord(bean);
		return fd;

	}



	public Flexdata editrecord(ProjectBean bean) 
	{
		Flexdata fd = new Flexdata();
		fd = dao.editrecord(bean);
		return fd;
	}
	
}
