/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.controller;
import com.testels.test.model.Employee;
import com.testels.test.service.EmpolyeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HFerchichi
 */

@RequestMapping(path="/api")

    @RestController
    public class ControllerEmployee {
        
    @Autowired
    EmpolyeeService empolyeeService;
   
    
    @RequestMapping("/listEmployee")
    public List<Employee> getListEmployeeOnlyOneOcc(@RequestParam(value="uCreteria") String uCreteria) {
        List<Employee> listEmployeeWithoutDuplicate = empolyeeService.getListEmployeeWithoutDuplicate(uCreteria);
       return listEmployeeWithoutDuplicate;
        
    }
    
    @RequestMapping("/listAllEmployee")
    public List<Employee> getListAllEmployees() {
       List<Employee> listEmployees = empolyeeService.getListEmployees();
       return listEmployees;
        
    }
    
}