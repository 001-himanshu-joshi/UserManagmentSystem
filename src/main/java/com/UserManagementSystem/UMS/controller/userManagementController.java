package com.UserManagementSystem.UMS.controller;

import com.UserManagementSystem.UMS.model.userManagementModel;
import com.UserManagementSystem.UMS.service.userManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api_UserManagement_System")
public class userManagementController {

    private final userManagementService usermanagementService;

    public userManagementController(userManagementService usermanagementService) {
        this.usermanagementService = usermanagementService;
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestBody userManagementModel usermanagementmodel){
        return usermanagementService.addToDatabase(usermanagementmodel);
    }

    @GetMapping("/getAllUser")
    public List<userManagementModel> getAll(){
        return usermanagementService.getAllUser();
    }

    @GetMapping("/getUser/{userId}")
    public List<userManagementModel> getUserById(@PathVariable Integer userId){
        return usermanagementService.getUserByUserId(userId);
    }

    @PutMapping("/updateUserInfo/{userId}")
    public String updateUser(@PathVariable Integer userId, @RequestBody userManagementModel usermanagementmodel){
        return usermanagementService.updatingUser(userId, usermanagementmodel);

    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Integer userId){
       return userManagementService.deleteUserById(userId);
    }
}