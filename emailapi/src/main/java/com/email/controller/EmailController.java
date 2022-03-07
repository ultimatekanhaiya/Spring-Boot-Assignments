package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.Email;
import com.email.model.EmailResponse;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return  "this is my email api";
	}
	
	@PostMapping(value = "/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody Email request) {
		System.out.println(request);
		boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		if(result) {
			return ResponseEntity.ok(new EmailResponse("Email is sent successfully..."));
		}
		else {
			System.out.println(result + " this is result");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent..."));
		}
		
	}
}
