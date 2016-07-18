package com.j.resthandler;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j.beans.LoginBean;
import com.j.dao.LoginDao;
import com.j.daoImplement.LoginDaoImplement;

@RestController
public class RequestController {

	@Autowired
	DataSource source=null;
	@RequestMapping(value="/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,String> loginFunction(@ModelAttribute("login")LoginBean _login )
	{
		new LoginDaoImplement(source).isValidUser(_login);
		Map<String,String> mockprofile=new HashMap<>();
		if(_login.getRole()!=null && _login.getRole().equalsIgnoreCase("admin"))
			mockprofile.put("role", "admin");
		else if(_login.getRole()!=null && _login.getRole().equalsIgnoreCase("user"))
			mockprofile.put("role", "user");
		else
		{
			mockprofile.put("role", "unauthorized");
			return mockprofile;
		}
		mockprofile.put("profileID", "04f8996da763b7a969b1028ee3007569eaf3a635486");
		mockprofile.put("token", "04f8996da763b7a969b1028ee3007569eaf3a635486--");
		mockprofile.put("referesher", "04f8996da763b7a969b1028ee3007569eaf3a635486==");
		return mockprofile;
	}
	
	@RequestMapping(value="/patientFeed",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String,String>> userFunction(@ModelAttribute("pointer")String point )
	{

		Map<String,String> mockprofile=new HashMap<>();
		List<Map<String,String>> l=new ArrayList<>();
		for(int i=1;i<21;i++)
		{
			System.out.println("----"+i);
			mockprofile.put("id", String.valueOf(i));
			mockprofile.put("name","Vegnesh Murti");
			mockprofile.put("age","24");
			mockprofile.put("imgurl","https://placehold.it/32x32");
			mockprofile.put("profileID","04f8996da763b7a969b1028ee3007569eaf3a635486==");
			l.add(mockprofile);
		}
		
		System.out.println(l);
		return l;
	}
	
	@RequestMapping(value="/userDetail",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Map<String,String>> userDetailFunction(@ModelAttribute("profileID")String pofileID )
	{

		Map<String,String> mockprofile=new HashMap<>();
		mockprofile.put("id", pofileID);
		mockprofile.put("name","Vegnesh Murti");
		mockprofile.put("age","24");
		mockprofile.put("lastAppointment", "23-05-2016");
		mockprofile.put("imgurl","https://placehold.it/32x32");
	Map<String,String> mockfortest=new HashMap<>();
		mockfortest.put("testName", "MRI");
		mockfortest.put("testDate", "24-04-2016");
		mockfortest.put("testResult", "Positive");
		mockfortest.put("testUri", "http://placehold.it/320x320");//pdf
		mockfortest.put("medicine","X..Y..Z");
	Map<String,Map<String,String>> result=new HashMap<>();
	result.put("pofileDetail",mockprofile);
	result.put("testDetail",mockfortest);
	return result;
	}
	
	@RequestMapping(value="/appointmentlst",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,List<Map<String,String>>> userAppmtsFunction(@ModelAttribute("profileID")String pofileID )
	{

		Map<String,String> mockprofile=new HashMap<>();
			mockprofile.put("id", pofileID);
			mockprofile.put("name","Vegnesh Murti");
			mockprofile.put("age","24");
			mockprofile.put("lastAppointment", "23-05-2016");
			mockprofile.put("imgurl","https://placehold.it/32x32");
		Map<String,String> mockfortest=new HashMap<>();
			mockfortest.put("testName", "MRI");
			mockfortest.put("testDate", "24-04-2016");
			mockfortest.put("testResult", "Positive");
			mockfortest.put("testUri", "http://placehold.it/320x320");//pdf
		List<Map<String,String>> c=new ArrayList<>();
		c.add(mockfortest);
		c.add(mockprofile);
		Map<String,List<Map<String,String>>> result=new  HashMap<>();
		result.put("appointmentList",c);
		return result;
	}
	
	@RequestMapping(value="*",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<Integer,String> homeFunction()
	{
		JSONObject result = new JSONObject();result.put("name", "Dade");
		result.put("age", 23);
		result.put("married", false);
		Map<Integer,String> d=new HashMap<>();
		d.put(1,"Hello world");
        return d;
	}
	@RequestMapping(value="*/*",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String redirectFunction()
	{
		List<String> s=new ArrayList<>();
		s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");
		return "Welcome user";
	}
	
	@RequestMapping(value="*",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<Integer,String> homePOSTFunction()
	{
		JSONObject result = new JSONObject();result.put("name", "Dade");
		result.put("age", 23);
		result.put("married", false);
		Map<Integer,String> d=new HashMap<>();
		d.put(1,"Hello world");
        return d;
	}
	@RequestMapping(value="*/*",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String redirectPOSTFunction()
	{
		List<String> s=new ArrayList<>();
		s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");
		return "Welcome user";
	}
}
