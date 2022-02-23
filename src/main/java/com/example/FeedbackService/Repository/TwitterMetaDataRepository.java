package com.example.FeedbackService.Repository;

import com.example.FeedbackService.Model.Feedback;
import com.example.FeedbackService.Model.TwitterMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterMetaDataRepository extends JpaRepository<TwitterMetaData, Integer> {
}
