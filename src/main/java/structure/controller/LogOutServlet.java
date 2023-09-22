package structure.controller;


import structure.service.LikeService;
import structure.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static structure.controller.LoginFilter.MainProfileId;
import static structure.controller.LoginFilter.PROFILE_COOKIE_NAME;
import static structure.controller.ProfilesServlet.count;

public class LogOutServlet extends HttpServlet {
    private final LikeService likeService;
    private TemplateEngine templateEngine;

    public LogOutServlet(LikeService likeService, TemplateEngine templateEngine) {
        this.likeService = likeService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count = 0;
        CookieUtil.findCookieByName(request, PROFILE_COOKIE_NAME)
                .ifPresent(c -> {
                    c.setMaxAge(0);
                    c.setPath("/");
                    response.addCookie(c);
                });
        likeService.deleteAllLikes(MainProfileId);
        templateEngine.render("login.ftl", response);
    }
}