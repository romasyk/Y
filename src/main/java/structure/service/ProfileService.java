package structure.service;

import structure.domain.Profile;

import java.util.List;

public interface ProfileService {


    void update(Long id);

    Profile findById(Long userId);

    List<Profile> findAll();

    Profile findProfileByEmailAndPass(String emailP, String passwordP);
}
