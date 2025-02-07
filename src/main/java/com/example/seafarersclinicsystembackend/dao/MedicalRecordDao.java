package com.example.seafarersclinicsystembackend.dao;

import com.example.seafarersclinicsystembackend.entity.impl.MedicalRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordDao extends JpaRepository<MedicalRecordEntity,String> {
}
