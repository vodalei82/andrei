import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ConcurrentModificationException;

@WebServlet(name = "Servlet_2")
public class Servlet_2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        UsersStorage userstorage = UsersStorage.getInstance();
        User user = new User("Andrei", "Vodalei", Role.ADMIN);
        userstorage.add(user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ConcurrentModificationException {
        String log = req.getParameter("login");
        String pass = req.getParameter("password");
        User user = new User(log, pass, Role.USER);
        UsersStorage userLogin = UsersStorage.getInstance();
        userLogin.add(user);

        Role rol = userLogin.getRole(log, pass);

        req.setAttribute("role", rol);

        if (rol.equals(Role.ADMIN)) {

            req.setAttribute("users", UsersStorage.allUsers);

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/admin.jsp");
            requestDispatcher.forward(req, resp);

            return;



        } else if (rol.equals(Role.USER)) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/user.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }



    }
}
