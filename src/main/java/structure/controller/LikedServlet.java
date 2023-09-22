package structure.controller;

import structure.domain.Profile;
import structure.service.LikeService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static structure.controller.LoginFilter.MainProfileId;

public class LikedServlet extends HttpServlet {
    private final LikeService likeService;
    private final TemplateEngine templateEngine;
List<Profile> likedProfiles;
    public LikedServlet(LikeService likeService, TemplateEngine templateEngine) {
        this.likeService = likeService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = Map.of();
        templateEngine.render("people-list.ftl", params, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        likedProfiles = likeService.findLiked(MainProfileId);

        Map<String, Object> params = Map.of(
                "liked", likedProfiles
        );
        templateEngine.render("people-list.ftl",params, response);
    }
}
