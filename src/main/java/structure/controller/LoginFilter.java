package structure.controller;

import structure.domain.Profile;
import structure.service.ProfileService;
import structure.utils.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class LoginFilter implements Filter {
    public static final String PROFILE_COOKIE_NAME = "profileId";
    static Long MainProfileId = 0L;
    private final TemplateEngine templateEngine;
    private final ProfileService profileService;

    public LoginFilter(TemplateEngine templateEngine, ProfileService profileService) {
        this.templateEngine = templateEngine;
        this.profileService = profileService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Optional<Cookie> optionalCookie = CookieUtil.findCookieByName(request, PROFILE_COOKIE_NAME);
        if (optionalCookie.isEmpty()) {
            String email = servletRequest.getParameter("email");
            String password = servletRequest.getParameter("password");
            Profile profile = profileService.findProfileByEmailAndPass(email, password);
            if (profile != null) {
                MainProfileId = profile.getId();
                profileService.update(MainProfileId);
                response.addCookie(new Cookie(PROFILE_COOKIE_NAME, String.valueOf(profile.getId())));
                filterChain.doFilter(request, response);
            }
            templateEngine.render("login.ftl", (HttpServletResponse) servletResponse);
        } else {
            MainProfileId = Long.valueOf(optionalCookie.get().getValue());
            filterChain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
