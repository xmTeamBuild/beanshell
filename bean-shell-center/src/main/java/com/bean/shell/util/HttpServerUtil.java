package com.bean.shell.util;



import cn.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;


public class HttpServerUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpServerUtil.class);
	
	/**
	 * 从流中解析数据
	 * @param request
	 * @param response
	 * @return
	 */
	public static String reader(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			StringBuffer msg = new StringBuffer();
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				msg.append(line);
			}
			return msg.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 判断空值
	 */	
	public static String getValue(JSONObject json, String key){
		String result = "";
		try {
			result = json.getStr(key);
		} catch (Exception e) {
			result = "";
		}
		return result;
	}

}
