package com.mysite.member.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysite.member.demo.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        log.info("The client locale is {}.", locale);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedDate = now.format(formatter);

        model.addAttribute("serverDate", formatedDate);

        return "home";
    }
    

	@GetMapping("/userHome")
	public String Users() {
		return "/user/userHome";
	}
	@PostMapping("/userHome")
	public void User2(@RequestBody User user) {
		User newUser = user;
	}
}
