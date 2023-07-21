package com.example.demo.controller;


import com.example.demo.dto.AdminDto;
import com.example.demo.dto.UsersDto;
import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.UsersService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService service;
    private final AdminService adminService;

    public UsersController(UsersService service, AdminService adminService) {
        this.service = service;
        this.adminService = adminService;
    }
    @PostMapping
    public Users saveUser(@RequestBody UsersDto usersDto) {
        System.out.println("saved");

        // Créer l'objet Users à partir des données fournies dans UsersDto
        Users user = new Users();
        user.setId(usersDto.getId());
        user.setLogin(usersDto.getLogin());
        user.setPassword(usersDto.getPassword());
        user.setRole(usersDto.getRole());
        user.setNom(usersDto.getNom());
        user.setPrenom(usersDto.getPrenom());
        user.setLocalisation(usersDto.getLocalisation());

        // Récupérer l'Admin à partir de son idAdmin
        Admin admin = adminService.findById(usersDto.getAdminDto().getIdAdmin());
        if (admin != null) {
            user.setAdmin(admin);
        } else {
                System.out.println("admin not exist");
        }

        // Enregistrer les Users en base de données
        return (Users) service.saveUser(user);
    }
    @GetMapping("/allUsers")
    public List<Users> findAllUsers(){
        return service.findAllUsers();
    }

}

