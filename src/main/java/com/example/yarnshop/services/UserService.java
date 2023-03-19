package com.example.yarnshop.services;

import com.example.yarnshop.models.dtos.UserRegisterDto;
import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.models.entities.YarnShopUser;
import com.example.yarnshop.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private CountryService countryService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, CountryService countryRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.countryService = countryRepository;
    }


    public void registerUser(UserRegisterDto userRegisterDto) {


        YarnShopUser user = new YarnShopUser().
                setUsername(userRegisterDto.getUsername()).
                setFirstName(userRegisterDto.getFirstName()).
                setLastName(userRegisterDto.getLastName()).
                setEmail(userRegisterDto.getEmail()).
                setPassword(passwordEncoder.encode(userRegisterDto.getPassword())).
                setCountry(countryService.findByName(userRegisterDto.getCountryId()));

        userRepository.save(user);

    }
}
