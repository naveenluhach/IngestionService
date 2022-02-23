package com.example.feedbackservice.repository;

import com.example.feedbackservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

 @Repository
 public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

  @Query(value = "SELECT * FROM FEEDBACK f WHERE f.sourceid = :sourceid and f.tenantId = :tenantId",
          nativeQuery = true)
  Feedback getFeedbackbySourceIDAndTenantID(@Param("sourceid") int sourceid, @Param("tenantId") int tenantId);
 }
