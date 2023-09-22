package structure.controller;

import structure.utils.CookieUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static structure.controller.LoginFilter.PROFILE_COOKIE_NAME;

public class LoginServlet extends HttpServlet {
    private final TemplateEngine templateEngine;

    public LoginServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(CookieUtil.findCookieByName(request, PROFILE_COOKIE_NAME).isPresent() && request.getServletPath().equals("/")){
            response.sendRedirect("/users");
        }
        templateEngine.render("login.ftl", response);
    }
}
