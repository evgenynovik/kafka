package com.layo.kafkaexample.engine;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@EnableKafka
@Service
public class Consumer {

    @KafkaListener(topics = {"INPUT_DATA"})
    public void consume(final @Payload String messages
                      //  final @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                      //  final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) {
        log.info(String.format(" Consumed message ->  %s ",
                messages));
    }

//    @KafkaListener(topics = {"INPUT_DATA"})
//    public void orderListener(ConsumerRecord<Long, List<String>> record) {
//        System.out.println(record.partition());
//        log.info(record.key().toString());
//        log.info(record.value().toString());
//    }
}

