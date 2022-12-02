package com.bosonit.spring_cloud_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class SpringCloudTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTicketApplication.class, args);
	}

}
