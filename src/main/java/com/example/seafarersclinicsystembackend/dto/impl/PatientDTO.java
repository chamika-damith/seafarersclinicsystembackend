package com.example.seafarersclinicsystembackend.dto.impl;

import com.example.seafarersclinicsystembackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO implements SuperDTO {
    private String id;
    private String name;
    private String dateOfBirth;
    private String nationality;
    private String seamanBookNumber;
    private String vesselName;
    private String company;
}