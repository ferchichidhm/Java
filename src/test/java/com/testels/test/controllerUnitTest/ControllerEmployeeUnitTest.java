package com.testels.test.controllerUnitTest;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testels.test.controller.ControllerEmployee;
import com.testels.test.model.Employee;
import com.testels.test.service.EmpolyeeService;
import java.math.BigDecimal;

import org.junit.After;



@RunWith(MockitoJUnitRunner.class)
public class ControllerEmployeeUnitTest {
    
   private static final int DEFAULT_ID = 1;
   private static final String DEFAULT_NAME = "Jane";
   private static final int DEFAULT_AGE = 29;
   private static final BigDecimal DEFAULT_SALARY = new BigDecimal("1700.50");
   private static final String DEFAULT_DESIGNATION = "Developper";
   
   private static final int DEFAULT_ID_2 = 2;
   private static final String DEFAULT_NAME_2 = "Depont";
   private static final int DEFAULT_AGE_2 = 34;
   private static final BigDecimal DEFAULT_SALARY_2 = new BigDecimal("3000.00");
   private static final String DEFAULT_DESIGNATION_2 = "Programmeur";
   
   private static final String CRITERIA_BY_NAME= "byName";
   private static final String CRITERIA_BY_AGE = "byAge";
   private static final String CRITERIA_BY_SALARY = "bySalary";
   private static final String CRITERIA_BY_DESIGNATION = "Bydesignation";
	
   @Mock
   EmpolyeeService employeeServiceMock;


   @InjectMocks
   ControllerEmployee controllerEmployee;

   private MockMvc mockMvc;
    
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerEmployee).build();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListAllEmployee method, of class ControllerEmployee.
     */
    @Test
    public void testGetListAllEmployees() throws Exception {
  
           
        // given
        Employee employee = new Employee();
        employee.setId(DEFAULT_ID);
        employee.setName(DEFAULT_NAME);
        employee.setAge(DEFAULT_AGE);
        employee.setSalary(DEFAULT_SALARY);
        employee.setDesignation(DEFAULT_DESIGNATION);
        List<Employee> employeeData = new ArrayList<>();
        employeeData.add(employee);

        // when
        when(employeeServiceMock.getListEmployees())
                .thenReturn(employeeData);
        

        // then
        mockMvc.perform(get("/api/listAllEmployee"))
            	.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("Jane")));
        

        verify(employeeServiceMock, times(1)).getListEmployees();
        verifyNoMoreInteractions(employeeServiceMock);
    }

    /**
     * Test of getListEmployeeOnlyOneOcc method, of class ControllerEmployee.
     */
    @Test
    public void testGetListEmployeeOnlyOneOcc() throws Exception {
        
          // given : unique critetrian ( byName)
          // test if result has duplicate  line with same name
        Employee employee_1 = new Employee();
        employee_1.setId(DEFAULT_ID);
        employee_1.setName(DEFAULT_NAME);
        employee_1.setAge(DEFAULT_AGE);
        employee_1.setSalary(DEFAULT_SALARY);
        employee_1.setDesignation(DEFAULT_DESIGNATION);
        
        List<Employee> employeesData = new ArrayList<>();
        employeesData.add(employee_1);
        
        Employee employee_2 = new Employee();
        employee_2.setId(DEFAULT_ID);
        employee_2.setName(DEFAULT_NAME);
        employee_2.setAge(DEFAULT_AGE);
        employee_2.setSalary(DEFAULT_SALARY);
        employee_2.setDesignation(DEFAULT_DESIGNATION);
      
        employeesData.add(employee_2);
        employeesData.forEach(emp ->
            System.out.print(emp)
        );

        // when
        when(employeeServiceMock.getListEmployeeWithoutDuplicate(CRITERIA_BY_NAME))
                .thenReturn(employeesData);
        

        // then
       mockMvc.perform(get("/api/listEmployee?uCreteria="+CRITERIA_BY_NAME))
            	.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(2)))
                                .andExpect(jsonPath("$[0].name", is("Jane")))
                                .andExpect(jsonPath("$[1].name", is("Jane")))
                                .andExpect(jsonPath("$[0].age", is(29)))
                                .andExpect(jsonPath("$[1].age", is(29)));
          

        verify(employeeServiceMock, times(1)).getListEmployeeWithoutDuplicate(CRITERIA_BY_NAME);
        verifyNoMoreInteractions(employeeServiceMock);
    
    }

}