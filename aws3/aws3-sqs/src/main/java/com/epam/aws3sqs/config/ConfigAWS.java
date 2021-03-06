package com.epam.aws3sqs.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Configuration
public class ConfigAWS {

  @Value("${cloud.aws.credentials.key.access}")
  private String accessKey;

  @Value("${cloud.aws.credentials.key.secret}")
  private String privateKey;

  @Bean
  public AWSCredentials awsCredentials() {
    return new BasicAWSCredentials(accessKey, privateKey);
  }

  @Bean
  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
        .withRegion(Regions.US_EAST_1)
        .build();
  }
}
