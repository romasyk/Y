package structure.service;

import structure.dao.ProfileDao;

import java.util.List;

public class DefaultSignUpService implements SignUpService{
    private ProfileDao profileDao;

    public DefaultSignUpService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public void saveProfile(String name, String email, String password, String photo, String info) {

        profileDao.save(name, email, password, photo, info);
    }

    public List<String> getAllEmails() {
        return profileDao.findAllEmails();
    }
}
