package edu.icet.Controller;


import edu.icet.Dto.EmployeeDTO;
import edu.icet.Dto.EmployeeResponseDTO;
import edu.icet.Entity.EmployeeEntity;
import edu.icet.Service.EmployeeReport;
import edu.icet.Service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeReport employeeReport;
    @PostMapping()
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
    public EmployeeResponseDTO getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=employees.csv");

        List<EmployeeEntity> employees = employeeService.getAllEmployees();

        employeeReport.writeEmployeesToCsv(response.getWriter(), employees);
    }




}
