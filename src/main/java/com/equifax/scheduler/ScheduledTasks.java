package com.equifax.scheduler;

import com.equifax.service.CyberArkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private CyberArkService cyberArkService;

    @Scheduled(fixedRate = 86400000) // Run every 24 hours
    public void updatePasswordRotationData() {
        try {
            cyberArkService.fetchAndUpdatePasswordRotationData();
            logger.info("Successfully updated password rotation data from CyberArk.");
        } catch (Exception e) {
            logger.error("Error updating password rotation data: " + e.getMessage());
        }
    }
}