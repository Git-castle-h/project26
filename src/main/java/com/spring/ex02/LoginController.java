package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value= {"/test/loginForm.do"},method= {RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
		
	}
	
	@RequestMapping(value= {"/test/loginForm2.do"},method= {RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView loginForm2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm2");
		return mav;
		
	}
	
	@RequestMapping(value= {"/test/loginForm3.do"},method= {RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView loginForm3(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm3");
		return mav;
		
	}
	
	@RequestMapping(value= {"/test/loginForm4.do"},method= {RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView loginForm4(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm4");
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
			@RequestParam(value="userID", required=false)String userID,
			@RequestParam(value="userName", required=false)String userName,
			@RequestParam(value="userEmail", required=false)String userEmail,
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
	
	@RequestMapping(value="/test/login3.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login3(
			@RequestParam Map<String,String> info,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		System.out.println("isLogin3");
		
		mav.setViewName("result2");
		mav.addObject("info",info);
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/test/login4.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login4(
			@ModelAttribute("info") LoginVO loginVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		
		System.out.println("isLogin4");
		
		System.out.println("userID: "+loginVO.getUserID());
		System.out.println("userName: "+loginVO.getUserName());
		System.out.println("userEmail: "+loginVO.getUserEmail());
		
		mav.setViewName("result2");
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/test/login5.do", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login5(
			Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		
		System.out.println("isLogin5");
		model.addAttribute("userID","hong");
		model.addAttribute("userName","홍길동");
		model.addAttribute("userEmail","userEmail@email.com");
		mav.setViewName("result");
		
		return mav;
	}
	
}


