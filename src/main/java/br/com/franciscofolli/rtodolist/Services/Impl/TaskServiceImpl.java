package br.com.franciscofolli.rtodolist.Services.Impl;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import br.com.franciscofolli.rtodolist.Entities.TaskEntity;
import br.com.franciscofolli.rtodolist.Entities.UserEntity;
import br.com.franciscofolli.rtodolist.Mappers.TaskMapper;
import br.com.franciscofolli.rtodolist.Repositories.ITaskRepository;
import br.com.franciscofolli.rtodolist.Services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        // Date isAfter validate
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(dto.getStartAt()) || now.isAfter(dto.getEndAt())) {
            throw new Exception("Erro - Data de inicio/final é menor que a data atual!!");
        }
        if (dto.getStartAt().isAfter(dto.getEndAt())) {
            throw new Exception("Erro - Data final é menor que a data incial!!");
        }
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
