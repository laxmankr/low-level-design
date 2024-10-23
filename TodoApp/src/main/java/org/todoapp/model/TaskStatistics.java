package org.todoapp.model;

public class TaskStatistics {
    private int tasksAdded;
    private int tasksCompleted;
    private int tasksOverdue;

    public TaskStatistics(int tasksAdded, int tasksCompleted, int tasksOverdue) {
        this.tasksAdded = tasksAdded;
        this.tasksCompleted = tasksCompleted;
        this.tasksOverdue = tasksOverdue;
    }

    // Getters
    public int getTasksAdded() { return tasksAdded; }
    public int getTasksCompleted() { return tasksCompleted; }
    public int getTasksOverdue() { return tasksOverdue; }

    @Override
    public String toString() {
        return "TaskStatistics{" +
                "tasksAdded=" + tasksAdded +
                ", tasksCompleted=" + tasksCompleted +
                ", tasksOverdue=" + tasksOverdue +
                '}';
    }
}

