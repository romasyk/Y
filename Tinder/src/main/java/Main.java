import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import structure.controller.TemplateEngine;

public class Main {
    public static void main(String[] args) throws Exception{
        Server server = new Server(8081);

        TemplateEngine templateEngine = new TemplateEngine();

        ServletContextHandler handler = new ServletContextHandler();

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
