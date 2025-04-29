package edu.icet.Service;

import edu.icet.Dto.EmployeeDTO;
import edu.icet.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(EmployeeDTO employeeDTO);

    EmployeeEntity updateEmployee(Integer id, EmployeeDTO employeeDTOUpdated);

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Integer id);

    void deleteEmployee(Integer id);
}
