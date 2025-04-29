package edu.icet.Service;

import edu.icet.Entity.EmployeeEntity;

import java.io.Writer;
import java.util.List;

public interface EmployeeReport {

     void writeEmployeesToCsv(Writer writer, List<EmployeeEntity> employees);
}
