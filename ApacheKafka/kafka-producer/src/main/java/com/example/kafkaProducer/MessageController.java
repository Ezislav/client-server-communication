package com.example.kafkaProducer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Service
@EnableScheduling
public class MessageController {
    private static final String TOPIC = "testTopic";
    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @GetMapping("/send/{message}")
//    public String sendMessage(@PathVariable String message) {
//        kafkaTemplate.send(TOPIC, message);
//        return "Sent message: " + message;
//    }
    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        System.out.println("Send Message " + LocalDateTime.now());
        kafkaTemplate.send(TOPIC, "automatic message from " + LocalDateTime.now());
    }
}
