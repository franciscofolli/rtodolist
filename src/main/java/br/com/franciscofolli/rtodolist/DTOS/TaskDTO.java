package br.com.franciscofolli.rtodolist.DTOS;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskDTO {
    private UUID id;
    private String description;
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private LocalDateTime createdAt;
    private UUID userId;
}
