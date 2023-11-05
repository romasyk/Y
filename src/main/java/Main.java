import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import structure.controller.*;
import structure.dao.*;
import structure.service.*;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.parseInt(System.getenv("PORT") == null ? "8081" : System.getenv("PORT")));

        TemplateEngine templateEngine = new TemplateEngine();

        ProfileDao profileDao = new JDBCProfileDao();
        ProfileService profileService = new DefaultProfileService(profileDao);

        SignUpService signUpService = new DefaultSignUpService(profileDao);

        LikeDao likeDao = new JDBCLikeDao();
        LikeService likeService = new LikeProfileService(likeDao);

        ChatDao chatDao = new JDBCChatDao();
        ChatService chatService = new DefaultChatService(chatDao);


        ServletContextHandler handler = new ServletContextHandler();
        ProfilesServlet profilesServlet = new ProfilesServlet(profileService, likeService, templateEngine);
        LikedServlet likedServlet = new LikedServlet(likeService, templateEngine);
        ChatServlet chatServlet = new ChatServlet(profileService, chatService, templateEngine);
        LoginServlet loginServlet = new LoginServlet(templateEngine);
        LogOutServlet logOutServlet = new LogOutServlet(likeService, templateEngine);
        SignUpServlet signUpServlet = new SignUpServlet(signUpService, templateEngine);

        handler.addServlet(new ServletHolder(loginServlet), "/");
        handler.addServlet(new ServletHolder(chatServlet), "/message");
        handler.addServlet(new ServletHolder(likedServlet), "/liked");
        handler.addServlet(new ServletHolder(profilesServlet), "/users");
        handler.addServlet(new ServletHolder(logOutServlet), "/logout");
        handler.addServlet(new ServletHolder(signUpServlet), "/signup");

        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine, profileService)), "/message", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine, profileService)), "/liked", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine, profileService)), "/users", EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST));

        handler.addServlet(CSSBootstrapServlet.class, "/css/bootstrap.min.css");
        handler.addServlet(JsBootstrapServlet.class, "/js/bootstrap.min.css");
        handler.addServlet(CSSStyleServlet.class, "/css/style.css");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
