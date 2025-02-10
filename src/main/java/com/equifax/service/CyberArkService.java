package com.equifax.service;

import com.equifax.model.PasswordRotationDetails;
import com.equifax.repositories.PasswordRotationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CyberArkService {

    private static final Logger logger = LoggerFactory.getLogger(CyberArkService.class);

    @Autowired
    private PasswordRotationRepository repository;

    public void fetchAndUpdatePasswordRotationData() {
        // Fetch data from CyberArk API
        List<PasswordRotationDetails> cyberArkData = fetchDataFromCyberArk();

        for (PasswordRotationDetails details : cyberArkData) {
            // Calculate expiry date as lastModifiedDate + 90 days
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(details.getLastModifiedDate());
            calendar.add(Calendar.DAY_OF_YEAR, 90);
            details.setPasswordExpiryDate(calendar.getTime());

            // Save or update the record in the database
            repository.save(details);
            logger.info("Updated password rotation data for application: " + details.getApplicationName());
        }
    }

    private List<PasswordRotationDetails> fetchDataFromCyberArk() {
        // Replace this with actual CyberArk API calls
        PasswordRotationDetails details1 = new PasswordRotationDetails();
        details1.setApplicationName("App1");
        details1.setUsername("user1");
        details1.setLastModifiedDate(new Date());
        details1.setStatus("Active");

        PasswordRotationDetails details2 = new PasswordRotationDetails();
        details2.setApplicationName("App2");
        details2.setUsername("user2");
        details2.setLastModifiedDate(new Date());
        details2.setStatus("Active");

        return List.of(details1, details2);
    }
}
