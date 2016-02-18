package com.okdevtv.spring;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Locale locale, Model model){
		return "register";
	}
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerFinished(Locale locale,@ModelAttribute("user")User user, Model model){
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			model.addAttribute("msg","config password");
			return "register";
		}
		UserDAO.save(user);
		return "redirect:registerFinished";
	}
	@RequestMapping(value ="/registerFinished" )
	public String registerFinished(Model model)
	{
		return "registerFinished";
	}
}
