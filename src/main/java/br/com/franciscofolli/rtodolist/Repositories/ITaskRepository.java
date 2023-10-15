package br.com.franciscofolli.rtodolist.Repositories;

import br.com.franciscofolli.rtodolist.Entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findAllByUserId(UUID userId);
}
