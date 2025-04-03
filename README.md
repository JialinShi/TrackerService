# 模拟 TikTok 用户点击推荐位

### 
RecommendationTracker/
├── tracker-service/         → Spring Boot 接口服务（记录行为）
├── kafka-simulator/         → 模拟 Kafka 消息生产与消费
├── storage/                 → MySQL 表结构 + 插入逻辑
├── README.md


### kafka workflow

│
![relationship] (table.png)

## 📌 Features

- Accepts user behavior data via a POST endpoint
- Simulates Kafka producer → consumer workflow
- Stores behavior logs in a MySQL database
- End-to-end logging to track every step of data flow
- Fully extensible: easily swap mock Kafka for real Kafka

---
```

Each component is responsible for:
- `Controller`: Handles incoming POST requests to `/trackEvent`
- `KafkaProducerService`: Sends user event to Kafka (mocked)
- `MockKafkaTemplate`: Simulates Kafka behavior and invokes consumer
- `UserEventConsumer`: Processes received events and saves to database
- `UserEventRepository`: JPA interface for persisting `UserEvent` entities
- `MySQL`: Stores user behavior records

---

### 🔍 Data Format:
**POST /trackEvent**
```json
{
  "userId": "u123",
  "eventType": "click",
  "pageId": "home",
  "itemId": "video789",
  "timestamp": 1712000000
}
```

### 🧠 Concepts Practiced
MVC: Controller → Service → Repository

Data persistence with Spring Data JPA

Message flow simulation (Kafka-like)

Application layering and logging

Full backend traceability



