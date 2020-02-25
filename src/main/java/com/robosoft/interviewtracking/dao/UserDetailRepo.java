package com.robosoft.interviewtracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robosoft.interviewtracking.model.UserDetailModel;

public interface UserDetailRepo extends JpaRepository<UserDetailModel, Integer> 
{
	UserDetailModel findByUsername(String UserName);
}
