package com.epam.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationOne {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationOne.class, args);
  }
}

@RestController
@RequestMapping("/")
class Controller {

  @GetMapping
  public String getName() {
    return "ONE";
  }
}
