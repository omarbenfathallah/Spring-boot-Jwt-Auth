package tn.esprit.tic.springproj.Dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.tic.springproj.Models.Role;
@Getter
@Setter
public class SignupRequest {
    private String email;

    private String nom;
    private String prenom;

    private String password;

    private Role role;


}
