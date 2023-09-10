package structure.dao;

import structure.domain.Profile;

import java.util.ArrayList;
import java.util.List;

public class ListProfileDao implements ProfileDao {
   private List<Profile> profiles = new ArrayList<>(List.of(
            new Profile("LLLLL","https://static.dw.com/image/64142948_804.jpg"),
            new Profile("AAAAAA","https://www.aljazeera.com/wp-content/uploads/2022/12/SSS10794_1-1.jpg?resize=770%2C513&quality=80"),
            new Profile("VVVVVVV","https://www.aljazeera.com/wp-content/uploads/2022/12/SSS10784_1.jpg?resize=1800%2C1800"),
            new Profile("DDDDDD","https://pbs.twimg.com/media/FkSPPvYUAAAIFsr.jpg:large")
    ));

   @Override
   public List<Profile> getProfiles(){
        return this.profiles;
    }
    @Override
    public void addProfile(Profile profile){
        this.profiles.add(profile);
    }
}
