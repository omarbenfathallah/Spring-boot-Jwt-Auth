package tn.esprit.tic.springproj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.springproj.Dto.SignupRequest;
import tn.esprit.tic.springproj.Models.User;
import tn.esprit.tic.springproj.services.AuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {


    @Autowired
    private final AuthService authService;

    public SignupController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {
        User createdCustomer = authService.createUser(signupRequest);
        if (createdCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create User");
        }
    }
}
