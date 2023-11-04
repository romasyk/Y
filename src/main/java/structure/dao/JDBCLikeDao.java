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
                    "INSERT INTO public.like (user_id,like_id) VALUES(?,?)");

            statement.setLong(1, userId);
            statement.setLong(2, likedId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}

    }


    @Override
    public void deleteAllLikes(long userId) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.like WHERE user_id=?");
            statement.setLong(1,userId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}
    }


    @Override
    public List<Profile> findLiked(long userId){
        List <Profile> users = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT u.* FROM public.user u INNER JOIN public.like l ON u.id = l.like_id WHERE l.user_id = ?;");
            statement.setLong(1,userId);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String photo = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String info = rs.getString(6);
                String lastlogining = rs.getString(7);

                users.add(new Profile(name,id,email,password,photo,info,lastlogining));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
