package br.com.franciscofolli.rtodolist.Services;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import java.util.List;

public interface ICrudService<T, ID> {

    T create(T dto) throws Exception;
    List<T> findAll() throws Exception;
    T findOne(ID id) throws Exception;
    void update(T dto) throws Exception;
    void delete(ID id) throws Exception;

}
