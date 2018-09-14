/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.controllerIntegrationTest;

import com.testels.test.model.Employee;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * @author HFerchichi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerEmployeeTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
   /* public ControllerEmployeeTest() {
    }*/
    
    private static final String CRETERIA = "byName";
   
   

    /**
     * Test of getListEmployeeOnlyOneOcc method, of class ControllerEmployee.
     */
    @Test
    public void testGetListEmployeeOnlyOneOcc() throws Exception{
          
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> httpEntity = new HttpEntity(CRETERIA, headers);

        // when
        ResponseEntity<Employee[]> result = this.restTemplate.getForEntity("/api/listEmployee?uCreteria="+CRETERIA, Employee[].class);

        // then
        Employee[] employeeList = result.getBody();
        
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
        assertThat(employeeList.length).isEqualTo(3);
        assertThat(employeeList[0].getName()).isEqualTo("Alain Depont");
        assertThat(employeeList[0].getAge()).isEqualTo(32);
        assertThat(employeeList[1].getName()).isEqualTo("Henry Smith");
        
    }

    /**
     * Test of getListAllEmployees method, of class ControllerEmployee.
     */
    @Test
    public void testGetListAllEmployees() {
      
    }
    
}
