package com.example.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Boolean existsByUsername(String username);	// 데이터가 있는지 없는지 찾음
	User findByUsername(String username);
}
