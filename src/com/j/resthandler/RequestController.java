package com.j.resthandler;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j.beans.LoginBean;
import com.j.beans.Paginate;
import com.j.beans.UserDetailBean;
import com.j.service.LoginService;
import com.j.service.UserDetailService;
import com.j.service.UserFeedBeanService;
import com.j.service.UserRegistrationService;
import com.j.service.VisitRecordsService;
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class RequestController {

	
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private DataSource source;
	@Autowired
	private UserFeedBeanService userFeedBeanService;
	@Autowired
	private UserRegistrationService userRegistrationService;
	@Autowired
	private VisitRecordsService visitRecordsService;
	@RequestMapping(value="/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,String> loginFunction(@Valid @RequestBody LoginBean _login , BindingResult bindingResults)
	{
		Map<String,String> mockprofile=new HashMap<>();
		if(bindingResults.hasErrors())
		{
			System.out.println("Error:"+bindingResults.getAllErrors());
		}else{
			_login=loginService.isValidUser(_login);
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
		
		mockprofile.put("profileID", "04f8996da763b7a969b1028ee3007569eaf3a635486");
		mockprofile.put("token", "04f8996da763b7a969b1028ee3007569eaf3a635486--");
		mockprofile.put("referesher", "04f8996da763b7a969b1028ee3007569eaf3a635486==");
		return mockprofile;
	}
	
	@RequestMapping(value="/patientFeed",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String,Object>> userFunction(@ModelAttribute("start")String startpoint,@ModelAttribute("end")String endpoint )
	{
		List<Map<String,Object>> rFeed=userFeedBeanService.getActiveFeed();
		
		return rFeed;
	}
	
	@RequestMapping(value="/requestFeed",method=RequestMethod.POST,consumes="application/json"
			,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String,Object>> userReqFunction(@RequestBody Paginate startpoint)
	{
		List<Map<String,Object>> rFeed=userFeedBeanService.getActiveFeed();
		
		return rFeed;
	}
	
	@RequestMapping(value="/userDetail",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Object> userDetailFunction(@ModelAttribute("profileID")String profileID )
	{
	return userDetailService.getUserDetail(profileID);
	}
	
	@RequestMapping(value="/postUserDetail",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean collectDetailFunction(@ModelAttribute("profileID")String profileID,@RequestBody UserDetailBean userDetailBean )
	{
	return userDetailService.updateUserDetails(userDetailBean);
	}
	
	@RequestMapping(value="/appointmenthistory",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Map<String,Object>> userAppmtsFunction(@ModelAttribute("profileID")String profileID)
	{
		Map<String,Object> mockprofile=new HashMap<>();
		List<Map<String,String>> l=new ArrayList<>();		
		return visitRecordsService.getRecords(profileID);
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
	
	/*@RequestMapping(value="/*",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.TRACE,RequestMethod.DELETE,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PATCH},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String redirectFunction()
	{
		List<String> s=new ArrayList<>();
		s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");s.add("A");
		return "Welcome user";
	}
	*/
	
}
