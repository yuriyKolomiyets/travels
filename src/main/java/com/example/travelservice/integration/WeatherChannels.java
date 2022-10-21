package com.example.travelservice.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface WeatherChannels {

    String WEATHER_RESPONSE_INPUT_CHANNEL = "weather-response-exchange";

    String WEATHER_REQUEST_OUTPUT_CHANNEL = "weather-request-exchange";

    @Input(WEATHER_RESPONSE_INPUT_CHANNEL)
    SubscribableChannel weatherResponse();

    @Output
    MessageChannel weatherRequest();
}
