import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import structure.controller.*;
import structure.dao.JDBCLikeDao;
import structure.dao.JDBCProfileDao;
import structure.dao.LikeDao;
import structure.dao.ProfileDao;
import structure.service.DefaultProfileService;
import structure.service.LikeProfileService;
import structure.service.LikeService;
import structure.service.ProfileService;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8081);

        TemplateEngine templateEngine = new TemplateEngine();
        ProfileDao profileDao = new JDBCProfileDao();
        ProfileService profileService = new DefaultProfileService(profileDao);

        LikeDao likeDao = new JDBCLikeDao();
        LikeService likeService = new LikeProfileService(likeDao);


        ServletContextHandler handler = new ServletContextHandler();
        ProfilesServlet profilesServlet = new ProfilesServlet(profileService, likeService, templateEngine);
        LikedServlet likedServlet = new LikedServlet(likeService, templateEngine);
        ChatServlet chatServlet = new ChatServlet(templateEngine);
        LoginServlet loginServlet = new LoginServlet(templateEngine);
        LogOutServlet logOutServlet = new LogOutServlet(likeService, templateEngine);

        handler.addServlet(new ServletHolder(loginServlet), "/");
        handler.addServlet(new ServletHolder(chatServlet),"/messages/{id}");
        handler.addServlet(new ServletHolder(likedServlet),"/liked");
        handler.addServlet(new ServletHolder(profilesServlet),"/users");
        handler.addServlet(new ServletHolder(logOutServlet), "/logout");


        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine,profileService)), "/messages/{id}", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine,profileService)), "/liked", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine,profileService)), "/users", EnumSet.of(DispatcherType.REQUEST));


        handler.addServlet(CSSBootstrapServlet.class, "/css/bootstrap.min.css");
        handler.addServlet(JsBootstrapServlet.class, "/js/bootstrap.min.css");
        handler.addServlet(CSSStyleServlet.class, "/css/style.css");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
