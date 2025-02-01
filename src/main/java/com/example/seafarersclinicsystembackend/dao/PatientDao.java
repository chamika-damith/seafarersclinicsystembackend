package com.example.seafarersclinicsystembackend.dao;

import com.example.seafarersclinicsystembackend.entity.impl.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity,String> {
}
