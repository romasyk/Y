package structure.service;

import structure.dao.ChatDao;
import structure.domain.Message;

import java.util.List;

public class DefaultChatService implements ChatService{
   private final ChatDao chatDao;

    public DefaultChatService(ChatDao chatDao) {
        this.chatDao = chatDao;
    }
    @Override
    public List<Message> findMessageById(Long senderId, Long receiverId) {
        return  chatDao.findMessageById(senderId,receiverId);
    }
    @Override
    public void addMessage(Long senderId, Long receiverId, String text) {
        chatDao.addMessage(senderId,receiverId,text);
    }
    @Override
    public List<Message> findAll(){
        return chatDao.findAll();
    }
}
