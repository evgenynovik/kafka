package com.layo.kafkaexample.engine;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Configuration
public class KafkaProducerConfig {

    private String kafkaServer="192.168.99.100:9092";

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return props;
    }

//    @Bean
//    public ProducerFactory<String, List<String>> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }

//    @Bean
//    public KafkaTemplate<String, List<String>> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}
