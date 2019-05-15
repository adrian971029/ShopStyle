import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String produto = request.getParameter("button");
        String user= (String)request.getSession().getAttribute("user");

//        request.setAttribute("usuario", user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
//        dispatcher.forward(request, response);

        request.getSession().setAttribute("user", user);
        if (produto.equals("button1")) {
            request.getSession().setAttribute("produto", "1");
            request.getSession().setAttribute("controlVenda", produto);
            response.sendRedirect("venda.jsp");
        } else if(produto.equals("button2")) {
            request.getSession().setAttribute("produto", "2");
            request.getSession().setAttribute("controlVenda", produto);
            response.sendRedirect("venda.jsp");
        } else if(produto.equals("button3")) {
            request.getSession().setAttribute("produto", "3");
            request.getSession().setAttribute("controlVenda", produto);
            response.sendRedirect("venda.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
