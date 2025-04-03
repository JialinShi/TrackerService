package com.recommendation.tracker_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController  // 标注这是一个 REST 风格的 Controller（用于接收外部 HTTP 请求）

public class TrackEventController {
    // ✅ 创建一个日志记录器，用于输出收到的用户行为
    private static  final Logger logger = LoggerFactory.getLogger(TrackEventController.class);
    private final KafkaProducerService kafkaProducerService; // 发送信息给kafka
    public TrackEventController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }


    @PostMapping("/trackEvent") //  这个接口地址是 POST 类型的 /trackEvent，客户端将 JSON 传过来 http post 方法：新增/提交数据
    public void trackUserEvent(@RequestBody UserEvent userEvent){ // ✅ 将收到的 JSON 自动转换为 UserEvent Java 对象
        logger.info("📥 Received user event: {}", userEvent); // ✅ 然后打印日志（后续我们会在这里发送 Kafka）
        kafkaProducerService.sendUserEvent(userEvent); // ✅ 调用 Producer，模拟发送到 Kafka
    }


}
