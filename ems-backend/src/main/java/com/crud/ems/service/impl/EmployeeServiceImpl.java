package com.crud.ems.service.impl;


import com.crud.ems.dto.EmployeeDto;
import com.crud.ems.entity.Employee;
import com.crud.ems.exception.ResourceNotFoundException;
import com.crud.ems.mapper.EmployeeMapper;
import com.crud.ems.repository.EmployeeRepository;
import com.crud.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
