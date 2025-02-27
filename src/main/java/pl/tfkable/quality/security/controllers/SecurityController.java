package pl.tfkable.quality.security.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.tfkable.quality.security.model.UserDTO4Registration;
import pl.tfkable.quality.security.services.RegistrationService;
import pl.tfkable.quality.security.validators.RegistrationFormValidator;

@Controller
public class SecurityController {

	@Autowired
	private RegistrationFormValidator validator;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping("/login")
	public String loginPageDisplay(){
		return "auth/login";
	}
	
//	@RequestMapping("/logout")
//	public String logout(){
//		return "redirect:/";
//	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerShow(UserDTO4Registration userDTO4Registration){
		return "auth/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerSave(@Valid UserDTO4Registration userDTO4Registration, BindingResult bindingResult,final RedirectAttributes redirectAttributes) {

		validator.validate(userDTO4Registration, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "auth/register";
		}
		registrationService.register(userDTO4Registration);
		redirectAttributes.addFlashAttribute("message", "Registration sucessfull. You can now login");		
		
		return "redirect:/login";
	}
}
