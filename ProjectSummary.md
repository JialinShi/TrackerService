**Project Summary: User Behavior Tracking System (Mock Kafka Version)**

---

### 📊 Project Purpose:
Simulate a basic recommendation infrastructure backend by tracking user behavior events (e.g., click/view/play) and storing them in a MySQL database using a Spring Boot backend. This is an ideal beginner project to understand how modern distributed logging and event systems like Kafka work.

---

### 📚 Key Technologies:
- **Java 17** (Temurin)
- **Spring Boot 2.7+**
- **Mock Kafka** (custom simulated implementation)
- **MySQL 8+** (local)
- **Maven** (for dependency management)
- **Postman / curl** (for API testing)

---

### 👨‍💻 System Architecture Overview:

```text
User (Postman / curl)
     |
     v
Controller  -->  KafkaProducerService  -->  MockKafkaTemplate  -->  UserEventConsumer  -->  UserEventRepository  -->  MySQL
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

---

### 🔢 Database: user_event Table
Auto-created by Spring JPA based on the `UserEvent` entity:

| id (PK) | userId | eventType | pageId | itemId | timestamp |
|---------|--------|-----------|--------|--------|-----------|
| (auto)  | u123   | click     | home   | video789 | 1712...  |

---

### 🔐 Notes & Lessons Learned
- Spring Boot auto-configuration + annotation-based development is powerful but requires careful setup (esp. JDK + annotation processors)
- Mocking Kafka allows us to decouple from infrastructure problems and focus on business flow
- Lombok is helpful, but can be skipped with manual getters/setters if needed

---

### ✅ Future Improvements (Optional for next project)
- Replace MockKafka with real Kafka + Zookeeper (via Docker)
- Add GET API to retrieve behavior history by user ID or event type
- Add frontend visualization (HTML + chart.js)
- Extend event types (e.g., purchase, search, bookmark)
- Add metrics or logging framework (e.g., Micrometer + Prometheus)

