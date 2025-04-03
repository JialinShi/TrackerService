package com.recommendation.tracker_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**用户行为数据模型类 - 设计一个 Java 类，来接收客户端发送的用户行为事件
 * {
 *   "userId": "u123",
 *   "eventType": "click",
 *   "pageId": "video_feed",
 *   "itemId": "video_456",
 *   "timestamp": 1711995500
 * }
 *
 *  Tip：
 * 我们用 Lombok 来自动生成模板代码，这样更能聚焦业务逻辑而不是写一堆 getter/setter */


@Entity // ✅ 表示这个类对应数据库中的一张表

public class UserEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ✅ 数据库主键自动生成

    // ✅ 必须有无参构造函数（JPA 需要）
    public UserEvent() {}

    private String userId;
    private String eventType;
    private String pageId;
    private String itemId;
    private long timestamp;

    // 全参构造（可选）
    public UserEvent(String userId, String eventType, String pageId, String itemId, long timestamp) {
        this.userId = userId;
        this.eventType = eventType;
        this.pageId = pageId;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
