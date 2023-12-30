package com.jsp.bootdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bootdemo.dto.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	User findByEmailAndPassword(String email,String password);
}
