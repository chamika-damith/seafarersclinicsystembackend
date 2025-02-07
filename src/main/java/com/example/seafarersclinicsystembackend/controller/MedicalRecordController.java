package com.example.seafarersclinicsystembackend.controller;

import com.example.seafarersclinicsystembackend.dto.impl.MedicalRecordDTO;
import com.example.seafarersclinicsystembackend.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medicalRecord")
@CrossOrigin
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<String> saveMedicalRecord(@RequestBody MedicalRecordDTO medicalRecordDTO) {
        System.out.println(medicalRecordDTO);
        medicalRecordService.save(medicalRecordDTO);
        return new ResponseEntity<>("medicalRecord saved successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable String id) {
        medicalRecordService.delete(id);
        return new ResponseEntity<>("medicalRecord deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateMedicalRecord(
            @RequestBody MedicalRecordDTO medicalRecordDTO
    ) {
        medicalRecordService.update(medicalRecordDTO.getId(), medicalRecordDTO);
        return new ResponseEntity<>("medicalRecord updated successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> getMedicalRecord(@PathVariable String id) {
        MedicalRecordDTO medicalRecordDTO = medicalRecordService.get(id);
        if (medicalRecordDTO != null) {
            return new ResponseEntity<>(medicalRecordDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @RequestMapping("/get")
    public ResponseEntity<List<MedicalRecordDTO>> getAllMedicalRecord() {
        List<MedicalRecordDTO> medicalRecordDTOS = medicalRecordService.getAll();
        return new ResponseEntity<>(medicalRecordDTOS, HttpStatus.OK);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> MedicalRecordExists(@PathVariable String id) {
        MedicalRecordDTO medicalRecordDTO = medicalRecordService.get(id);
        return new ResponseEntity<>(medicalRecordDTO != null, HttpStatus.OK);
    }
}
