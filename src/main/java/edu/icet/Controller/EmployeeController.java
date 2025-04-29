package edu.icet.Controller;


import edu.icet.Dto.EmployeeDTO;
import edu.icet.Entity.EmployeeEntity;
import edu.icet.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping("/save")
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTOUpdated) {
        return employeeService.updateEmployee(id, employeeDTOUpdated);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


}
