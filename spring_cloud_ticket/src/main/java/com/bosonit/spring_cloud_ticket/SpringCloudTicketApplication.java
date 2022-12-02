package com.bosonit.spring_cloud_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class SpringCloudTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTicketApplication.class, args);
	}

}
