package com.adityaseries;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adityaseries.Service.AddService;

@Controller
public class AddController {

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req,HttpServletResponse res)
	{

		int i=Integer.parseInt(req.getParameter("fname"));
		int j=Integer.parseInt(req.getParameter("lname"));

		AddService as=new AddService();
		int z=as.add(i, j);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",z);
		return mv;
	}
}
