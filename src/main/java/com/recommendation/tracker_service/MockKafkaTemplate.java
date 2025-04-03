package com.recommendation.tracker_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class MockKafkaTemplate {
    private static final Logger logger = LoggerFactory.getLogger(MockKafkaTemplate.class);

    private final UserEventConsumer consumer;

    // ✅ 通过构造方法注入我们的“模拟消费者”
    public MockKafkaTemplate(UserEventConsumer consumer) {
        this.consumer = consumer;
    }

    public void send(String topic, Object data) {
        logger.info("🧪 [MOCK KAFKA] Sent to topic '{}': {}", topic, data);

        // ✅ 调用 consumer 模拟 Kafka 消费
        if (data instanceof UserEvent) {
            consumer.consume((UserEvent) data);
        }
    }

}
