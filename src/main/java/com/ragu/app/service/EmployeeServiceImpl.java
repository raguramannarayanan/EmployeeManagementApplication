package com.ragu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragu.app.dao.EmployeeDAOImpl;
import com.ragu.app.entity.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements IEntityService<Employee> {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    @Override
    @Transactional
    public List < Employee > findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
        
    }
    
    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
        
    }

    @Override
    @Transactional
    public Employee findOne(int id) {
        return employeeDAO.findOne(id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return employeeDAO.delete(id);
    }
}
