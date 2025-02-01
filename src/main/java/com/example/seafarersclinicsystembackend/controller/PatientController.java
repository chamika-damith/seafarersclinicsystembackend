package com.example.seafarersclinicsystembackend.controller;

import com.example.seafarersclinicsystembackend.dto.impl.PatientDTO;
import com.example.seafarersclinicsystembackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.save(patientDTO);
        return new ResponseEntity<>("Patient saved successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientService.delete(id);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePatient(
            @RequestBody PatientDTO patientDTO
    ) {
        patientService.update(patientDTO.getId(), patientDTO);
        return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable String id) {
        PatientDTO patientDTO = patientService.get(id);
        if (patientDTO != null) {
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @RequestMapping("/get")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> allPatients = patientService.getAll();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> patientExists(@PathVariable String id) {
        PatientDTO patient = patientService.get(id);
        return new ResponseEntity<>(patient != null, HttpStatus.OK);
    }
}