package com.springboot.service;

import com.springboot.Model.Employee;

import java.util.List;

public interface EmpService {
    public List<Employee> getAll();

    public void update(Employee employee);

    public Employee getById(Integer id);

    public void save(Employee employee);

    public void delById(Integer id);
}
