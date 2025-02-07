package com.example.seafarersclinicsystembackend.util;

import com.example.seafarersclinicsystembackend.dto.impl.AppointmentDTO;
import com.example.seafarersclinicsystembackend.dto.impl.MedicalRecordDTO;
import com.example.seafarersclinicsystembackend.dto.impl.PatientDTO;
import com.example.seafarersclinicsystembackend.entity.impl.AppointmentEntity;
import com.example.seafarersclinicsystembackend.entity.impl.MedicalRecordEntity;
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

    // Appointment Mapping
    public AppointmentEntity toAppointmentEntity(AppointmentDTO appointmentDTO) {
        return modelMapper.map(appointmentDTO, AppointmentEntity.class);
    }

    public AppointmentDTO toAppointmentDTO(AppointmentEntity appointmentEntity) {
        return modelMapper.map(appointmentEntity, AppointmentDTO.class);
    }

    public List<AppointmentDTO> toAppointmentDTOList(List<AppointmentEntity> appointmentEntityList) {
        return modelMapper.map(appointmentEntityList, new TypeToken<List<AppointmentDTO>>() {}.getType());
    }

    public List<AppointmentEntity> toAppointmentEntities(List<AppointmentDTO> appointmentDTOList) {
        return modelMapper.map(appointmentDTOList, new TypeToken<List<AppointmentEntity>>() {}.getType());
    }

    // MedicalRecord Mapping
    public MedicalRecordEntity toMedicalRecordEntity(MedicalRecordDTO medicalRecordDTO) {
        return modelMapper.map(medicalRecordDTO, MedicalRecordEntity.class);
    }

    public MedicalRecordDTO toMedicalRecordDTO(MedicalRecordEntity medicalRecordEntity) {
        return modelMapper.map(medicalRecordEntity, MedicalRecordDTO.class);
    }

    public List<MedicalRecordDTO> toMedicalRecordDTOList(List<MedicalRecordEntity> medicalRecordEntityList) {
        return modelMapper.map(medicalRecordEntityList, new TypeToken<List<MedicalRecordDTO>>() {}.getType());
    }

    public List<MedicalRecordEntity> toMedicalRecordEntities(List<MedicalRecordDTO> medicalRecordDTOList) {
        return modelMapper.map(medicalRecordDTOList, new TypeToken<List<MedicalRecordEntity>>() {}.getType());
    }
}
