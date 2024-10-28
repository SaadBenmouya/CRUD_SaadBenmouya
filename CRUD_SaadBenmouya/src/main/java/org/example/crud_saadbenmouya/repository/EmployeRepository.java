package org.example.crud_saadbenmouya.repository;

import org.example.crud_saadbenmouya.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}