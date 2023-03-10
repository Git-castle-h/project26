package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value= {"/test/loginForm.do"},method= {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
		
	}
	
	@RequestMapping(value= {"/test/loginForm2.do"},method= {RequestMethod.GET})
	public ModelAndView loginForm2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm2");
		return mav;
		
	}
	
	@RequestMapping(value="/test/login.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		
		System.out.println("isLogin1");
		
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		
		return mav;
	}
	
	@RequestMapping(value="/test/login2.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login2(
			@RequestParam("userID")String userID,
			@RequestParam("userName")String userName,
			@RequestParam("userEmail")String userEmail,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		System.out.println("isLogin2");
		
		mav.setViewName("result");
		mav.addObject("userID",userID);
		mav.addObject("userName",userName);
		mav.addObject("userEmail",userEmail);
		
		
		return mav;
	}
}
