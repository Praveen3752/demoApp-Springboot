package com.example.project.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.Bean.ProjectBean;
import com.example.project.Flexdata.Flexdata;
import com.example.project.Flexdata.LocationData;
import com.example.project.Security.JwtTokenUtil;
import com.example.project.Service.ProjectDetails;
import com.example.project.Service.ProjectService;
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController
{
	@Autowired
	Flexdata flexdata;
	
	@Autowired
	ProjectService service;
	
	
	@Autowired
	DataSource datasource;

	@Autowired
	ProjectDetails details;
	
	@Autowired
	JwtTokenUtil tokenjwt;
	
	
	@RequestMapping("/errormsg")
	@ResponseBody
	public Flexdata errormsg()
	{
		Flexdata fd = new Flexdata();
		System.out.println("correct ga ne work avtundi roooo");
		return fd;
	}
	
	@RequestMapping("/home")
	@ResponseBody
	public Flexdata getDatata()
	{
	//	System.out.println(title);
	//	final String token = jwtTokenUtil.generateToken(userDetails);
		String output = details.username;
		System.out.println(output);
		final String token = tokenjwt.generateToken(output);
		System.out.println(token);
		flexdata.setFlag1("Success");
		flexdata.setFlag2(token);
		return flexdata;
	}
	
	
	/*
	 * @RequestMapping("/{id}")
	 * 
	 * @ResponseBody public Flexdata getURLData(@PathVariable("id") String title) {
	 * System.out.println(title); flexdata.setFlag1("Success"); return flexdata; }
	 */
	@RequestMapping("/location")
	@ResponseBody
	public List<LocationData> getLocation()
	{
		List<Flexdata> fdlist = new ArrayList<Flexdata>();
		Flexdata fd = new Flexdata();
		fd = service.getLocation();
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),"location"));
		}
		
		return ld;
	}
	
	@RequestMapping("/location/{locationid}")
	@ResponseBody
	public List<LocationData> getLocationId(@PathVariable("locationid") String locationid)
	{
		Flexdata fd = new Flexdata();
		fd = service.getLocationId(locationid);
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),fd.getDoublelist().get(i).get(1),fd.getDoublelist().get(i).get(2),fd.getDoublelist().get(i).get(3),fd.getDoublelist().get(i).get(4)));
		}
		return ld;
	}
	
	
	@RequestMapping("/location/{locationid}/department")
	@ResponseBody
	public List<LocationData> getDepartment(@PathVariable("locationid") String locationid)
	{
		Flexdata fd = new Flexdata();
		fd = service.getDepartment(locationid);
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),"department"));
		}
		return ld;
	}
	
	@RequestMapping("/location/{locationid}/department/{departmentid}")
	@ResponseBody
	public List<LocationData> getDepartmentId(@PathVariable("locationid") String locationid,@PathVariable("departmentid") String departmentid)
	{
		Flexdata fd = new Flexdata();
		fd = service.getDepartmentId(locationid,departmentid);
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),fd.getDoublelist().get(i).get(1),fd.getDoublelist().get(i).get(2),fd.getDoublelist().get(i).get(3),fd.getDoublelist().get(i).get(4)));
		}
		return ld;
	}
	
	@RequestMapping("/location/{locationid}/department/{departmentid}/category")
	@ResponseBody
	public List<LocationData> getCategory(@PathVariable("locationid") String locationid,@PathVariable("departmentid") String departmentid)
	{
		Flexdata fd = new Flexdata();
		fd = service.getCategory(locationid,departmentid);
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),"category"));
		}
		return ld;
	}
	
	@RequestMapping("/location/{locationid}/department/{departmentid}/category/{categoryid}")
	@ResponseBody
	public List<LocationData> getCategoryId(@PathVariable("locationid") String locationid,@PathVariable("departmentid") String departmentid,@PathVariable("categoryid") String categoryid)
	{
		Flexdata fd = new Flexdata();
		fd = service.getCategoryId(locationid,departmentid,categoryid);
		List<LocationData> ld = new ArrayList<LocationData>();
		for(int i=0;i<fd.getDoublelist().size();i++)
		{
			ld.add(new LocationData(fd.getDoublelist().get(i).get(0),fd.getDoublelist().get(i).get(1),fd.getDoublelist().get(i).get(2),fd.getDoublelist().get(i).get(3),fd.getDoublelist().get(i).get(4)));
		}
		return ld;
	}
	
	
	
	//------filter data-----

	@RequestMapping("/locationfilter")
	@Transactional
	@ResponseBody
	public Flexdata locationfilter()
	{
		Flexdata fd = new Flexdata();
		fd = service.locationfilter();
		return fd;
	}
	
	@RequestMapping("/departmentfilter")
	@Transactional
	@ResponseBody
	public Flexdata departmentfilter()
	{
		Flexdata fd = new Flexdata();
		fd = service.departmentfilter();
		return fd;
	}
	
	@RequestMapping("/categoryfilter")
	@Transactional
	@ResponseBody
	public Flexdata categoryfilter()
	{
		Flexdata fd = new Flexdata();
		fd = service.categoryfilter();
		return fd;
	}
	
	@RequestMapping("/subcategoryfilter")
	@Transactional
	@ResponseBody
	public Flexdata subcategoryfilter()
	{
		Flexdata fd = new Flexdata();
		fd = service.subcategoryfilter();
		return fd;
	}
	
	
	// get data
	
	@RequestMapping("/getdata")
	@ResponseBody
	public Flexdata getdata(@ModelAttribute ProjectBean bean)
	{
		Flexdata fd = new Flexdata();
		fd = service.getdata(bean.getLocation(),bean.getDepartment(),bean.getCategory(),bean.getSubcategory());
		return fd;
	}
	
	@RequestMapping("/deletedata")
	@ResponseBody
	public Flexdata deletedata(@ModelAttribute ProjectBean bean)
	{
		Flexdata fd = new Flexdata();
		fd = service.deletedata(bean.getName());
		return fd;
	}
	
	
	@RequestMapping("/createrecord")
	@ResponseBody
	public Flexdata createrecord(@ModelAttribute ProjectBean bean)
	{
		Flexdata fd = new Flexdata();
		fd = service.createrecord(bean);
		return fd;
	}
	
	@RequestMapping("/editrecord")
	@ResponseBody
	public Flexdata editrecord(@ModelAttribute ProjectBean bean)
	{
		Flexdata fd = new Flexdata();
		fd = service.editrecord(bean);
		return fd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/testdb")
	@ResponseBody
	public Flexdata getDataDb() throws SQLException
	{
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		Connection con = datasource.getConnection();
		
		Statement st = con.createStatement();
		
		//PreparedStatement ps = con.prepareStatement("select * from sample");
		
		rs = st.executeQuery("select * from sample");
		
		rsmd = rs.getMetaData();
		
		if(rs != null)
		{
			while(rs.next())
			{
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					System.out.println(rs.getString(i));
				}
			}
		}
		
		return flexdata;
	}
}
