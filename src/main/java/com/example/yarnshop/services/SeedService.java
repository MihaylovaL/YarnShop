package com.example.yarnshop.services;

import com.example.yarnshop.models.entities.Country;
import com.example.yarnshop.models.entities.UserRole;
import com.example.yarnshop.models.entities.YarnShopUser;
import com.example.yarnshop.models.enums.Role;
import com.example.yarnshop.repositories.CountryRepository;
import com.example.yarnshop.repositories.UserRepository;
import com.example.yarnshop.repositories.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SeedService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserRoleRepository userRoleRepository;
    private CountryRepository countryRepository;

    public SeedService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.countryRepository = countryRepository;
    }
    @PostConstruct
    public void init(){
        seedRoles();
        seedCountries();
        seedAdmin();
    }

    private void seedRoles() {
        if (userRoleRepository.count() == 0) {
            var userRole = new UserRole().setRole(Role.USER);

            var adminRole = new UserRole().setRole(Role.ADMIN);

           userRoleRepository.save(userRole);
           userRoleRepository.save(adminRole);
        }
    }
    private void seedAdmin() {
        if (userRepository.count() == 0) {

            var adminUser = new YarnShopUser().
                    setUsername("admin").
                    setEmail("admin@example.com").
                    setFirstName("Lora").
                    setLastName("Mihaylova").
                    setPassword(passwordEncoder.encode("admin123")).
                    setCountry(countryRepository.findByName("Bulgaria").orElseThrow()).
                    setRoles(userRoleRepository.findAll());

            userRepository.save(adminUser);
        }
    }

    private void seedCountries() {
        if (countryRepository.count() == 0) {
            var bulgaria = new Country().setName("Bulgaria");
            var romania = new Country().setName("Romania");
            var turkey = new Country().setName("Turkey");
            var serbia = new Country().setName("Serbia");
            var macedonia = new Country().setName("Macedonia");

            countryRepository.save(bulgaria);
            countryRepository.save(romania);
            countryRepository.save(turkey);
            countryRepository.save(serbia);
            countryRepository.save(macedonia);
        }
    }
}
