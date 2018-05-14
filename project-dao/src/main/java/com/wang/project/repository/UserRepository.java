package com.wang.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User getUserInfoByAccount(String account);
	
}
