package com.example.seafarersclinicsystembackend.controller;

import com.example.seafarersclinicsystembackend.dto.impl.AppointmentDTO;
import com.example.seafarersclinicsystembackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/add")
    public ResponseEntity<String> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        System.out.println(appointmentDTO);
        appointmentService.save(appointmentDTO);
        return new ResponseEntity<>("Appointment saved successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable String id) {
        appointmentService.delete(id);
        return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.update(appointmentDTO.getId(), appointmentDTO);
        return new ResponseEntity<>("Appointment updated successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable String id) {
        AppointmentDTO appointmentDTO = appointmentService.get(id);
        if (appointmentDTO != null) {
            return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> allAppointments = appointmentService.getAll();
        return new ResponseEntity<>(allAppointments, HttpStatus.OK);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> appointmentExists(@PathVariable String id) {
        AppointmentDTO appointment = appointmentService.get(id);
        return new ResponseEntity<>(appointment != null, HttpStatus.OK);
    }
}
