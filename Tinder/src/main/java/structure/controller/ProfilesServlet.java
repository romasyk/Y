package structure.controller;

import structure.service.LikeService;
import structure.service.ProfileService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static structure.controller.LoginFilter.MainProfileId;

public class ProfilesServlet extends HttpServlet {
    public static int count =0;
    private final ProfileService profileService;
    private final LikeService likeService;
    private final TemplateEngine templateEngine;
    public ProfilesServlet(ProfileService profileService, LikeService likeService, TemplateEngine templateEngine) {
        this.profileService = profileService;
        this.likeService = likeService;
        this.templateEngine = templateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> params;
        if (count>= profileService.findAll().size()){
            count = 0;
            resp.sendRedirect("/liked");
            return;
        }


        if (profileService.findAll().get(count).getId() == MainProfileId){count++;}

        if ( !(count>= profileService.findAll().size())) {
            if (req.getParameter("liked")!=null && req.getParameter("liked").equals("YES")) {
                likeService.addLike(MainProfileId, profileService.findAll().get(count).getId());
            }
        }
        if (count>= profileService.findAll().size()){
            resp.sendRedirect("/liked");
        }
        if (count < profileService.findAll().size()) {
            params = Map.of(
                    "name", profileService.findAll().get(count).getName(),
                    "photo", profileService.findAll().get(count).getPhoto()

            );
            templateEngine.render("like-page.ftl", params, resp);
            count++;
        }
    }
}

