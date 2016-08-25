package com.hanbit.web.util;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request,String name){
     String[] values = (String[]) request.getParameterMap().get(name);
     StringBuffer buff = new StringBuffer();
     String str = "";
     for (int i = 0; i < values.length; i++) {
    	 buff.append(values[i]+",");
	}
     str = buff.toString().substring(0, buff.toString().length()-1);
     System.out.println("str:"+str);
		return str;
	}
}
