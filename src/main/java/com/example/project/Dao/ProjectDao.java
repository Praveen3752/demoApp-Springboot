package com.example.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Bean.ProjectBean;
import com.example.project.Flexdata.Flexdata;
@Repository
public class ProjectDao 
{
	@Autowired
	DataSource datasource;
	
	public Flexdata getLocation() 
	{
		
		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select distinct location from grocery");
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		//fd.setSinglelist(ls);
		doubledata.add(ls);
		fd.setDoublelist(doubledata);
		return fd;
	}

	public Flexdata getLocationId(String locationid) 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from grocery g where g.location = ?");
		ps.setString(1, locationid);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	
	}

	public Flexdata getDepartment(String locationid) 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select distinct department from grocery g where g.location = ?");
		ps.setString(1, locationid);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata getDepartmentId(String locationid, String departmentid) 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from grocery g where g.location = ? and g.department = ?");
		ps.setString(1, locationid);
		ps.setString(2, departmentid);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata getCategory(String locationid, String departmentid) 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select distinct category from grocery g where g.location = ? and g.department = ?");
		ps.setString(1, locationid);
		ps.setString(2, departmentid);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata getCategoryId(String locationid, String departmentid, String categoryid) 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from grocery g where g.location = ? and g.department = ? and g.category = ?");
		ps.setString(1, locationid);
		ps.setString(2, departmentid);
		ps.setString(3, categoryid);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	//filter data
	
	
	public Flexdata locationfilter() 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try(Connection con = datasource.getConnection();PreparedStatement ps = con.prepareStatement("select distinct location from grocery");)
		{
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata departmentfilter() 
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try(Connection con = datasource.getConnection();PreparedStatement ps = con.prepareStatement("select distinct department from grocery");)
		{
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata categoryfilter()
	{

		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try(Connection con = datasource.getConnection();PreparedStatement ps = con.prepareStatement("select distinct category from grocery");)
		{
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	

	}

	public Flexdata subcategoryfilter() 
	{
		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try(Connection con = datasource.getConnection();PreparedStatement ps = con.prepareStatement("select distinct subcategory from grocery");)
		{
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	
	}

	public Flexdata getdata(String location,String department,String category,String subcategory) 
	{
		Flexdata fd = new Flexdata();
		List<String> ls = new ArrayList<String>();
		List<List<String>> doubledata = new ArrayList<List<String>>();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try
		{
		Connection con = datasource.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from grocery g where g.location = ? or g.department = ? or g.category = ? or g.subcategory = ?");
		ps.setString(1, location);
		ps.setString(2, department);
		ps.setString(3, category);
		ps.setString(4, subcategory);
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		if(rs!=null)
		{
				while(rs.next())
				{
					ls = new ArrayList<String>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						ls.add(rs.getString(i));
					}
					doubledata.add(ls);
				}
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		fd.setDoublelist(doubledata);
		return fd;
	
	}

	public Flexdata deletedata(String name) 
	{
		Flexdata fd = new Flexdata();
		int result;
		try(Connection con = datasource.getConnection();)
		{
		PreparedStatement ps = con.prepareStatement("delete from grocery g where g.sku = ?");
		ps.setString(1,name);
		result  = ps.executeUpdate();
		
		if(result == 1)
		{
			fd.setFlag1("Deleted Successfully!!!");
		}
		else
		{
			fd.setFlag1("Could not delete the record");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		return fd;
	
	}

	public Flexdata createrecord(ProjectBean bean) 
	{
		Flexdata fd = new Flexdata();
		int result;
		try(Connection con = datasource.getConnection())
		{
		PreparedStatement ps = con.prepareStatement("insert into grocery values(?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getLocation());
		ps.setString(3,bean.getDepartment());
		ps.setString(4,bean.getCategory());
		ps.setString(5,bean.getSubcategory());
		result  = ps.executeUpdate();
		
		if(result == 1)
		{
			fd.setFlag1("Inserted Successfully!!!");
		}
		else
		{
			fd.setFlag1("Could not insert the record");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		return fd;
	
	}

	public Flexdata editrecord(ProjectBean bean) 
	{
		Flexdata fd = new Flexdata();
		int result;
		try(Connection con = datasource.getConnection())
		{
		PreparedStatement ps = con.prepareStatement("update grocery set location = ?,department = ? , category = ? , subcategory = ? where sku = ?");
		ps.setString(1,bean.getLocation());
		ps.setString(2,bean.getDepartment());
		ps.setString(3,bean.getCategory());
		ps.setString(4,bean.getSubcategory());
		ps.setString(5,bean.getName());
		result  = ps.executeUpdate();
		
		if(result == 1)
		{
			fd.setFlag1("Updated Successfully!!!");
		}
		else
		{
			fd.setFlag1("Could not update the record");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e);
		}
		return fd;
	
	}

}
