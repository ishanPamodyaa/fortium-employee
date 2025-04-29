package edu.icet.Service.Impl;

import edu.icet.Dto.EmployeeDTO;
import edu.icet.Dto.EmployeeResponseDTO;
import edu.icet.Entity.EmployeeEntity;
import edu.icet.Repository.EmployeeRepository;
import edu.icet.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {

        if(isEmailExist(employeeDTO.getEmail())){
            throw new IllegalArgumentException("Email already exists.");
        }
        EmployeeEntity employee = modelMapper.map(employeeDTO ,EmployeeEntity.class);

        LocalDateTime nowTime = LocalDateTime.now();

        employee.setCreatedAt(nowTime);
        employee.setUpdatedAt(nowTime);

        employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(Integer id, EmployeeDTO employeeDTOUpdated) {

        EmployeeEntity existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with ID " + id + " not found."));


        modelMapper.map(employeeDTOUpdated, existingEmployee);

        existingEmployee.setUpdatedAt(LocalDateTime.now());

        return employeeRepository.save(existingEmployee);

    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Integer id) {
        EmployeeEntity entity = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with ID " + id + " not found."));
        return modelMapper.map(entity, EmployeeResponseDTO.class);
    }

    @Override
    public void deleteEmployee(Integer id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee with ID " + id + " not found."));

        employeeRepository.delete(employee);
    }

    public Boolean isEmailExist(String email){
        return employeeRepository.findByEmail(email).isPresent();
    }
}
