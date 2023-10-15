package br.com.franciscofolli.rtodolist.Controllers;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.Services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService service;

    @PostMapping("/")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO){
        try {
            return ResponseEntity.ok(this.service.create(taskDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
