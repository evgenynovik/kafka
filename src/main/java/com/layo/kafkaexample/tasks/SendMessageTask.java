package com.layo.kafkaexample.tasks;

import com.layo.kafkaexample.engine.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
//@Component
public class SendMessageTask {

    private final Producer producer;

    //@Autowired
    public SendMessageTask(Producer producer) {
        this.producer = producer;
    }

//    @Scheduled(cron = "*/2 * * * * *")
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

        dg.forEach(message -> this.producer.sendMessage("INPUT_DATA",
                "IN_KEY", message));
    }
}