package br.com.franciscofolli.rtodolist.Services.Impl;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.Entities.TaskEntity;
import br.com.franciscofolli.rtodolist.Mappers.TaskMapper;
import br.com.franciscofolli.rtodolist.Repositories.ITaskRepository;
import br.com.franciscofolli.rtodolist.Services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    public List<TaskDTO> findAll(UUID userId) throws Exception {
        return this.mapper.entityToDto(this.repository.findAllByUserId(userId));
    }

    @Override
    public TaskDTO findOne(UUID uuid) throws Exception {
        return null;
    }

    @Override
    public void update(TaskDTO dto) throws Exception {
        Optional<TaskEntity> actualTaskData = this.repository.findById(dto.getId());
        if(actualTaskData.isEmpty()){
            throw new Exception("Erro - Tarefa não encontrada!");
        }
        this.repository.save(this.mapper.dtoToEntity(dto, actualTaskData.get()));
    }

    @Override
    public void delete(UUID uuid) throws Exception {

    }

}
