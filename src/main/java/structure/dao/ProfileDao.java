package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface ProfileDao {


    public void save(String name, String email,  String password, String photo, String info);

    default Connection getConnection()throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://cornelius.db.elephantsql.com:5432/rxrpffrt", "rxrpffrt", "Nkna4UM4gZJ0OYYS9Ap2ya_wyNsgHqsc");
    }

    List<String> findAllEmails();

    List<Profile> findAll();

    Profile findProfileByEmailAndPass(String emailP, String passwordP);

    void update(Long id);

    Profile findById(Long userId);
}
