package com.example.seafarersclinicsystembackend.dto.impl;

import com.example.seafarersclinicsystembackend.dto.SuperDTO;
import com.example.seafarersclinicsystembackend.util.AppointmentType;
import com.example.seafarersclinicsystembackend.util.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class AppointmentDTO implements SuperDTO {
    private String id;
    private String patientId;
    private String date;
    private String time;
    private AppointmentType type;
    private AppointmentStatus status;
    private String notes;
}