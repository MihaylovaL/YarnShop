package com.example.services;

import com.example.yarnshop.model.dtos.UserRegisterDto;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.UserRepository;
import com.example.yarnshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserDetailsService userDetailsService;

    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, passwordEncoder, userDetailsService);
    }

    @Test
    public void testRegisterUser() {
        // arrange
        UserRegisterDto registrationDTO = new UserRegisterDto();
        registrationDTO.setUsername("johndoe");
        registrationDTO.setFirstName("John");
        registrationDTO.setLastName("Doe");
        registrationDTO.setEmail("johndoe@example.com");
        registrationDTO.setPassword("password");

        YarnShopUser userEntity = new YarnShopUser()
                .setUsername(registrationDTO.getUsername())
                .setFirstName(registrationDTO.getFirstName())
                .setLastName(registrationDTO.getLastName())
                .setEmail(registrationDTO.getEmail())
                .setPassword("encryptedPassword");

        when(passwordEncoder.encode(registrationDTO.getPassword())).thenReturn("encryptedPassword");
        when(userRepository.save(any(YarnShopUser.class))).thenReturn(userEntity);
        when(userDetailsService.loadUserByUsername(registrationDTO.getEmail())).thenReturn(mock(UserDetails.class));

        // act
        userService.registerUser(registrationDTO, authentication -> {});

        // assert
        verify(passwordEncoder, times(1)).encode(registrationDTO.getPassword());
        verify(userRepository, times(1)).save(any(YarnShopUser.class));
        verify(userDetailsService, times(1)).loadUserByUsername(registrationDTO.getEmail());
    }

    @Test
    public void testFindByUsername() {
        // arrange
        String username = "johndoe";
        YarnShopUser expectedUser = new YarnShopUser()
                .setId(1L)
                .setUsername(username);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(expectedUser));

        // act
        YarnShopUser actualUser = userService.findByUsername(username);

        // assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testFindById() {
        // arrange
        Long id = 1L;
        YarnShopUser expectedUser = new YarnShopUser().setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(expectedUser));

        // act
        YarnShopUser actualUser = userService.findById(id);

        // assert
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetAllUsers() {
        // arrange
        YarnShopUser user1 = new YarnShopUser().setId(1L);
        YarnShopUser user2 = new YarnShopUser().setId(2L);

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        // act
        List<YarnShopUser> actualUsers = userService.getAllUsers();

        // assert
        assertEquals(List.of(user1, user2), actualUsers);
    }

}
