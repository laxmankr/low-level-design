package org.todoapp.logger.impl;

import org.todoapp.logger.ActivityLogger;
import org.todoapp.repository.ActivityLoggerRepo;

public class ActivityLoggerImpl implements ActivityLogger {
    ActivityLoggerRepo activityLoggerRepo;

    public ActivityLoggerImpl(ActivityLoggerRepo activityLoggerRepo){
        this.activityLoggerRepo = activityLoggerRepo;
    }

    @Override
    public void logActivity(String activity) {
        activityLoggerRepo.addActivity(activity);
    }

    @Override
    public void showLog() {
        activityLoggerRepo.getActivities().forEach(System.out::println);
    }
}

