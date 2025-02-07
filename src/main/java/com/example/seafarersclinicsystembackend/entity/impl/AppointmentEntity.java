package com.example.seafarersclinicsystembackend.entity.impl;

import com.example.seafarersclinicsystembackend.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointments")
public class AppointmentEntity implements SuperEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( nullable = false)
    private PatientEntity patientId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String appointmentType;

    @Column(nullable = false)
    private String appointmentStatus;

    @Column(length = 1000)
    private String notes;

}