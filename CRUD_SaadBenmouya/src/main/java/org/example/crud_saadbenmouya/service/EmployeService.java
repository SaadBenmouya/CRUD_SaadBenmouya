package org.example.crud_saadbenmouya.service;

import org.example.crud_saadbenmouya.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.crud_saadbenmouya.repository.*;
import java.util.List;
@Service
public class EmployeService {
    @Autowired
    private EmployeRepository repo;

    public List<Employe> findAll() {
        return repo.findAll();
    }

    public Employe save(Employe employee) {
        return repo.save(employee);
    }

    public Employe findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
