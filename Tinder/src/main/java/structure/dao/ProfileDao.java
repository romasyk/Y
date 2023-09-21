package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface ProfileDao {




    default Connection getConnection()throws SQLException {
         return DriverManager.getConnection("jdbc:postgresql://cornelius.db.elephantsql.com:5432/yxrukzxz", "yxrukzxz", "URBeCzTZG4De1BjDww0KRThi-NMi8cqT");
    }

    List<Profile> findAll();

    Profile findProfileByEmailAndPass(String emailP, String passwordP);

    Profile findById(Long userId);
}
