package com.AuthServer.controller;

import com.AuthServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AuthServer.config.security.CookieUtil;
import com.AuthServer.config.security.JwtConfig;
import com.AuthServer.config.security.JwtUtil;
import com.AuthServer.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

//	private UserRepository userRepository;
//
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpServletResponse httpServletResponse, String username, String password, String redirect,
			Model model)  {
		User user = userRepository.findUsersByUsername(username);
		if(user==null)
		{
			model.addAttribute("error", "Invalid username or password!");
			return "login";
		}
		Map<String, String> claims = new HashMap<>();
		claims.put("userId", String.valueOf(user.getId()));
		String token = JwtUtil.generateToken(JwtConfig.signingKey, claims);
		CookieUtil.create(httpServletResponse, JwtConfig.jwtTokenCookieName, token, false, -1, "localhost");
		CookieUtil.create_forclient(httpServletResponse, "userId", String.valueOf(user.getId()), false, -1, "localhost");
		return "redirect:" + redirect;
	}

}
