package com.example.seafarersclinicsystembackend.util;

import com.example.seafarersclinicsystembackend.dto.impl.PatientDTO;
import com.example.seafarersclinicsystembackend.entity.impl.PatientEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public PatientEntity toPatientEntity(PatientDTO patientDTO){
        return modelMapper.map(patientDTO,PatientEntity.class);
    }

    public PatientDTO toPatientDTO(PatientEntity patientEntity){
        return modelMapper.map(patientEntity,PatientDTO.class);
    }

    public List<PatientDTO> toPatientDTOList(List<PatientEntity> patientEntityList){
        return modelMapper.map(patientEntityList,new TypeToken<List<PatientDTO>>(){}.getType());
    }

    public List<PatientEntity> toPatientEntities(List<PatientDTO> patientDTOList){
        return modelMapper.map(patientDTOList,new TypeToken<List<PatientEntity>>(){}.getType());
    }
}
