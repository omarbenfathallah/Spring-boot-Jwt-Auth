package tn.esprit.tic.springproj.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.tic.springproj.Dto.SignupRequest;
import tn.esprit.tic.springproj.Models.User;
import tn.esprit.tic.springproj.Repository.UserRepository;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;




    @Override
    public User createUser(SignupRequest signupRequest) {

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);


        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User student = userRepository.save(user);
        user.setId(student.getId());
        return user;
    }
}
