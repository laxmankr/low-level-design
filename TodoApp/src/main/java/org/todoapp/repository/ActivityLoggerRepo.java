package org.todoapp.repository;

import java.util.List;

public interface ActivityLoggerRepo {
    void addActivity(String message);
    List<String> getActivities();
}
