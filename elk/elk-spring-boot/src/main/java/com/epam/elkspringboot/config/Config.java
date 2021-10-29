package com.epam.elkspringboot.config;

import com.epam.elkspringboot.model.Event;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.epam.elkspringboot.repo")
@ComponentScan(basePackages = {"com.epam.elkspringboot"})
public class Config {

  @Bean
  public RestHighLevelClient client() {
    ClientConfiguration clientConfiguration
        = ClientConfiguration.builder()
        .connectedTo("localhost:9200")
        .build();

    return RestClients.create(clientConfiguration).rest();
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    ElasticsearchRestTemplate elasticsearchRestTemplate = new ElasticsearchRestTemplate(client());
    elasticsearchRestTemplate.indexOps(Event.class).createMapping();
    return elasticsearchRestTemplate;
  }
}