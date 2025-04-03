package com.recommendation.tracker_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**这是一个业务逻辑类，负责“把用户行为数据发到 Kafka”*/

// ✅ 这个注解表示：这个类是“业务逻辑服务类”，会被 Spring 自动识别并托管为 Bean
// ✅ @Service 是 @Component 的子注解之一，语义上代表“逻辑服务层”
@Service
public class KafkaProducerService {
    /** ✅ KafkaTemplate 是 Spring Kafka 提供的“发送消息”的核心类
     * ✅ 泛型 <String, Object> 表示：Key 是 String，消息内容是任意对象（比如 UserEvent）
     */
//    private final KafkaTemplate<String, Object> kafkaTemplate;

    /** ✅ @Value 是 Spring 的注入注解：从配置文件 application.properties 中读取值
     ✅ 这里注入我们定义的 Kafka topic 名称（可在配置文件中改，不用写死在代码里）
     */
//    @Value("${app.kafka.topic}")
//    private String topic;

    /*** ✅ 构造方法注入 KafkaTemplate 实例，Spring 会自动提供这个 Bean
     *
     */
//    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }

//    public void sendUserEvent0(UserEvent userEvent){
//        // ✅ 发送消息到 Kafka（发送到指定 topic，内容为 event 对象）
//        kafkaTemplate.send(topic, userEvent);
//    }


    /**Mock 版本 - 如果可以用docker就不用mock
     *
     * private final MockKafkaTemplate mockKafkaTemplate;
     *     @Value("${app.kafka.topic}")
     *     private String topic;
     *     public KafkaProducerService(MockKafkaTemplate mockKafkaTemplate){
     *         this.mockKafkaTemplate = mockKafkaTemplate;
     *     }
     *     public void sendUserEvent(UserEvent userEvent){
     *         // ✅ 发送消息到 Kafka（发送到指定 topic，内容为 event 对象）
     *         mockKafkaTemplate.send(topic, userEvent);
     *     }
     *
     **/

           private final MockKafkaTemplate mockKafkaTemplate;
           @Value("${app.kafka.topic}")
           private String topic;
           public KafkaProducerService(MockKafkaTemplate mockKafkaTemplate){
               this.mockKafkaTemplate = mockKafkaTemplate;
           }
           public void sendUserEvent(UserEvent userEvent){
               // ✅ 发送消息到 Kafka（发送到指定 topic，内容为 event 对象）
               mockKafkaTemplate.send(topic, userEvent);
           }

}
