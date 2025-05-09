package edu.icet.Dto;

import edu.icet.util.Department;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeResponseDTO {
        private Long id;
        private String nic;
        private String name;
        private String email;
        private Department department;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

}
