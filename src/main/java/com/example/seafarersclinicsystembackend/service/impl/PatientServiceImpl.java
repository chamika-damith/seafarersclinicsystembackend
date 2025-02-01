package com.example.seafarersclinicsystembackend.service.impl;

import com.example.seafarersclinicsystembackend.dao.PatientDao;
import com.example.seafarersclinicsystembackend.dto.impl.PatientDTO;
import com.example.seafarersclinicsystembackend.entity.impl.PatientEntity;
import com.example.seafarersclinicsystembackend.service.PatientService;
import com.example.seafarersclinicsystembackend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void save(PatientDTO dto) {
        PatientEntity patientEntity = mapping.toPatientEntity(dto);
        System.out.println(patientEntity);
        patientDao.save(patientEntity);
    }

    @Override
    public void delete(String id) {
        Optional<PatientEntity> byId = patientDao.findById(id);
        if (byId.isPresent()) {
            patientDao.deleteById(id);
        }
    }

    @Override
    public void update(String id, PatientDTO dto) {
        Optional<PatientEntity> byId = patientDao.findById(id);
        if (byId.isPresent()) {
            PatientEntity patientEntity = byId.get();
            patientEntity.setName(dto.getName());
            patientEntity.setDateOfBirth(dto.getDateOfBirth());
            patientEntity.setNationality(dto.getNationality());
            patientEntity.setSeamanBookNumber(dto.getSeamanBookNumber());
            patientEntity.setVesselName(dto.getVesselName());
            patientEntity.setCompany(dto.getCompany());

            patientDao.save(patientEntity);
        }
    }

    @Override
    public PatientDTO get(String id) {
        if (patientDao.existsById(id)){
            PatientEntity referenceById = patientDao.getReferenceById(id);
            PatientDTO patientDTO = mapping.toPatientDTO(referenceById);
            return patientDTO;
        }

        return null;
    }

    @Override
    public List<PatientDTO> getAll() {
        return mapping.toPatientDTOList(patientDao.findAll());
    }
}
