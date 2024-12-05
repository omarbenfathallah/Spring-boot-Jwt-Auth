package tn.esprit.tic.springproj.Controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Dto.LoginRequest;
import tn.esprit.tic.springproj.Repository.UserRepository;
import tn.esprit.tic.springproj.Utils.JwtUtil;
import tn.esprit.tic.springproj.services.jwt.UserServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

@RequestMapping("/login")
public class LoginController {

@Autowired
    private final AuthenticationManager authenticationManager;

  private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public LoginController(AuthenticationManager authenticationManager, UserServiceImpl userService, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")

String sauhello(){
    return  "hello oussima cv gribech tkamel";
}



    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect email or password.");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "user is not activated");
            return null;
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(), userRepository.getRolFromUser(userDetails.getUsername()).getRole());

        return jwt;
    }
}
