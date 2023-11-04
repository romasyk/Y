package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface ProfileDao {




    default Connection getConnection()throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://cornelius.db.elephantsql.com:5432/rxrpffrt", "rxrpffrt", "Nkna4UM4gZJ0OYYS9Ap2ya_wyNsgHqsc");
    }

    List<Profile> findAll();

    Profile findProfileByEmailAndPass(String emailP, String passwordP);

    void update(Long id);

    Profile findById(Long userId);
}
