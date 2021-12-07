package com.epam.two;

import com.netflix.servo.DefaultMonitorRegistry;
import com.netflix.servo.Metric;
import com.netflix.servo.monitor.BasicGauge;
import com.netflix.servo.monitor.BasicInformational;
import com.netflix.servo.monitor.Gauge;
import com.netflix.servo.monitor.MonitorConfig;
import com.netflix.servo.publish.BasicMetricFilter;
import com.netflix.servo.publish.JvmMetricPoller;
import com.netflix.servo.publish.MemoryMetricObserver;
import com.netflix.servo.publish.PollRunnable;
import com.netflix.servo.publish.PollScheduler;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationTwo {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationTwo.class, args);
  }
}

@RestController
@RequestMapping("/")
class Controller {

  @SneakyThrows
  @GetMapping
  public String doMetricsExample() {
    // Informational
    BasicInformational informational = new BasicInformational(MonitorConfig.builder("test").build());
    informational.setValue("information collected");

    // MonitorRegistry
    Gauge<Double> gauge = new BasicGauge<>(MonitorConfig.builder("test")
        .build(), () -> 2.32);
    DefaultMonitorRegistry.getInstance().register(gauge);

    // MetricPoller
    MemoryMetricObserver observer = new MemoryMetricObserver();
    PollRunnable pollRunnable = new PollRunnable(new JvmMetricPoller(),
        new BasicMetricFilter(true), observer);
    PollScheduler.getInstance().start();
    PollScheduler.getInstance().addPoller(pollRunnable, 1, SECONDS);
    SECONDS.sleep(1);
    PollScheduler.getInstance().stop();
    List<List<Metric>> metrics = observer.getObservations();

    return "TWO";
  }
}
