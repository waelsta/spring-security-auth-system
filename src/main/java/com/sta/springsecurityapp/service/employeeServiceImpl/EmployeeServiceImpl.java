package com.sta.springsecurityapp.service.employeeServiceImpl;

import com.sta.springsecurityapp.model.Employee;
import com.sta.springsecurityapp.repository.EmployeeRepository;
import com.sta.springsecurityapp.service.EmployeeService;
import dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public List<EmployeeDto> findAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> mapToEmployeeDto(employee))).collect(Collectors.toList());
    }
    public Employee mapToEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .email(employeeDto.getEmail())
                .lastName(employeeDto.getLastName())
                .build();
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build();
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(mapToEmployee(employeeDto));
    }
}
