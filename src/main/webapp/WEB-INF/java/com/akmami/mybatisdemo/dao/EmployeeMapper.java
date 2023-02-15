package com.akmami.mybatisdemo.dao;

import com.akmami.mybatisdemo.entity.Employee;
import com.akmami.mybatisdemo.util.MyBatisDemoUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class EmployeeMapper
{
    public List<Employee> getAllEmployees()
    {
        SqlSession session = MyBatisDemoUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Employee> employees = session.selectList("getAllEmployees");
        session.commit();
        session.close();
        return employees;
    }


    public void saveEmployee(Employee employee)
    {
        SqlSession session = MyBatisDemoUtil.getSessionFactory().openSession();
        session.insert("insertEmployee", employee);
        session.commit();
        session.close();
    }


    public void deleteEmployee(int employeeId)
    {
        SqlSession session = MyBatisDemoUtil.getSessionFactory().openSession();
        session.delete("deleteEmployee", employeeId);
        session.commit();
        session.close();
    }


    public Employee findById(int employeeId)
    {
        SqlSession session = MyBatisDemoUtil.getSessionFactory().openSession();
        Employee employee = (Employee) session.selectOne("findById", employeeId);
        session.commit();
        session.close();
        return employee;
    }


    public void updateEmployee(Employee employee)
    {
        SqlSession session = MyBatisDemoUtil.getSessionFactory().openSession();
        session.update("updateEmployee", employee);
        session.commit();
        session.close();
    }
}
