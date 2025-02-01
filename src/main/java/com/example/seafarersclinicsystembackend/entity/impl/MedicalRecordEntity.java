package com.example.seafarersclinicsystembackend.entity.impl;

import com.example.seafarersclinicsystembackend.entity.SuperEntity;
import com.example.seafarersclinicsystembackend.entity.impl.PatientEntity;
import com.example.seafarersclinicsystembackend.util.MaritimeFitnessStatus;
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
@Table(name = "medical_records")
public class MedicalRecordEntity implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false, length = 1000)
    private String diagnosis;

    @Column(nullable = false, length = 1000)
    private String treatment;

    @ElementCollection
    @CollectionTable(
            name = "medical_record_medications",
            joinColumns = @JoinColumn(name = "medical_record_id")
    )
    @Column(name = "medication")
    private List<String> medications = new ArrayList<>();

    @Column(name = "next_checkup")
    private String nextCheckup;

    @Column(name = "doctor_notes", length = 2000)
    private String doctorNotes;

    @Enumerated(EnumType.STRING)
    @Column(name = "maritime_fitness_status", nullable = false)
    private MaritimeFitnessStatus maritimeFitnessStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;
}