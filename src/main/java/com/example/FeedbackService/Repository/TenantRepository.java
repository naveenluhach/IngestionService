package com.example.FeedbackService.Repository;

import com.example.FeedbackService.Model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {


    Tenant findByname(String name);
}
