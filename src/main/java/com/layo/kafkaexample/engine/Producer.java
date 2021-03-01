package com.layo.kafkaexample.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
    }



    @Scheduled(cron = "*/2 * * * * *")
    public void send() throws ExecutionException, InterruptedException {

        String dov = "jimmi";
        String dov1 = "romi";
        String dov2 = "sudo";
        String dov3 = "gomi";
        List<String> dg = new ArrayList<>();
        dg.add(dov);
        dg.add(dov1);
        dg.add(dov2);
        dg.add(dov3);

        dg.forEach(message -> sendMessage("INPUT_DATA",
                "IN_KEY", message));
    }



}

