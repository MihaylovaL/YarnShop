package com.example.yarnshop.services;

import com.example.yarnshop.models.dtos.UserRegisterDto;
import com.example.yarnshop.models.entities.User;
import com.example.yarnshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void registerUser(UserRegisterDto userRegisterDto) {
        userRepository.saveAndFlush(modelMapper.map(userRegisterDto, User.class));
    }
}
