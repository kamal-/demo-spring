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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j.beans.LoginBean;
import com.j.dao.LoginDao;
import com.j.dao.UserDetailDao;
import com.j.dao.VisitRecordsDao;
import com.j.daoImplement.LoginDaoImplement;
import com.j.daoImplement.UserDetailDaoImplement;
import com.j.daoImplement.UserFeedBeanImplement;
import com.j.daoImplement.VisitRecordsDaoImplement;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class RequestController {

	@Autowired
	private DataSource source=null;
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
	public List<Map<String,Object>> userFunction(@ModelAttribute("start")String startpoint,@ModelAttribute("end")String endpoint )
	{
		List<Map<String,Object>> rFeed=new UserFeedBeanImplement(source).getActiveFeed();
		
		return rFeed;
	}
	
	@RequestMapping(value="/userDetail",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Object> userDetailFunction(@ModelAttribute("profileID")String profileID )
	{
		
		UserDetailDao user=new UserDetailDaoImplement(source);
	
	return user.getUserDetail(profileID);
	}
	
	@RequestMapping(value="/appointmenthistory",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String,Object>> userAppmtsFunction(@ModelAttribute("profileID")String profileID)
	{
		Map<String,Object> mockprofile=new HashMap<>();
		List<Map<String,String>> l=new ArrayList<>();
		VisitRecordsDao vRecords=new VisitRecordsDaoImplement(source);
		return vRecords.getRecords(profileID);
	}
	
	@RequestMapping(value="*",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.TRACE,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PATCH},produces=MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(value="*/*",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.TRACE,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PATCH},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String redirectFunction()
	{
		List<String> s=new ArrayList<>();
		s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");
		return "Welcome user";
	}
	
	
}
