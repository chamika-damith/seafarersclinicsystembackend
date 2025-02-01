package com.example.seafarersclinicsystembackend.entity.impl;

import com.example.seafarersclinicsystembackend.entity.SuperEntity;
import com.example.seafarersclinicsystembackend.entity.impl.PatientEntity;
import com.example.seafarersclinicsystembackend.util.AppointmentStatus;
import com.example.seafarersclinicsystembackend.util.AppointmentType;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status;

    @Column(length = 1000)
    private String notes;

}