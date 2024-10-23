package org.todoapp.service.impl;

import org.todoapp.model.Tag;
import org.todoapp.model.Task;
import org.todoapp.repository.TaskRepository;
import org.todoapp.service.TaskService;
import org.todoapp.exception.InvalidTaskException;
import org.todoapp.exception.TaskNotFoundException;
import org.todoapp.logger.ActivityLogger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    private ActivityLogger activityLogger;
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ActivityLogger activityLogger) {
        this.taskRepository = taskRepository;
        this.activityLogger = activityLogger;
    }

    @Override
    public void addTask(Task task) {
        if (task == null || task.getDescription() == null || task.getDescription().isEmpty()) {
            throw new InvalidTaskException("Task description cannot be null or empty.");
        }
        taskRepository.addTask(task);
        activityLogger.logActivity("Added task " + task.getTaskId());
    }

    @Override
    public Task getTask(String taskId) {
        Task task = taskRepository.getTask(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
        return task;
    }

    @Override
    public synchronized void modifyTask(Task task) {
        if (task == null || task.getTaskId() == null || task.getTaskId().isEmpty()) {
            throw new InvalidTaskException("Invalid task ID.");
        }
        Task existingTask = taskRepository.getTask(task.getTaskId());
        if (existingTask == null) {
            throw new TaskNotFoundException("Task with ID " + task.getTaskId() + " not found.");
        }
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.modifyTask(task);
        activityLogger.logActivity("Modified task " + task.getTaskId());
    }

    @Override
    public void removeTask(String taskId) {
        if (taskId == null || taskId.isEmpty()) {
            throw new InvalidTaskException("Task ID cannot be null or empty.");
        }
        Task task = taskRepository.getTask(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
        taskRepository.removeTask(taskId);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.listTasks();
    }

    @Override
    public List<Task> listTasksByTag(Tag tag) {
        return taskRepository.listTasks().stream()
                .filter(task -> task.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    @Override
    public void markTaskAsCompleted(String taskId) {
        Task task = taskRepository.getTask(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
        task.markAsCompleted();
        taskRepository.modifyTask(task);
        activityLogger.logActivity("Completed task 2");
//        taskRepository.removeTask(taskId); // Completed tasks are removed from the active list
    }
}
