package org.todoapp;

import org.todoapp.exception.InvalidTaskException;
import org.todoapp.exception.TaskNotFoundException;
import org.todoapp.logger.ActivityLogger;
import org.todoapp.logger.impl.ActivityLoggerImpl;
import org.todoapp.model.Tag;
import org.todoapp.model.Task;
import org.todoapp.repository.ActivityLoggerRepo;
import org.todoapp.repository.TaskRepository;
import org.todoapp.repository.impl.InMemoryLoggerRepoImpl;
import org.todoapp.repository.impl.InMemoryTaskRepository;
import org.todoapp.service.TaskService;
import org.todoapp.service.TaskStatisticsService;
import org.todoapp.service.impl.TaskServiceImpl;
import org.todoapp.service.impl.TaskStatisticsServiceImpl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TodoApplication {
    public static void main(String[] args) {
        TaskRepository taskRepository = new InMemoryTaskRepository();
        ActivityLoggerRepo activityLoggerRepo = new InMemoryLoggerRepoImpl();
        ActivityLogger activityLogger = new ActivityLoggerImpl(activityLoggerRepo);

        TaskService taskService = new TaskServiceImpl(taskRepository,activityLogger );
        TaskStatisticsService statisticsService = new TaskStatisticsServiceImpl(taskRepository);

        try {
            // Add some tasks
            Set<Tag> tags1 = new HashSet<>();
            tags1.add(Tag.OFFICE_WORK);
            Task task1 = new Task("1", "Complete project", LocalDateTime.now().plusDays(2), tags1);
            taskService.addTask(task1);

            Set<Tag> tags2 = new HashSet<>();
            tags2.add(Tag.PERSONAL_WORK);
            tags2.add(Tag.OFFICE_WORK);
            Task task2 = new Task("2", "Prepare report", LocalDateTime.now().plusDays(1), tags2);
            taskService.addTask(task2);

            // Modify a task task 1
            task1.setDescription("Complete project with documentation");
            taskService.modifyTask(task1);

            // List of tasks based on tag
            System.out.println("\nOffice works:");
            List<Task> office_tasks =  taskService.listTasksByTag(Tag.OFFICE_WORK);
            for(Task task: office_tasks){
                System.out.println(task.toString());
            }
            // List of tasks based on tag
            System.out.println("\nPersonal works:");
            List<Task> personal_tasks =  taskService.listTasksByTag(Tag.PERSONAL_WORK);
            for(Task task: personal_tasks){
                System.out.println(task.toString());
            }

            // Complete a task 2
            taskService.markTaskAsCompleted("2");




            // Show log
            System.out.println("\nActivity Log:");
            activityLogger.showLog();

            // Show statistics
            System.out.println("\nTask Statistics:");
            System.out.println(statisticsService.getStatistics().toString());

            // Handle exception: Trying to fetch a non-existing task
            taskService.getTask("999");  // This will throw TaskNotFoundException

        } catch (TaskNotFoundException | InvalidTaskException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
