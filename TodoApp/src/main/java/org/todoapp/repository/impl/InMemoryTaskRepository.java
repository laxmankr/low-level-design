package org.todoapp.repository.impl;

import org.todoapp.model.Task;
import org.todoapp.repository.TaskRepository;

import java.util.*;

public class InMemoryTaskRepository implements TaskRepository {
    private Map<String, Task> tasks = new HashMap<>();

    @Override
    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    @Override
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    @Override
    public void modifyTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            tasks.put(task.getTaskId(), task);
        }
    }

    @Override
    public void removeTask(String taskId) {
        tasks.remove(taskId);
    }

    @Override
    public List<Task> listTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public String toString() {
        return "InMemoryTaskRepository{" +
                "tasks=" + tasks +
                '}';
    }
}

