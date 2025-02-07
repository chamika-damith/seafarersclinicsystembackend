package com.example.seafarersclinicsystembackend.service.impl;

import com.example.seafarersclinicsystembackend.dao.AppoinmentDao;
import com.example.seafarersclinicsystembackend.dto.impl.AppointmentDTO;
import com.example.seafarersclinicsystembackend.entity.impl.AppointmentEntity;
import com.example.seafarersclinicsystembackend.service.AppointmentService;
import com.example.seafarersclinicsystembackend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private Mapping mapping;

    @Autowired
    private AppoinmentDao appoinmentDao;

    @Override
    public void save(AppointmentDTO dto) {
        AppointmentEntity appointmentEntity = mapping.toAppointmentEntity(dto);
        appoinmentDao.save(appointmentEntity);
    }

    @Override
    public void delete(String id) {
        if (appoinmentDao.existsById(id)) {
            appoinmentDao.deleteById(id);
        }
    }

    @Override
    public void update(String id, AppointmentDTO dto) {
        Optional<AppointmentEntity> byId = appoinmentDao.findById(id);
        if (byId.isPresent()) {
            AppointmentEntity appointmentEntity = byId.get();
            appointmentEntity.setDate(dto.getDate());
            appointmentEntity.setTime(dto.getTime());
            appointmentEntity.setAppointmentType(dto.getAppointmentType());
            appointmentEntity.setAppointmentStatus(dto.getAppointmentStatus());
            appointmentEntity.setNotes(dto.getNotes());
            appoinmentDao.save(appointmentEntity);
        }
    }

    @Override
    public AppointmentDTO get(String id) {
        Optional<AppointmentEntity> appointmentEntity = appoinmentDao.findById(id);
        return appointmentEntity.map(mapping::toAppointmentDTO).orElse(null);
    }

    @Override
    public List<AppointmentDTO> getAll() {
        return mapping.toAppointmentDTOList(appoinmentDao.findAll());
    }
}
