package structure.service;

import structure.domain.Message;

import java.util.List;

public interface ChatService {
    List<Message> findMessageById(Long senderId, Long receiverId);

    void addMessage(Long senderId, Long receiverId, String text);

    List<Message> findAll();
}
