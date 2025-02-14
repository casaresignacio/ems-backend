package com.crud.ems.service.impl;


import com.crud.ems.dto.EmployeeDto;
import com.crud.ems.entity.Employee;
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
}
