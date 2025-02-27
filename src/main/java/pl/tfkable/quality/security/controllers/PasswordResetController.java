package pl.tfkable.quality.security.controllers;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.tfkable.quality.security.model.EmailDTO4Reset;
import pl.tfkable.quality.security.model.PasswordResetDTO;
import pl.tfkable.quality.security.model.User;
import pl.tfkable.quality.security.model.token.PasswordResetToken;
import pl.tfkable.quality.security.services.UserService;
import pl.tfkable.quality.security.services.mail.MSExchangeService;
import pl.tfkable.quality.security.services.mail.MailService;
import pl.tfkable.quality.security.services.token.PasswordResetTokenService;
import pl.tfkable.quality.security.validators.EmailResetDTOValidator;
import pl.tfkable.quality.security.validators.PasswordResetDTOValidator;

@Controller
public class PasswordResetController {

	
	@Autowired
	private EmailResetDTOValidator validator;

	@Autowired
	private UserService userService;

	//@Autowired
	//private MailService mailService;
	
	@Autowired
	private MSExchangeService msxService;

	@Autowired
	private PasswordResetTokenService passwordResetTokenService;

	@Autowired
	private MessageSource messages;
	
	@Autowired
	private PasswordResetDTOValidator passwordResetDTOValidator;


	//private User user;
	//private String token;


	///////////////////////send email with link/////////////////////////////////
	
	
	/**
	 * Display forgot password page. Provide empty dto for email
	 * 
	 * @param emailResetDTO dto to grab an email
	 * @return
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot(EmailDTO4Reset emailDTO4Reset){
		return "auth/forgot";
	}

	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String resetPassword(@Valid EmailDTO4Reset emailDTO4Reset, BindingResult bindingResult,final RedirectAttributes redirectAttributes,final HttpServletRequest request) {

		validator.validate(emailDTO4Reset, bindingResult);

		if (bindingResult.hasErrors()) {
			return "auth/forgot";
		}

		redirectAttributes.addFlashAttribute("message", "Recovery was link sent. Check your email.");		

		User user = userService.findByEmail(emailDTO4Reset.getEmail());
		String tokenString = UUID.randomUUID().toString();
		PasswordResetToken token = new PasswordResetToken(tokenString, user);
		passwordResetTokenService.save(token);

		String url = createResetPasswordUrl(request,tokenString,user);
		sendPasswordRecoveryEmail(url,user.getEmail());

		return "redirect:/forgot";
	}
	@Value("${url.aplikacji}")
	private String urlAplikacji;
	
	
	private String createResetPasswordUrl(HttpServletRequest request, String tokenString, User user) {
		//String contextPath =  "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		String contextPath =  "https://"+urlAplikacji+""+ request.getContextPath();
		
		String url = contextPath + "/user/changePassword?id=" + user.getId() + "&token=" + tokenString;
		return url;
	}

	private void sendPasswordRecoveryEmail(String url,String email) {
		//mailService.sendPasswordRecoveryEmail(url,email);
		msxService.wyslijLinkDoResetuHasla(url,email);
	}
	
	
	
	
	/////////////////////////////////////recive link from email and validate/////////////////////////////

	/**
	 * Accepts a link from an email. Validates a token and an id. 
	 * Showes and error on failure or pass change from on success 
	 * 
	 * @param locale			
	 * @param model 			model to add a message to
	 * @param id				user id from recovery link
	 * @param token 			token from recovery link
	 * @param passwordResetDTO
	 * @return
	 */
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String showChangePasswordPage(Locale locale, Model model,  @RequestParam("id") long id, @RequestParam("token") String token,PasswordResetDTO passwordResetDTO) {
		
		System.out.println("2222");
		
		passwordResetDTO.setUserId(id);
		String result = passwordResetTokenService.validatePasswordResetToken(id, token);

		System.out.println("re "+result);
		
		if (result != null) {
			model.addAttribute("message", messages.getMessage("password.reset.message." + result, null, locale));
			return "auth/resetPasswordFailed";
		}else{
			

			
			
			
			return "auth/resetPassword";
		}
	}

	/**
	 * Password reset from submit method.
	 * @param passwordResetDTO
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	
	
	
	
	
	

	@RequestMapping(value="/resetPassword", method = RequestMethod.POST)
	public String resetPasswordSave(@Valid PasswordResetDTO passwordResetDTO, BindingResult bindingResult,Model model,RedirectAttributes redirectAttrs){
		
		System.out.println(passwordResetDTO.getUserId()+" c ");
		
		
		passwordResetDTOValidator.validate(passwordResetDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "auth/resetPassword";
		}else{
			setNewPassword(passwordResetDTO);
			model.addAttribute("message","Zmienione, zaloguj się nowym hasłem");
			redirectAttrs.addAttribute("message","Zmienione, zaloguj się nowym hasłem");
			return "auth/login";
			
		}
		
	}

	private void setNewPassword(PasswordResetDTO dto) {
		
		User user = userService.findById(dto.getUserId());
		
		if(user!=null){
			user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
			userService.update(user);
			
			//passwordResetTokenService.deleteToken(passwordResetTokenService.findByToken(token));
			
			passwordResetTokenService.invalidateOtherTokensForUser(dto.getUserId());
		}
	}


	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	








}
