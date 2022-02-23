package com.example.FeedbackService.Repository;

import com.example.FeedbackService.Model.Sources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Sources, Integer> {

    Sources findByname(String name);
}
