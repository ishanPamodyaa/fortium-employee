package edu.icet.Dto;

import edu.icet.util.Department;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDTO {
    private String nic;
    private String name;
    private String email;
    private Department department;
}
