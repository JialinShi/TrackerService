package com.recommendation.tracker_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// ✅ 这是我们的“消费者类”，模拟推荐系统监听到 Kafka 中的行为
@Component
public class UserEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(UserEventConsumer.class);

    private final UserEventRepository repository;

    public UserEventConsumer(UserEventRepository repository){
        this.repository = repository;
    }

    // ✅ 这个方法是模拟 Kafka 收到一条行为后的处理逻辑
    public void consume(UserEvent event) {
        logger.info("📥 [CONSUMER] Received and processed event: {}", event);

        // ✅ 存入数据库
        repository.save(event);
        logger.info("✅ [DB] Saved to MySQL");
    }


}
