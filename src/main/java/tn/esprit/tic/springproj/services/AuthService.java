package tn.esprit.tic.springproj.services;

import tn.esprit.tic.springproj.Dto.SignupRequest;
import tn.esprit.tic.springproj.Models.User;

public interface AuthService {

    User createUser(SignupRequest signupRequest);
}
