package br.com.franciscofolli.rtodolist.DTOS;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDTO {

    private UUID id;
    private String username;
    private String password;
    private String name;
    private LocalDateTime createdAt;
}
