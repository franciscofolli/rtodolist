package br.com.franciscofolli.rtodolist.Services.Impl;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import br.com.franciscofolli.rtodolist.Entities.TaskEntity;
import br.com.franciscofolli.rtodolist.Entities.UserEntity;
import br.com.franciscofolli.rtodolist.Mappers.TaskMapper;
import br.com.franciscofolli.rtodolist.Repositories.ITaskRepository;
import br.com.franciscofolli.rtodolist.Services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskRepository repository;

    @Autowired
    private TaskMapper mapper;


    @Override
    public TaskDTO create(TaskDTO dto) throws Exception {
        TaskEntity saved = this.repository.save(this.mapper.dtoToEntity(dto));
        return this.mapper.entityToDto(saved);
    }

    @Override
    public List<TaskDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public TaskDTO findOne(UUID uuid) throws Exception {
        return null;
    }

    @Override
    public void update(TaskDTO dto) throws Exception {

    }

    @Override
    public void delete(UUID uuid) throws Exception {

    }
}
