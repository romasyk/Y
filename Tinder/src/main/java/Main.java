import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import structure.controller.CSSBootstrapServlet;
import structure.controller.ProfilesServlet;
import structure.controller.JsBootstrapServlet;
import structure.controller.TemplateEngine;
import structure.dao.ListProfileDao;
import structure.dao.ProfileDao;
import structure.service.DefaultProfileService;
import structure.service.ProfileService;

public class Main {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8081);

        TemplateEngine templateEngine = new TemplateEngine();
        ProfileDao profileDao = new ListProfileDao();
        ProfileService profileService = new DefaultProfileService(profileDao);


        ServletContextHandler handler = new ServletContextHandler();
        ProfilesServlet profilesServlet = new ProfilesServlet(profileService, templateEngine);
        handler.addServlet(new ServletHolder(profilesServlet),"/users");
        handler.addServlet(CSSBootstrapServlet.class, "/css/bootstrap.min.css");
        handler.addServlet(JsBootstrapServlet.class, "/js/bootstrap.min.css");
        server.setHandler(handler);

        server.start();
        server.join();
    }
}
