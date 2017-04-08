package br.com.caracore.collaborator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caracore.collaborator.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@RequestMapping("/login")
	public String login(@AuthenticationPrincipal User user) {
		if (user != null && user.getUsername() != null && user.getPassword() != null) {
			if ((!user.getUsername().equals("")) && (!user.getPassword().equals(""))) {
				String username = user.getUsername();
				String password = user.getPassword();
				boolean validate = loginService.validate(username, password);
				if (validate) {
					return "redirect:/colaboradores";
				}
			}
		}
		return "login";
	}
}
