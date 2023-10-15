package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;

import java.util.List;
import java.util.UUID;

public interface ITaskService extends ICrudService<TaskDTO, UUID> {
    List<TaskDTO> findAll(UUID userId) throws Exception;
}
