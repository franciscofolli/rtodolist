package br.com.franciscofolli.rtodolist.Services.Impl;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
import br.com.franciscofolli.rtodolist.Entities.UserEntity;
import br.com.franciscofolli.rtodolist.Mappers.UserMapper;
import br.com.franciscofolli.rtodolist.Services.IUserService;
import br.com.franciscofolli.rtodolist.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO create(UserDTO dto) throws Exception {
        // validação de existencia do usuário
        UserEntity user = this.mapper.dtoToEntity(dto);
        UserEntity existsUser = this.repository.findByUsername(user.getUsername());
        if(existsUser != null){
            throw new Exception("Erro - Usuário já existe");
        }
        UserEntity saved = this.repository.save(user);
        return this.mapper.entityToDto(saved);
    }

    @Override
    public List<UserDTO> findAll() throws Exception {
        return null;
    }

    @Override
    public UserDTO findOne(UUID uuid) throws Exception {
        return null;
    }

    @Override
    public void update(UserDTO dto) throws Exception {
    }

    @Override
    public void delete(UUID uuid) throws Exception {
    }
}
