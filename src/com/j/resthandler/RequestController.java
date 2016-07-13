package com.j.resthandler;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.j.beans.LoginBean;

@RestController
public class RequestController {

	@RequestMapping(value="/login",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ArrayList> loginFunction(@ModelAttribute("login")LoginBean _login )
	{
		JSONArray userArray = new JSONArray();
		List<ArrayList> s=new ArrayList<>();
		ArrayList s1=new ArrayList();
		Map<Integer,String> map=new HashMap<>();
		map.put(1, null);map.put(1, "null");
		map.put(1, "c");
		s1.add(map);s1.add("A");s1.add("A");s1.add("A");s1.add("A");
		s.add(s1);
		return s;
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
}
