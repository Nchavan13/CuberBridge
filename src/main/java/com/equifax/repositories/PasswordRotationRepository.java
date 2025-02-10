package com.equifax.repositories;


import com.equifax.model.PasswordRotationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasswordRotationRepository extends JpaRepository<PasswordRotationDetails, Long> {
    List<PasswordRotationDetails> findByStatus(String status);
}
