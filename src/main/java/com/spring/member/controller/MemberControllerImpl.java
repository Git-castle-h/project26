package com.spring.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.interfaces.MemberController;
import com.spring.member.interfaces.MemberService;
import com.spring.member.vo.MemberVO;

@Controller("memberContoller")
public class MemberControllerImpl  extends MultiActionController implements MemberController{

	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value="/member/listMember.do", method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView listMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List<MemberVO> memberList = memberService.listMember();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList",memberList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addMember.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addMember(
			@ModelAttribute("member")MemberVO memberVO,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		
		
		int result = 0;
		result = memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		return mav;
		
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView removeMember(
			@RequestParam("id") String id,	
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
			
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/modIntro.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modIntro(
			@RequestParam("id")String id,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String viewName = getViewName(request);
		request.setCharacterEncoding("utf-8");
		
		MemberVO memberVO = memberService.searchMemberById(id);
		HttpSession session = request.getSession();
		session.setAttribute("member", memberVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/modMember.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modMember(
			@RequestParam("pwd")String pwd,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		ModelAndView mav =new ModelAndView();
		if(memberVO.getPwd().equals(pwd)){
			mav.setViewName(viewName);
		}else {
			mav.setViewName("redirect:/member/modError.do");
		}
		
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/modError.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modError(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav =new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	

	@Override
	@RequestMapping(value="/member/updateMember.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView updateMember(
			@ModelAttribute("member")MemberVO memberVO,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		memberService.updateMember(memberVO);
		
		ModelAndView mav = new ModelAndView("redirect:/member/listMember.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/searchMember.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchMember(
			@ModelAttribute("member")MemberVO memberVO,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		List<MemberVO> memberList = memberService.searchMember(memberVO);
		
		ModelAndView mav = new ModelAndView("listMember");
		mav.addObject("memberList",memberList);
		return mav;
	}

	@RequestMapping(value="/member/memberForm.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/idOverlapped.do",  method= {RequestMethod.POST,RequestMethod.GET})
	public void idOverlapped(
			@RequestParam("id")String id,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter writer = response.getWriter();
		
		
		boolean result =memberService.idOverlapped(id);
		
		PrintWriter pw = response.getWriter();
		
		
		String isUsable;
		if(result == true) {
			System.out.println(result);
			isUsable="not_usable";
			
		}else {
			System.out.println(result);
			isUsable="usable";
		}
		
		try {
			pw.print(isUsable);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	


	
	
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null||uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!(contextPath == null)||("".equals(contextPath))) {
			
			begin = contextPath.length();
		} 
		
		int end;
		
		if(uri.indexOf(";")!=-1) {
			end = uri.indexOf(";");
		}else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		}else {
			end =uri.length();
		}
		
		String fileName= uri.substring(begin,end);
		if(fileName.indexOf(".")!=-1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/")!=-1) {
			fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
		}
		
		return fileName;
	}




	
	
}
