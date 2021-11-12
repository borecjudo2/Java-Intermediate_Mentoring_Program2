package com.epam.one;

import com.netflix.servo.monitor.BasicCounter;
import com.netflix.servo.monitor.BasicGauge;
import com.netflix.servo.monitor.BasicTimer;
import com.netflix.servo.monitor.Counter;
import com.netflix.servo.monitor.Gauge;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.monitor.Stopwatch;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.TimeUnit.SECONDS;

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

  @SneakyThrows
  @GetMapping
  public String doMetricsExample() {
    // counter
    Counter counter = new BasicCounter(MonitorConfig.builder("test").build());
    counter.increment();
    counter.increment(-1);

    // gauge
    Gauge<Double> gauge = new BasicGauge<>(MonitorConfig.builder("test").build(), () -> 2.32);

    // timer
    BasicTimer timer = new BasicTimer(MonitorConfig.builder("test").build(), SECONDS);
    Stopwatch stopwatch = timer.start();
    SECONDS.sleep(1);
    timer.record(2, SECONDS);
    stopwatch.stop();

    return "ONE";
  }
}
