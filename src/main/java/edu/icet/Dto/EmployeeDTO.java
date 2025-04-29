package edu.icet.Dto;

import edu.icet.util.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDTO {

    @NotBlank(message = "NIC must not be empty")
    @Pattern(regexp = "^[0-9]{12}$|^[0-9]{9}[Vv]$", message = "NIC must be either a 12-digit number or a 9-digit number followed by 'V' or 'v'")
    private String nic;
    @NotBlank(message = "Name must not be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only alphabetic characters and spaces")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must be a valid format")
    private String email;
    @NotBlank(message = "Department must not be empty")
    @Pattern(regexp = "HR|IT|Finance|Operations", message = "Department must be one of: HR, IT, Finance, Operations")
    private Department department;
}
