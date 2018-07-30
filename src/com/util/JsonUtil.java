package com.util;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtil {
	private static HttpServletResponse response;
	private static PrintWriter out;

	public static void sendSuccess(){
		try{
			response=ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out =response.getWriter();
			JSONObject jsonObj=null;
			try {
	            jsonObj = new JSONObject();
	            jsonObj.put("name","login");
	            jsonObj.put("descript","success");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
			out.print(jsonObj.toString());
			/*System.out.println(jsonObj.toString());
			System.out.println("JsonUtil.sendSuccess()");*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
			response=null;
		}
	}
	
	public static void  sendError(){
		try{
			response=ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out =response.getWriter();
			JSONObject jsonObj=null;
			try {
	            jsonObj = new JSONObject();
	            jsonObj.put("name","login");
	            jsonObj.put("descript","error");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
			out.print(jsonObj.toString());
			/*System.out.println(jsonObj.toString());
			System.out.println("JsonUtil.sendError()");*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
			response=null;
		}
	}
	@SuppressWarnings("rawtypes")
	public static void sendList(List msgList){
		try{
			response=ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out =response.getWriter();
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObj=null;
			try {
				for(int i=0;i<msgList.size();i++){
					jsonObj= new JSONObject();
					jsonObj.put("key",i);
					jsonObj.put("value",msgList.get(i));
					jsonArray.put(i,jsonObj);
				}
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
			/*System.out.println("json字符串为："+jsonArray.toString());*/
			out.print(jsonArray.toString());
			/*System.out.println("JsonUtil.sendList()");*/
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
			response=null;
		}
	}
}
