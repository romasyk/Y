package structure.service;

import java.util.List;

public interface SignUpService {
     void saveProfile(String name, String email, String password, String photo, String info);
     List<String> getAllEmails();
}
