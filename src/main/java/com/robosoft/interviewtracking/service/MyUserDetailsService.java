package com.robosoft.interviewtracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.robosoft.interviewtracking.dao.UserDetailRepo;
import com.robosoft.interviewtracking.dto.UserPrinciple;
import com.robosoft.interviewtracking.model.UserDetailModel;


@Service
public class MyUserDetailsService implements UserDetailsService
{

	@Autowired
	UserDetailRepo userDetailRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		UserDetailModel user = userDetailRepo.findByUsername(username);

		return new UserPrinciple(user);
		
	}

}
