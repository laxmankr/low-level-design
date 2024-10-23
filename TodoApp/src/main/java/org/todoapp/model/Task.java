package org.todoapp.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Task {
    private String taskId;
    private String description;
    private LocalDateTime deadline;
    private boolean completed;
    private Set<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String taskId, String description, LocalDateTime deadline, Set<Tag> tags) {
        this.taskId = taskId;
        this.description = description;
        this.deadline = deadline;
        this.tags = tags;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", completed=" + completed +
                ", tags=" + tags +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    // Getters and Setters
    public String getTaskId() { return taskId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getDeadline() { return deadline; }
    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
    public boolean isCompleted() { return completed; }
    public void markAsCompleted() { this.completed = true; }
    public Set<Tag> getTags() { return tags; }
    public void setTags(Set<Tag> tags) { this.tags = tags; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
