package com.example.seafarersclinicsystembackend.entity.impl;

import com.example.seafarersclinicsystembackend.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class PatientEntity implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "seaman_book_number", nullable = false, unique = true)
    private String seamanBookNumber;

    @Column(name = "vessel_name")
    private String vesselName;

    private String company;

    // Medical Records relationship
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecordEntity> medicalRecords;

    // Appointments relationship
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointments;

}