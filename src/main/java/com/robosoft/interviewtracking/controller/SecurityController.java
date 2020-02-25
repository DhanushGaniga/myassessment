package com.robosoft.interviewtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.robosoft.interviewtracking.dto.AuthenticationRequest;
import com.robosoft.interviewtracking.dto.AuthenticationResponse;
import com.robosoft.interviewtracking.exception.CustomException;
import com.robosoft.interviewtracking.service.JwtUtil;
import com.robosoft.interviewtracking.service.MyUserDetailsService;

@RestController
public class SecurityController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> Authentication(@RequestBody AuthenticationRequest authenticateRequest) throws Exception
	{
		
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(),authenticateRequest.getPassword()));
		}
		catch (BadCredentialsException e) 
		{
			System.out.println("error  =" +e);
			throw new CustomException(1000, "invalid credentials");
		}
		
	
		final UserDetails userDetails =  userDetailService.loadUserByUsername(authenticateRequest.getUserName());
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
