package structure.controller;

import structure.domain.Message;
import structure.domain.Profile;
import structure.service.ChatService;
import structure.service.ProfileService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static structure.controller.LoginFilter.MainProfileId;

public class ChatServlet extends HttpServlet {
    private final ProfileService profileService;
    private final ChatService chatService;
    private final TemplateEngine templateEngine;
    static Long likedId =0L;
    String defaultMessage ="";

    public ChatServlet(ProfileService profileService, ChatService chatService, TemplateEngine templateEngine) {
        this.profileService = profileService;
        this.chatService = chatService;
        this.templateEngine = templateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        likedId = Long.valueOf(req.getParameter("id"));
        Profile mainUser = profileService.findById(MainProfileId);
        Profile currantUser = profileService.findById(likedId);
        List<Message> currantMessages = chatService.findMessageById(MainProfileId,likedId);
        if (currantMessages.size()==0){defaultMessage = "THERE IS NO MESSAGES THERE. TRY TO WRITE FIRST))))!";
        }else{defaultMessage = "";}

        Map<String, Object> params = Map.of(
                "data", List.of(MainProfileId, likedId),
                "messages", currantMessages,
                "names", List.of(mainUser.getName(), mainUser.getPhoto(),
                        currantUser.getName(), currantUser.getPhoto()),
                "default", List.of(defaultMessage));
        templateEngine.render("chat.ftl",params, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String text = req.getParameter("message");
        chatService.addMessage(MainProfileId,likedId,text);
        resp.sendRedirect("/message?id=" + likedId);
    }

}
