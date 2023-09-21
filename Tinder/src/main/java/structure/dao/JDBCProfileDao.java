package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCProfileDao implements ProfileDao {






    @Override
    public List<Profile> findAll() {
        List <Profile> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users ");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String photo = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                users.add( new Profile(name,photo ,email,password, id));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Profile findProfileByEmailAndPass(String emailP, String passwordP) {
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users WHERE  email=? AND password=?");
            statement.setString(1, emailP);
            statement.setString(2, passwordP);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong(1);
                String login = rs.getString(4);
                String password = rs.getString(5);

                return new Profile(id, login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Profile findById(Long userId) {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.users WHERE id=?");
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String photo = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);


                return new Profile(   name, photo, email,  password,id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}