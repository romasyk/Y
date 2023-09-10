package structure.service;

import structure.dao.ProfileDao;
import structure.domain.Profile;

import java.util.List;

public class DefaultProfileService implements ProfileService{
    private final ProfileDao profileDao;

    @Override
    public List<Profile> getProfiles(){
        return profileDao.getProfiles();
    }

    @Override
    public void addProfile(Profile profile){
        profileDao.addProfile(profile);
    }

    public DefaultProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }
}
