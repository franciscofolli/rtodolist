package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ICrudService<T, ID> {

    UserDTO create(T dto);
    List<UserDTO> findAll();
    UserDTO findOne(ID id);
    void update(T dto);
    void delete(ID id);

}
