package com.example.jpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa2.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer>{

}
