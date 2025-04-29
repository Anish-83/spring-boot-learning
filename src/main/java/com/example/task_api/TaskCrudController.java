package com.example.task_api;



import com.example.model.Task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskCrudController {
    private List<Task> tasks = new ArrayList<>();

    @GetMapping("/crud/tasks")
    public List<Task> getAllTasks() {
        return tasks;
    }
    @PostMapping("/crud/tasks")
    public Task createTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }
//    @GetMapping("/crud/tasks/{id}")
//    public Task getTaskById(@PathVariable int id) {
//        return tasks.stream()
//            .filter(t -> t.getId() == id)
//            .findFirst()
//            .orElse(null); // TODO: Handle not found
//    }
    
//@PutMapping("/crud/tasks/{id}")
//    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
//        for (int i = 0; i < tasks.size(); i++) {
//            if (tasks.get(i).getId() == id) {
//                tasks.set(i, updatedTask);
//                return updatedTask;
//            }
//        }
//        return null; // TODO: Handle not found
//    }

    @DeleteMapping("/crud/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
    	tasks.removeIf(t -> t.getId() == id);
    }
    
    @GetMapping("/crud/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        Task task = tasks.stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @PutMapping("/crud/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, updatedTask);
                return ResponseEntity.ok(updatedTask);
            }
        }
        return ResponseEntity.notFound().build();
    }
   
    // Retrieves all tasks
    
    
}