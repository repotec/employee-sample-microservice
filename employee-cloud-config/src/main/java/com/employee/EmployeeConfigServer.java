package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EmployeeConfigServer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeConfigServer.class, args);
	}

}
