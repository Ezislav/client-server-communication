package com.example.kafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "testTopic", groupId = "groupId")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}