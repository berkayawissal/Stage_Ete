package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping
    public Admin saveAdmin(@Valid @RequestBody Admin admin) {
        LOGGER.info("saved");
        return (Admin) service.saveAdmin(admin);
    }
    @GetMapping("/AllAdmins")
    public List <Admin> findAllAdmins (){
        return service.findAllAdmins();
    }

//    @PutMapping("update/{id}")
//    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
//        admin.setLogin(admin.getLogin());
//        admin.setRole(admin.getRole());
//        admin.setPassword(admin.getRole());
//        return (Admin) service.updateAdminbyId(id, admin);
//    }
}


