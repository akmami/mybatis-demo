package com.akmami.mybatisdemo.controller;

import com.akmami.mybatisdemo.dao.EmployeeMapper;
import com.akmami.mybatisdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.akmami.mybatisdemo.dao")
public class EmployeeController
{
    @Autowired
    public EmployeeMapper mapper;


    @RequestMapping("/employees")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", mapper.getAllEmployees());
        return mav;
    }


    @RequestMapping("/showFormForAddEmployee")
    public ModelAndView showForm()
    {
        ModelAndView mav = new ModelAndView("add-employee");
        mav.addObject("employee", new Employee());
        return mav;
    }


    @RequestMapping("/saveProcess")
    public String saveProcess(@ModelAttribute("employee") Employee employee)
    {
        if (employee.getId() == null)
        {
            mapper.saveEmployee(employee);
        }
        else
        {
            mapper.updateEmployee(employee);
        }
        return "redirect:/employees";
    }


    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId)
    {
        mapper.deleteEmployee(employeeId);
        return "redirect:/employees";
    }


    @RequestMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam("employeeId") int employeeId)
    {
        ModelAndView mav = new ModelAndView("add-employee");
        Employee employee = mapper.findById(employeeId);
        mav.addObject("employee", employee);
        return mav;
    }

}
