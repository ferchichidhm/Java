/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testels.test.repository;

import com.testels.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HFerchichi
 */
@Repository
public interface EmployeeRpository  extends JpaRepository<Employee,Integer>{
    
}
