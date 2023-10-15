package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import java.util.List;

public interface ICrudService<T, ID> {

    UserDTO create(T dto) throws Exception;
    List<UserDTO> findAll() throws Exception;
    UserDTO findOne(ID id) throws Exception;
    void update(T dto) throws Exception;
    void delete(ID id) throws Exception;

}
