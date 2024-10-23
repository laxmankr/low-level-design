package org.todoapp.repository.impl;

import org.todoapp.repository.ActivityLoggerRepo;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLoggerRepoImpl implements ActivityLoggerRepo {
    List<String> activityLogger = new ArrayList<>();
    @Override
    public void addActivity(String message) {
        activityLogger.add(message);
    }

    @Override
    public List<String> getActivities() {
        return activityLogger;
    }
}
