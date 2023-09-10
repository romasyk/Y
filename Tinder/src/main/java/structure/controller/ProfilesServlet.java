package structure.controller;

import structure.service.ProfileService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ProfilesServlet extends HttpServlet {
    private ProfileService profileService;
    private final TemplateEngine templateEngine;
    public ProfilesServlet(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public ProfilesServlet(ProfileService profileService, TemplateEngine templateEngine) {
        this.profileService = profileService;
        this.templateEngine = templateEngine;
    }

    int i = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Map<String, Object> params;

        if (i>= profileService.getProfiles().size()){
            i=0;
        }
        if (i < profileService.getProfiles().size()) {
            params = Map.of(
                    "name", profileService.getProfiles().get(i).getName(),
                    "photo", profileService.getProfiles().get(i).getPhoto()

            );
            templateEngine.render("like-page.html", params, resp);

        }
      i++;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Map<String, Object> params;

        if (i>= profileService.getProfiles().size()){
            i=0;
        }
        if (i < profileService.getProfiles().size()) {
            params = Map.of(
                    "name", profileService.getProfiles().get(i).getName(),
                    "photo", profileService.getProfiles().get(i).getPhoto()

            );
            templateEngine.render("like-page.html", params, resp);

        }
        i++;
    }
}

