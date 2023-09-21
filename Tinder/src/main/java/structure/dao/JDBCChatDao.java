package structure.dao;

import structure.domain.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCChatDao implements ChatDao{

    @Override
    public List<Message> findAll(){

        List <Message> messages = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.messages ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long sender = rs.getLong(2);
                Long receiver = rs.getLong(3);
                String content = rs.getString(4);
                messages.add( new Message( sender, receiver,content ));}
        } catch (SQLException e) {
            e.printStackTrace();}
        return messages;
    }

    @Override
    public void addMessage(Long senderId, Long receiverId, String text) {
        System.out.println("dao try to add message ");
        try (Connection connection = getConnection()) {
            System.out.println("connection for adding");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.messages (sender_id,receiver_id, content) VALUES(?,?,?)");
            statement.setLong(1, senderId);
            statement.setLong(2, receiverId);
            statement.setString(3, text);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();}
    }

    @Override
    public List<Message> findMessageById(Long senderId, Long receiverId) {
        List <Message> messages = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.messages WHERE (sender=? AND receiver=?) OR ( sender=? AND receiver=?)");
            statement.setLong(1, senderId);
            statement.setLong(2, receiverId);
            statement.setLong(3, receiverId);
            statement.setLong(4, senderId);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long sender = rs.getLong(2);
                Long receiver = rs.getLong(3);
                String text = rs.getString(4);

                messages.add( new Message( sender, receiver, text));}
        } catch (SQLException e) {
            e.printStackTrace();}
        return messages;

    }
}
