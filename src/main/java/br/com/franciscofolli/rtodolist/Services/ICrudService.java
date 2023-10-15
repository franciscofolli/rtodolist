package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import java.util.List;

public interface ICrudService<T, ID> {

    UserDTO create(T dto);
    List<UserDTO> findAll();
    UserDTO findOne(ID id);
    void update(T dto);
    void delete(ID id);

}
