package com.projectapi9.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectapi9.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
