/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.service;

import com.testels.test.model.Employee;
import com.testels.test.repository.EmployeeRpository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HFerchichi
 */
@Service
public class EmpolyeeService {
    
 private static  final String BY_NAME ="byName";
 private static  final String BY_AGE ="byAge";
 private static  final String BY_SALARY ="bySalary";
 private static  final String BY_DESIGNATION ="byDesignation";
    
    @Autowired
    EmployeeRpository  employeeRpository;
    
    public void importFileToDataBase() throws IOException{
       
       ObjectMapperTest objectMapperTest =new ObjectMapperTest();
        
       List<Employee> listEmployees = new ArrayList();
       listEmployees = objectMapperTest.readJsonWithObjectMapper();
       listEmployees.forEach(emp-> employeeRpository.save(emp));
    
    }
    
    
    public  List<Employee>  getListEmployees(){
        return employeeRpository.findAll();
    }
    
        public List<Employee>  getListEmployeeWithoutDuplicate(String cUnicite){
                    
            List<Object> names=new ArrayList();
            List<Employee> toReturn = new ArrayList();
                        
            if(BY_NAME.equals(cUnicite)){
              employeeRpository.findAll().forEach(emp ->{
                    if(!names.contains(emp.getName())){
                        names.add(emp.getName());
                        toReturn.add(emp);
                    }
                });
               
             return toReturn;
            }
             if(BY_AGE.equals(cUnicite)){
              employeeRpository.findAll().forEach(emp ->{
                    if(!names.contains(emp.getAge())){
                        names.add(emp.getAge());
                        toReturn.add(emp);
                    }
                });
               
             return toReturn;
            }
            if(BY_SALARY.equals(cUnicite)){
              employeeRpository.findAll().forEach(emp ->{
                    if(!names.contains(emp.getSalary())){
                        names.add(emp.getSalary());
                        toReturn.add(emp);
                    }
                });
               
             return toReturn;
            }
            if(BY_DESIGNATION.equals(cUnicite)){
              employeeRpository.findAll().forEach(emp ->{
                    if(!names.contains(emp.getDesignation())){
                        names.add(emp.getDesignation());
                        toReturn.add(emp);
                    }
                });
               
             return toReturn;
            }
        return null;
        
        }

}
