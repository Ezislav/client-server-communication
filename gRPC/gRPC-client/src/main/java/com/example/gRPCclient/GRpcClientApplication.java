package com.example.gRPCclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GRpcClientApplication implements CommandLineRunner {

	@Autowired
	private HelloWorldClient helloWorldClient;

	public static void main(String[] args) {
		SpringApplication.run(GRpcClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String response = helloWorldClient.sayHello("John");
		System.out.println(response);
	}
}
