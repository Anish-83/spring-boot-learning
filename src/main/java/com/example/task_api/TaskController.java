package com.example.task_api;



import com.example.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaskController {
    // Hardcoded task list
    private List<Task> tasks = Arrays.asList(
        new Task(1, "Code", "pending"),
        new Task(2, "Test", "done"),
        new Task(3, "Deploy", "pending")
    );

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/tasks/pending")
    public List<Task> getPendingTasks() {
        return tasks.stream()
            .filter(t -> t.getStatus().equals("pending"))
            .collect(Collectors.toList());
    }
}