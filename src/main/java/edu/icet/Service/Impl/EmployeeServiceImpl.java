package edu.icet.Service.Impl;

import edu.icet.Dto.EmployeeDTO;
import edu.icet.Entity.EmployeeEntity;
import edu.icet.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {

    }

    @Override
    public EmployeeEntity updateEmployee(Integer id, EmployeeDTO employeeDTOUpdated) {
        return null;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return List.of();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer id) {
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) {

    }
}
