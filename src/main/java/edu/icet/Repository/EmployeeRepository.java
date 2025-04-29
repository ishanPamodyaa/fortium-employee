package edu.icet.Repository;

import edu.icet.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByEmail(String email);
}
