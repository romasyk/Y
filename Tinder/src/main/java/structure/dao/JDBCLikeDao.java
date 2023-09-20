package structure.dao;

import structure.domain.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCLikeDao implements LikeDao{
    @Override
    public void addLike(long userId, long likedId) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO public.likes (user_id,liked_id) VALUES(?,?)");

            statement.setLong(1, userId);
            statement.setLong(2, likedId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}

    }


    @Override
    public void deleteAllLikes(long userId) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.likes WHERE user_id=?");
            statement.setLong(1,userId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}
    }


    @Override
    public List<Profile> findLiked(long userId){
        List <Profile> users = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT u.* FROM users u INNER JOIN likes l ON u.id = l.liked_id WHERE l.user_id = ?;");
            statement.setLong(1,userId);

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
}
