package com.jrbrayjr.poc.stream.rabbitcloud;

import com.jrbrayjr.poc.stream.rabbitcloud.user.UserSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableBinding({ BasicSource.class, UserSource.class })
@EnableAutoConfiguration
@SpringBootApplication
public class RabbitCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitCloudApplication.class, args);
	}
}
