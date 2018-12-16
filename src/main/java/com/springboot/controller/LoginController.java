package com.springboot.controller;

import com.springboot.Model.Administrator;
import com.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;
    @RequestMapping("/user/login")
    public String userLogin(@RequestParam("name") String name,
                            @RequestParam("password") String password,
                            Map<String, Object> map, HttpSession session){
        List<Administrator> administrators = adminService.getAll();
        for(Administrator administrator: administrators) {
            if(administrator.getName().equals(name) && administrator.getPassword().equals(password)) {
                session.setAttribute("loginUser", name);
                return "redirect:/emps";
            }
        }
            map.put("msg", "用户名或密码错误");
            return "login";
    }
}
