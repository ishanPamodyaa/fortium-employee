package edu.icet.Service.Impl;

import edu.icet.Entity.EmployeeEntity;
import edu.icet.Service.EmployeeReport;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
@Service
public class EmployeeReportImpl implements EmployeeReport {
    @Override
    public void writeEmployeesToCsv(Writer writer, List<EmployeeEntity> employees) {

            try (CSVPrinter csvPrinter = new CSVPrinter(writer,
                    CSVFormat.DEFAULT.withHeader("ID","NIC","Name", "Email", "Department"))) {

                for (EmployeeEntity employee : employees) {
                    csvPrinter.printRecord(
                            employee.getId(),
                            employee.getNic(),
                            employee.getName(),
                            employee.getEmail(),
                            employee.getDepartment()
                    );
                }

                csvPrinter.flush();
            } catch (IOException e) {
                throw new RuntimeException("Error while writing CSV", e);
            }
    }


}
