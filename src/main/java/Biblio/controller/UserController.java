package Biblio.controller;

import Biblio.models.*;
import Biblio.servicesImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    @GetMapping("/getOne/{userId}")
    public User getOne(@PathVariable Long userId){
        return userService.getUserById(userId);
    }


    //add User
    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){

        UserDto userDto1=userService.addUser(userDto);

        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){userService.deleteUser(id);}


    @GetMapping("/getByUsername/{username}")
    public User getByUsername(@PathVariable String username){
        return userService.getUsersByUsername(username);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUSer(){return userService.getAllUsers();}

}
