package br.com.franciscofolli.rtodolist.Mappers;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.Entities.TaskEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {

    public TaskDTO entityToDto(TaskEntity task){
        TaskDTO response = new TaskDTO();

        response.setId(task.getId());
        response.setDescription(task.getDescription());
        response.setTitle(task.getTitle());
        response.setPriority(task.getPriority());
        response.setStartAt(task.getStartAt());
        response.setEndAt(task.getEndAt());
        response.setUserId(task.getUserId());
        response.setCreatedAt(task.getCreatedAt());

        return response;
    }

    public TaskEntity dtoToEntity(TaskDTO taskDTO){
        TaskEntity response = new TaskEntity();

        response.setId(taskDTO.getId() != null ? taskDTO.getId() : null);
        response.setDescription(taskDTO.getDescription());
        response.setTitle(taskDTO.getTitle());
        response.setPriority(taskDTO.getPriority());
        response.setStartAt(taskDTO.getStartAt());
        response.setEndAt(taskDTO.getEndAt());
        response.setUserId(taskDTO.getUserId());
        response.setCreatedAt(taskDTO.getCreatedAt());

        return response;
    }
}
