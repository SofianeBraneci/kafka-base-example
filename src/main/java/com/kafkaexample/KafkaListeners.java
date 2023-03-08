package com.kafkaexample;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "topic", groupId = "foo")
    void listener(String data){
        System.out.println("Listener, data was received : " + data);
    }
}
