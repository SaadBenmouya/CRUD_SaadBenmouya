package org.example.crud_saadbenmouya.controller;

import org.example.crud_saadbenmouya.model.Employe;
import org.example.crud_saadbenmouya.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeService ser;

   @Autowired
    private MessageSource messg;

   @GetMapping
    public List<Employe> getAllEmployees() {
       return ser.findAll();
   }

   @PostMapping
   public Employe createEmployee(@RequestBody Employe employee) {
       return ser.save(employee);
   }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employe updatedEmployee, Locale locale) {
        Employe employe = ser.findById(id);
        if (employe == null) {
            String errorMessage = messg.getMessage("employe.notFound", null, locale);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

        employe.setFirstName(updatedEmployee.getFirstName());
        employe.setLastName(updatedEmployee.getLastName());
        employe.setEmail(updatedEmployee.getEmail());
        Employe updated = ser.save(employe);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id, Locale locale) {
        Employe employee = ser.findById(id);
        if (employee == null) {
            String errorMessage = messg.getMessage("employe.notFound", null, locale);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

        ser.deleteById(id);
        String successMessage = messg.getMessage("employe.deleted", null, locale);
        return ResponseEntity.ok(successMessage);
    }
}


