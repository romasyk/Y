package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JDBCProfileDao implements ProfileDao {

    @Override
    public void save(String name, String email,  String password, String photo, String info) {
        try (Connection connection = getConnection()) {

            String insertQuery = "INSERT INTO public.user (name, login, password, photo, info, lastlogining) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, photo);
            statement.setString(5, info);
            statement.setString(6, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<String> findAllEmails() {
        List <String> emails = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT login FROM public.user ");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                emails.add( email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }


    @Override
    public List<Profile> findAll() {
        List <Profile> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.user ");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String photo = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String info = rs.getString(6);
                String lastlogining = rs.getString(7);
                users.add( new Profile(name,id,email,password,photo,info,lastlogining));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Profile findProfileByEmailAndPass(String emailP, String passwordP) {
        try (Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.user WHERE  login=? AND password=?");
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
    public void update(Long  id) {
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.user SET lastlogining=? WHERE id=?");
            statement.setString(1, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
            statement.setLong(2, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}
    }
    @Override
    public Profile findById(Long userId) {

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.user WHERE id=?");
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String photo = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String info = rs.getString(6);
                String lastlogining = rs.getString(7);


                return new Profile(name,id,email,password,photo,info,lastlogining);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}