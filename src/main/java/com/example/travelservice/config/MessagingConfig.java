package com.example.travelservice.config;

import com.example.travelservice.integration.WeatherChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(WeatherChannels.class)
public class MessagingConfig {
}
