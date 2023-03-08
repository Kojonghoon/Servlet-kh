package com.pojo.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/*
 * spring4에서 제공되던 ModelAndView 흉내내보자
 * 1)scope가 request이다.
 * 2)화면 이름을 정해준다
 */
public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	HttpServletRequest req = null;
	//캡슐화 코드는 반드시 getter/setter가 필요하다 -> Lombok
	private String viewName = null;
	List<Map<String,Object>> reqList = new ArrayList<>();
	public ModelAndView() {}
	public ModelAndView(HttpServletRequest req) {
		this.req = req;
	}
	public void addObject(String name, Object obj) {
		req.setAttribute(name, obj);
		Map<String, Object> pMap = new HashMap<>();
		pMap.put(name, obj);
		reqList.add(pMap);
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
}
