package structure.service;

import structure.domain.Profile;

import java.util.List;

public interface ProfileService {


    List<Profile> findAll();

    Profile findProfileByEmailAndPass(String emailP, String passwordP);
}
