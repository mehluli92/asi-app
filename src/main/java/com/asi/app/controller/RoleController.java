package com.asi.app.controller;

import com.asi.app.entity.Role;
import com.asi.app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/addRole")
    public Role addRole(@RequestBody Role role){
    return roleService.saveRole(role);
    }

    @GetMapping("/roles")
    public List<Role> findAllRoles(){
        return  roleService.getRoles();
    }

    @GetMapping("/roleById/{id}")
    public Role findRoleById(@PathVariable int id){
        return roleService.getRoleById(id);
    }

    @GetMapping("/roleByName/{name}")
    public Role findRoleByName(@PathVariable String name){
        return roleService.getRoleByName(name);
    }

    @PutMapping("/updateRole")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable int id){
        return roleService.deleteRole(id);
    }
}
