package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")
@RequestMapping("/test")
public class MainController {
	
	@RequestMapping(value="/hi.do", method=RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","hihihi");
		mav.setViewName("main");
		
		return mav;
		
	}
	
	@RequestMapping(value="/hello.do", method= RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","hello");
		mav.setViewName("main");
		
		return mav;
		
	}
	

}
