package br.com.franciscofolli.rtodolist.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String username;

    private String name;

    private String passoword;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
