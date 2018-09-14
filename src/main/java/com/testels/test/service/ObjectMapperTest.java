/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.testels.test.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author HFerchichi
 */
public class ObjectMapperTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
        
    public List<Employee> readJsonWithObjectMapper() throws IOException {
       try {
            ObjectMapper objectMapper = new ObjectMapper();
          File fileEmployee =  new File("src/main/resources/employee.json");
            List<Employee>  emp = objectMapper.readValue(fileEmployee
                 , objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
        return emp;
        } catch (IOException e) {
             throw new IllegalArgumentException("Unable to load file", e);
        } 
    }
   
}
