/**  
 * @Title: test.java
 * @Package com.test
 * @Description: TODO
 * @author Victor
 * @date 2017年8月16日
 */
package com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * ClassName: test 
 * @Description: TODO
 * @author Victor
 * @date 2017年8月16日
 */
public class test {

	/**
	 * @Description: TODO
	 * @param @param args   
	 * @return void  
	 * @throws
	 * @author Victor
	 * @date 2017年8月16日
	 */
	public static void main(String[] args) {
		String t = "[{SPECIFICPROLEMID=nsssss,ALARMSTATUS=null,ALARMID=d15c0308-4e8e-4fbb-98de-c12f5cbca11a}]";
		alyJson(t);
	}
	 public static void alyJson(String urls) {
		    if (urls != null) {
		      try {
		        JSONArray array = new JSONArray(urls);
		        JSONObject obj = new JSONObject(array.get(0).toString());
		        Object temp = obj.get("ALARMSTATUS");
		        if(temp == null){
		        	System.out.println("222222222");
		        }
		      } catch (JSONException e) {
		        e.printStackTrace();
		      }
		    }

	 }

}
