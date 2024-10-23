package org.todoapp.service;

import org.todoapp.model.Tag;
import org.todoapp.model.Task;

import java.util.List;

public interface TaskService {
    void addTask(Task task);
    Task getTask(String taskId);
    void modifyTask(Task task);
    void removeTask(String taskId);
    List<Task> listTasks();
    List<Task> listTasksByTag(Tag tag);
    void markTaskAsCompleted(String taskId);
}
