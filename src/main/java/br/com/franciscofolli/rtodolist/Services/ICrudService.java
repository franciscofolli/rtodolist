package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.TaskDTO;
import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import java.util.List;
import java.util.UUID;

public interface ICrudService<T, ID> {

    T create(T dto) throws Exception;
    default List<T> findAll() throws Exception {
        throw new Exception("Not implemented");
    };
    T findOne(ID id) throws Exception;
    void update(T dto) throws Exception;
    void delete(ID id) throws Exception;

}
