package com.example.demo.controller;


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
    private AdminService adminService;

    public UsersController(UsersService service, AdminService adminService) {
        this.service = service;
        this.adminService = adminService;
    }
    public Users saveUser(@Valid @RequestBody Users users) {
        System.out.println("saved");

        // Créer l'objet Users à partir des données fournies dans UsersDto
        Users user = new Users();
        user.setAddress(users.getAddress());
        user.setEmail(users.getEmail());
        user.setLocalisation(users.getLocalisation());
        user.setLogin(users.getLogin());
        user.setNom(users.getNom());
        user.setNumTel(users.getNumTel());
        user.setPassword(users.getPassword());
        user.setPrenom(users.getPrenom());
        user.setRole(users.getRole());

        // Récupérer l'Admin à partir de son idAdmin
        Admin admin = adminService.findById(users.getAdmin().getIdAdmin());
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

