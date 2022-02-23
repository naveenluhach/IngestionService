package com.example.feedbackservice.repository;

import com.example.feedbackservice.model.TwitterMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterMetaDataRepository extends JpaRepository<TwitterMetaData, Integer> {
}
