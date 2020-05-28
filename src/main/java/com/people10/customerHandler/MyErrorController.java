package com.people10.customerHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	
	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletResponse res,ModelAndView mv,HttpServletRequest req) throws Exception
	{

		if(res.getStatus() == HttpStatus.NOT_FOUND.value()) {
			mv.addObject("exception", new Exception("Page Not Found"));
			mv.addObject("errorCode",res.getStatus());
		    mv.addObject("url", req.getRequestURL());
		    mv.setViewName("error");
		}
		else if(res.getStatus() == HttpStatus.FORBIDDEN.value()) {
			mv.addObject("exception", new Exception("You cannot Access This Page"));
		    mv.addObject("url", req.getRequestURL());
		    mv.addObject("errorCode",res.getStatus());
		    mv.setViewName("error");
		}
		else if(res.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			mv.addObject("exception", new Exception("Please check the code No data Find"));
		    mv.addObject("url", req.getRequestURL());
		    mv.addObject("errorCode",res.getStatus());
		    mv.setViewName("error");
		}
		else {
			mv.addObject("exception", new Exception("No Such a File Found"));
		    mv.addObject("url", req.getRequestURL());
		    mv.addObject("errorCode",res.getStatus());
		    mv.setViewName("error");
		}

			return mv;
		 
	}
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
