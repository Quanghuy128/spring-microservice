package com.microservice.orderservice.config;

import com.microservice.orderservice.event.OrderPlaceEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, OrderPlaceEvent> kafkaTemplate;

    public void send(OrderPlaceEvent orderPlaceEvent){
        Message<OrderPlaceEvent> message = MessageBuilder
                .withPayload(orderPlaceEvent)
                        .setHeader(KafkaHeaders.TOPIC, "notificationTopic")
                                .build();
        kafkaTemplate.send(message);
    }
}
