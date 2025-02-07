package com.example.seafarersclinicsystembackend.dao;

import com.example.seafarersclinicsystembackend.entity.impl.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentDao extends JpaRepository<AppointmentEntity,String> {
}
