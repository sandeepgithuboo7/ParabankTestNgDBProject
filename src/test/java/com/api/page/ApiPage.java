package com.api.page;

import org.json.JSONObject;

import com.framework.commons.ApiCommons;

public class ApiPage extends ApiCommons{
	
	public String getRequestBodyToCreateNewRepo(String projectName) {
		String body=null;
		JSONObject jo= new JSONObject();
		jo.put("name", projectName);
		jo.put("description", "Sample Description");
		jo.put("private", true);
		body = jo.toString();		
		return body;
	}

}
