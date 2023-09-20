package structure.service;

import structure.dao.ProfileDao;
import structure.domain.Profile;

import java.util.List;

public class DefaultProfileService implements ProfileService{
    private final ProfileDao profileDao;


    @Override
    public List<Profile> findAll() {
        return profileDao.findAll();
    }

    @Override
    public Profile findProfileByEmailAndPass(String emailP, String passwordP){
        return  profileDao.findProfileByEmailAndPass(emailP,passwordP);
    }

    public DefaultProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

}
