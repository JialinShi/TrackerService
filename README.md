# 模拟 TikTok 用户点击推荐位

### 
RecommendationTracker/
├── tracker-service/         → Spring Boot 接口服务（记录行为）
├── kafka-simulator/         → 模拟 Kafka 消息生产与消费
├── storage/                 → MySQL 表结构 + 插入逻辑
├── README.md


### kafka workflow
+--------------------------+
|  前端 / curl / Postman   |
|    发出用户行为请求      |
| POST /trackEvent         |
| JSON: UserEvent          |
+-----------+--------------+
|
▼
+--------------------------+
|  @RestController         |
|  TrackEventController    |
|  🔹 接收请求              |
|  🔹 使用 @RequestBody 映射|
|  🔹 调用 KafkaProducerSvc|
+-----------+--------------+
|
▼
+--------------------------+
|  KafkaProducerService    |
|  🔹 注入 KafkaTemplate   |
|  🔹 读取配置中的 topic    |
|  🔹 执行 kafkaTemplate.send |
+-----------+--------------+
|
▼
+--------------------------+
|  KafkaTemplate（Spring） |
|  🔹 自动 JSON 序列化     |
|  🔹 发送到 Kafka broker  |
+-----------+--------------+
|
▼
+-----------------------------+
|       Kafka Broker          |
|  📦 topic: user-behavior-topic |
|  🔄 等待下游消费行为数据     |
+-----------------------------+
[Postman / curl (发送 JSON 请求)]
│
▼
┌────────────────────────────┐
│    TrackEventController    │  ← 接收前端用户行为（POST）
└────────────────────────────┘
│
▼
┌────────────────────────────┐
│   KafkaProducerService     │  ← 把用户行为发送到 Kafka（mock）
└────────────────────────────┘
│
▼
┌────────────────────────────┐
│     MockKafkaTemplate      │  ← 模拟 Kafka，把消息传给 Consumer
└────────────────────────────┘
│
▼
┌────────────────────────────┐
│     UserEventConsumer      │  ← 模拟“收到消息”，保存到数据库
└────────────────────────────┘
│
▼
┌────────────────────────────┐
│    UserEventRepository     │  ← 调用 save() 方法存进 MySQL
└────────────────────────────┘
│
▼
┌────────────────────────────┐
│        MySQL 数据库         │  ← 保存行为记录（user_event 表）
└────────────────────────────┘
![relationship] (table.png)

## 📌 Features

- Accepts user behavior data via a POST endpoint
- Simulates Kafka producer → consumer workflow
- Stores behavior logs in a MySQL database
- End-to-end logging to track every step of data flow
- Fully extensible: easily swap mock Kafka for real Kafka

---

### 🧠 Concepts Practiced
MVC: Controller → Service → Repository

Data persistence with Spring Data JPA

Message flow simulation (Kafka-like)

Application layering and logging

Full backend traceability



