package tn.esprit.tic.springproj.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.User;
import tn.esprit.tic.springproj.services.UserService;

import java.util.List;

@RestController

@RequestMapping("/api/users")
public class UserController {
@Autowired
UserService userService;


@PostMapping("/add")
public User addEtudiant( @RequestBody  User user){
    return  userService.addUser(user);
}

@GetMapping("/getallUser")
public List<User> retrieveAllUser(){
    return  userService.retrieveAllUser();
}

@PutMapping("/update")
public User updateUser(@RequestBody  User user){
    return  userService.updateUser(user);

}
@DeleteMapping("/delete/{idUsers}")
void removeUser( @PathVariable("idUsers") Long idUsers){
       userService.removeUser(idUsers);
}
@GetMapping("/getbyid/{id}")
public User getUserById(@PathVariable("id") Long id){
    return userService.getUserById(id);
}

    @GetMapping("/getbyemail/{email}")
    public User getUserById(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

}
