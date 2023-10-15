package br.com.franciscofolli.rtodolist.Mappers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import br.com.franciscofolli.rtodolist.Entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDTO entityToDto(UserEntity user){
        UserDTO response = new UserDTO();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }

    public UserEntity dtoToEntity(UserDTO userDTO){
        UserEntity response = new UserEntity();
        response.setId(userDTO.getId() != null ? userDTO.getId() : null);
        response.setName(userDTO.getName());
        response.setUsername(userDTO.getUsername());
        response.setPassword(BCrypt.withDefaults()
                .hashToString(12, userDTO.getPassword().toCharArray()));
        response.setCreatedAt(userDTO.getCreatedAt());

        return response;
    }
}
