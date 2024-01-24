package com.microservice.orderservice.config;

import com.microservice.orderservice.event.OrderPlaceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, OrderPlaceEvent> kafkaTemplate;

    public void send(String orderId){
        kafkaTemplate.send("notificationTopic", new OrderPlaceEvent(orderId));
    }
}
