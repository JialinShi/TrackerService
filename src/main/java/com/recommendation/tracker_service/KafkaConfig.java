package com.recommendation.tracker_service;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;


// ✅ @Configuration 表示这是一个“配置类”，Spring 会扫描它来生成 Bean
@Configuration
public class KafkaConfig {

    // ✅ 这个方法创建一个 Kafka 的 Producer 工厂（生产者配置）
    // ✅ @Bean 表示这个方法返回的对象将交给 Spring 管理，以便注入使用
    @Bean
    public ProducerFactory<String, Object> producerFactory(){
        Map<String, Object> config = new HashMap<>();

        // ✅ 设置 Kafka 的连接地址（你也可以用配置文件注入）
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // ✅ 设置消息的 Key 使用 String 类型序列化（Kafka 消息是 key-value 结构）
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // ✅ 设置消息的 Value（即我们的 UserEvent 对象）使用 JSON 序列化方式
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    // ✅ 创建 KafkaTemplate Bean，供我们注入使用（发送消息用）
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
