package com.cg.spbt.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spbt.demo.entity.Employee;
@RequestMapping("/employee")
@RestController
public class EmployeeController 
{
   ArrayList<Employee> elist = new ArrayList<>();
   public EmployeeController()
   {
	   elist.add(new Employee(102,"Babu",2000));
	   elist.add(new Employee(103,"chandu",3000));
	   elist.add(new Employee(101,"ajay",1000));
	   elist.add(new Employee(104,"Dinesh",4000));
	  
   }
   @GetMapping(value = "/{empid}",produces="application/json")   //http://localhost:8081/102 // http://localhost:8081/employee/102-employee is used due to @requestcontrllr
   
   public Employee getEmployee(@PathVariable("empid")int empid)
   {
	   for(Employee e :elist)
		   if(e.getEmpid()==empid)
			   return e;
	   return null;
	   
   }
   @GetMapping(value = "/all" ,produces=MediaType.APPLICATION_JSON_VALUE)   // http://localhost:8081/all
   public List<Employee> getEmployees()
   {
	   return elist;
   }
   
   @DeleteMapping(value="/(empid")
    public void deleteEmployee(@PathVariable("empid") int empid)
    {
	   for(Employee e : elist)
		   if(e.getEmpid()==empid)
			   elist.remove(e);
	
    }
   @PostMapping  // http:locahost:8081/employee
   public void addEmployee(@RequestBody Employee emp)
   {
	   elist.add(emp);
   }
   @PutMapping  // http:localhost
   public void modifyEmployee(@RequestBody Employee emp)
   {
	   for(Employee e : elist)
		   if(e.getEmpid()==emp.getEmpid())
		   {
			   e.setEname(emp.getEname());
			   e.setSalary(emp.getSalary());
		   }
   }
}
