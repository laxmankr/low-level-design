package org.todoapp.repository;

import org.todoapp.model.Task;

import java.util.List;

public interface TaskRepository {
    void addTask(Task task);
    Task getTask(String taskId);
    void modifyTask(Task task);
    void removeTask(String taskId);
    List<Task> listTasks();
}
