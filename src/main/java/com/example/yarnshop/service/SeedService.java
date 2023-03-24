package com.example.yarnshop.service;

import com.example.yarnshop.model.entity.*;
import com.example.yarnshop.model.enums.AccessoryEnum;
import com.example.yarnshop.model.enums.Category;
import com.example.yarnshop.model.enums.Role;
import com.example.yarnshop.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SeedService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserRoleRepository userRoleRepository;
    private CountryRepository countryRepository;
    private YarnCategoryRepository yarnCategoryRepository;

    private AccessoryCategoryRepository accessoryCategoryRepository;
    public SeedService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, CountryRepository countryRepository, YarnCategoryRepository yarnCategoryRepository, AccessoryCategoryRepository accessoryCategoryRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.countryRepository = countryRepository;
        this.yarnCategoryRepository = yarnCategoryRepository;
        this.accessoryCategoryRepository = accessoryCategoryRepository;
    }
    @PostConstruct
    public void init(){
        seedRoles();
        seedCountries();
        seedAdmin();
        seedYarnCategories();
        seedAccessoryCategories();
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
                    setCountry(countryRepository.findById(1L).orElseThrow()).
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
    private void seedYarnCategories(){
        if(yarnCategoryRepository.count() == 0){
            var cotton = new YarnCategory().setCategory(Category.COTTON);
            var alpaca = new YarnCategory().setCategory(Category.ALPACA);
            var bamboo = new YarnCategory().setCategory(Category.BAMBOO);
            var silk = new YarnCategory().setCategory(Category.SILK);
            var cashmere = new YarnCategory().setCategory(Category.CASHMERE);
            var linen = new YarnCategory().setCategory(Category.LINEN);
            var merino = new YarnCategory().setCategory(Category.MERINO);
            var vegan = new YarnCategory().setCategory(Category.VEGAN);
            var wool = new YarnCategory().setCategory(Category.WOOL);
            var natural = new YarnCategory().setCategory(Category.NATURAL);

            yarnCategoryRepository.save(cotton);
            yarnCategoryRepository.save(alpaca);
            yarnCategoryRepository.save(bamboo);
            yarnCategoryRepository.save(silk);
            yarnCategoryRepository.save(cashmere);
            yarnCategoryRepository.save(merino);
            yarnCategoryRepository.save(vegan);
            yarnCategoryRepository.save(wool);
            yarnCategoryRepository.save(natural);
        }
    }
    private void seedAccessoryCategories(){
        if(accessoryCategoryRepository.count() == 0){
            var needle = new AccessoryCategory().setCategory(AccessoryEnum.NEEDLE);
            var amigurumiAccessory = new AccessoryCategory().setCategory(AccessoryEnum.AMIGURUMI_ACCESSORIES);
            var buttons = new AccessoryCategory().setCategory(AccessoryEnum.BUTTONS);
            var toyStuffing = new AccessoryCategory().setCategory(AccessoryEnum.TOY_STUFFING);
            var bagHandles = new AccessoryCategory().setCategory(AccessoryEnum.BAG_HANDLES);
            var woodBase = new AccessoryCategory().setCategory(AccessoryEnum.WOOD_BASE);
            var zippers = new AccessoryCategory().setCategory(AccessoryEnum.ZIPPERS);

            accessoryCategoryRepository.save(needle);
            accessoryCategoryRepository.save(amigurumiAccessory);
            accessoryCategoryRepository.save(buttons);
            accessoryCategoryRepository.save(toyStuffing);
            accessoryCategoryRepository.save(bagHandles);
            accessoryCategoryRepository.save(woodBase);
            accessoryCategoryRepository.save(zippers);
        }
    }
}
