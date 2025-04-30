package com.example.jpa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa2.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
