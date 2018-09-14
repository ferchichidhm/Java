package com.testels.test;

import com.testels.test.service.EmpolyeeService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
    
@Autowired
EmpolyeeService empolyeeService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        empolyeeService.importFileToDataBase();
    }
}
