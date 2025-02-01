package com.example.seafarersclinicsystembackend.dto.impl;

import com.example.seafarersclinicsystembackend.dto.SuperDTO;
import com.example.seafarersclinicsystembackend.util.MaritimeFitnessStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class MedicalRecordDTO implements SuperDTO {
    private String id;
    private String date;
    private String diagnosis;
    private String treatment;
    private List<String> medications;
    private String nextCheckup;
    private String doctorNotes;
    private MaritimeFitnessStatus maritimeFitnessStatus;
}