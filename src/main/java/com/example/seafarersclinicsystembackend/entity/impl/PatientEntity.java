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
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false, unique = true)
    private String seamanBookNumber;

    private String vesselName;

    private String company;

    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointments = new ArrayList<>();
}