package com.springboot.controller;

import com.springboot.Model.Department;
import com.springboot.Model.Employee;
import com.springboot.service.DeptService;
import com.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @Autowired
    DeptService deptService;
    /**
     * 查看所有员工
     */
    @GetMapping("/emps")
    public String getAll(Model model) {
        List<Employee> employees = empService.getAll();
        List<Department> departments = deptService.getAll();
        model.addAttribute("emps", employees);
        model.addAttribute("depts", departments);
        return "emp/list";
    }

    //来到员工修改页面
    @GetMapping("/emp/{id}")
    public String getEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = empService.getById(id);
        List<Department> departments = deptService.getAll();
        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);
        return "emp/update";
    }
    //修改员工, 返回员工列表
    @PutMapping("/emp")
    public String update(Employee employee) {
        empService.update(employee);
        return "redirect:/emps";
    }

    //来到员工添加页面
    @GetMapping("/add")
    public String addEmp(Model model) {
        List<Department> departments = deptService.getAll();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工, 返回员工列表
    @PostMapping("/emp")
    public String add(Employee employee) {
        empService.save(employee);
        return "redirect:/emps";
    }

    //删除操作
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        empService.delById(id);
        return "redirect:/emps";
    }


}
