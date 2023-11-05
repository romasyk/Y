package structure.controller;


import structure.service.SignUpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class SignUpServlet extends HttpServlet {
    private final TemplateEngine templateEngine;
    SignUpService signUpService;

    public SignUpServlet(SignUpService signUpService, TemplateEngine templateEngine) {
        this.signUpService = signUpService;
        this.templateEngine = templateEngine;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        templateEngine.render("signup.ftl", resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        String email = req.getParameter("email");
        boolean saveProf = true;

        for (String e : signUpService.getAllEmails()) {
            if (email.equals(e)) {
                resp.sendRedirect("/signup");
                saveProf = false;
            }
        }

        String password = req.getParameter("password");

        String photo = req.getParameter("photoLink");
        if (photo.getBytes().length < 40) {
            photo = "https://upload.wikimedia.org/wikipedia/commons/2/2f/No-photo-m.png";
        }
        String info = req.getParameter("info");

        if (saveProf == true) {
            signUpService.saveProfile(name, email, password, photo, info);
        }
        resp.sendRedirect("/users");
    }
}
