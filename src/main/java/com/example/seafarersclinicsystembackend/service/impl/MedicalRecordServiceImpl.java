package com.example.seafarersclinicsystembackend.service.impl;

import com.example.seafarersclinicsystembackend.dao.MedicalRecordDao;
import com.example.seafarersclinicsystembackend.dto.impl.MedicalRecordDTO;
import com.example.seafarersclinicsystembackend.entity.impl.AppointmentEntity;
import com.example.seafarersclinicsystembackend.entity.impl.MedicalRecordEntity;
import com.example.seafarersclinicsystembackend.service.MedicalRecordService;
import com.example.seafarersclinicsystembackend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private Mapping mapping;

    @Autowired
    private MedicalRecordDao medicalRecordDao;

    @Override
    public void save(MedicalRecordDTO dto) {
        MedicalRecordEntity medicalRecordEntity = mapping.toMedicalRecordEntity(dto);
        medicalRecordDao.save(medicalRecordEntity);
    }

    @Override
    public void delete(String id) {
        if (medicalRecordDao.existsById(id)) {
            medicalRecordDao.deleteById(id);
        }
    }

    @Override
    public void update(String id, MedicalRecordDTO dto) {
        Optional<MedicalRecordEntity> byId = medicalRecordDao.findById(id);

        if (byId.isPresent()) {
            AppointmentEntity appointmentEntity = mapping.toAppointmentEntity(dto.getAppointment());

            MedicalRecordEntity medicalRecordEntity = byId.get();
            medicalRecordEntity.setAppointment(appointmentEntity);
            medicalRecordEntity.setDiagnosis(dto.getDiagnosis());
            medicalRecordEntity.setTreatment(dto.getTreatment());
            medicalRecordEntity.setDoctorNotes(dto.getDoctorNotes());
            medicalRecordEntity.setDate(dto.getDate());
            medicalRecordDao.save(medicalRecordEntity);
        }
    }

    @Override
    public MedicalRecordDTO get(String id) {
        Optional<MedicalRecordEntity> medicalRecordEntity = medicalRecordDao.findById(id);
        return medicalRecordEntity.map(mapping::toMedicalRecordDTO).orElse(null);
    }

    @Override
    public List<MedicalRecordDTO> getAll() {
        return mapping.toMedicalRecordDTOList(medicalRecordDao.findAll());
    }
}
