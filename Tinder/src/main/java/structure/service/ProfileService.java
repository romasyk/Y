package structure.service;

import structure.domain.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getProfiles();

    void addProfile(Profile profile);
}
