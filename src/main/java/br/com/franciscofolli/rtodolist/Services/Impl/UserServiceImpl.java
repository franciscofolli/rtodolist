package br.com.franciscofolli.rtodolist.Services.Impl;

import br.com.franciscofolli.rtodolist.DTOS.UserDTO;
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

    @Override
    public UserDTO create(UserDTO dto) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO findOne(UUID uuid) {
        return null;
    }

    @Override
    public void update(UserDTO dto) {
    }

    @Override
    public void delete(UUID uuid) {
    }
}
