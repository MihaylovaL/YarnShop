package com.example.yarnshop.service;

import com.example.yarnshop.model.dtos.UserRegisterDto;
import com.example.yarnshop.model.entity.Yarn;
import com.example.yarnshop.model.entity.YarnShopUser;
import com.example.yarnshop.repository.UserRepository;
import com.example.yarnshop.repository.YarnRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, CountryService countryRepository, YarnRepository yarnRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }


    public void registerUser(UserRegisterDto registrationDTO,
                             Consumer<Authentication> successfulLoginProcessor) {

        YarnShopUser userEntity = new YarnShopUser().
                setUsername(registrationDTO.getUsername()).
                setFirstName(registrationDTO.getFirstName()).
                setLastName(registrationDTO.getLastName()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        userRepository.save(userEntity);

        UserDetails userDetails = userDetailsService.loadUserByUsername(registrationDTO.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        successfulLoginProcessor.accept(authentication);
    }

    public List<YarnShopUser> getAllUsers(){
        return userRepository.findAll();
    }

}
