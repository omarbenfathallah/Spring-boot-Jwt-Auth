package tn.esprit.tic.springproj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProjApplication.class, args);
        System.out.println("hello");


    }




}
