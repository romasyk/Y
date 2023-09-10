package structure.dao;

import structure.domain.Profile;

import java.util.List;

public interface ProfileDao {

    List<Profile> getProfiles();

    void addProfile(Profile profile);
}
