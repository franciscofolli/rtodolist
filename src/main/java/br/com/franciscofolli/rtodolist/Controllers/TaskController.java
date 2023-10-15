package br.com.franciscofolli.rtodolist.Controllers;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.Services.ITaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService service;

    @PostMapping("/")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO, HttpServletRequest request){
        try {
            taskDTO.setUserId((UUID) request.getAttribute("userId"));
            return ResponseEntity.ok(this.service.create(taskDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskDTO>> findAll(HttpServletRequest request){
        try {
            return ResponseEntity.ok(this.service.findAll((UUID) request.getAttribute("userId")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskDTO taskDTO, HttpServletRequest request, @PathVariable UUID id){
        try {
            taskDTO.setId(id);
            this.service.update(taskDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
