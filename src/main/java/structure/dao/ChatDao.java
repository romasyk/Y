package structure.dao;

import structure.domain.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface ChatDao {
    default Connection getConnection()throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://cornelius.db.elephantsql.com:5432/rxrpffrt", "rxrpffrt", "Nkna4UM4gZJ0OYYS9Ap2ya_wyNsgHqsc");
    }

    List<Message> findAll();

    void addMessage(Long senderId, Long receiverId, String text);

    List<Message> findMessageById(Long senderid, Long receiverid);
}
