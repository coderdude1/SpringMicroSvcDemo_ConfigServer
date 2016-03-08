package com.dood.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * This is the main springboot application class that will fire up spring config server.  There really is nothing
 * to it, the real magic is the @EnableConfigServer
 */
@SpringBootApplication
@EnableConfigServer
public class SpringConfigServerMicroSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerMicroSvcApplication.class, args);
	}
}
