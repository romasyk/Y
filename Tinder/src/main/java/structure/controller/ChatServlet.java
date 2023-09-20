package structure.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ChatServlet extends HttpServlet {
    private final TemplateEngine templateEngine;

    public ChatServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = Map.of();
        templateEngine.render("chat.ftl", params, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        templateEngine.render("chat.ftl", response);
    }
}
