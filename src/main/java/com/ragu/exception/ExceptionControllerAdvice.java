//package com.ragu.exception;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//@ControllerAdvice
//public class ExceptionControllerAdvice {
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleException(Exception e) {
//		ModelAndView model = new ModelAndView();
//		model.addObject("exception", e);
//		model.setViewName("error");
//		return model;
//	}
//}
