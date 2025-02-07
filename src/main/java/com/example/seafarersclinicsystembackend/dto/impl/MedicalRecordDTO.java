package com.example.seafarersclinicsystembackend.dto.impl;

import com.example.seafarersclinicsystembackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecordDTO implements SuperDTO {
    private String id;
    private String date;
    private String diagnosis;
    private String treatment;
    private List<String> medications;
    private String nextCheckup;
    private String doctorNotes;
    private String maritimeFitnessStatus;
    private AppointmentDTO appointment;
}
