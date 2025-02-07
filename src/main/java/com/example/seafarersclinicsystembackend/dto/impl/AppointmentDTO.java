package com.example.seafarersclinicsystembackend.dto.impl;

import com.example.seafarersclinicsystembackend.dto.SuperDTO;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO implements SuperDTO {
    private String id;
    private PatientDTO patientId;
    private String date;
    private String time;
    private String appointmentType;
    private String appointmentStatus;
    private String notes;
}