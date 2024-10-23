package org.todoapp.service.impl;


import org.todoapp.model.Task;
import org.todoapp.model.TaskStatistics;
import org.todoapp.repository.TaskRepository;
import org.todoapp.service.TaskStatisticsService;

import java.util.List;

public class TaskStatisticsServiceImpl implements TaskStatisticsService {
    private TaskRepository taskRepository;

    public TaskStatisticsServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskStatistics getStatistics() {
        List<Task> tasks = taskRepository.listTasks();
        int tasksAdded = tasks.size();
        int tasksCompleted = (int) tasks.stream().filter(Task::isCompleted).count();
        int tasksOverdue = (int) tasks.stream().filter(task -> task.getDeadline().isBefore(java.time.LocalDateTime.now())).count();
        return new TaskStatistics(tasksAdded, tasksCompleted, tasksOverdue);
    }

    @Override
    public String toString() {
        return "TaskStatisticsServiceImpl{" +
                "taskRepository=" + taskRepository +
                '}';
    }
}
