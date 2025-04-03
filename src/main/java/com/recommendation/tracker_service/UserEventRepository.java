package com.recommendation.tracker_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ✅ JpaRepository 提供 CRUD 接口，无需自己写 SQL
@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

}


