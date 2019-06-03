import dao.ClienteDao;
import dao.PessoaDao;
import modelo.Cliente;
import modelo.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("user");
        String senha = request.getParameter("password");

        if (email.equals("root") && senha.equals("masterkey")) {
            response.sendRedirect("produto.jsp");
        } else {
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa = pessoaDao.searchByEmail(email);

            if (pessoa != null) {
                String sn = returnMD5(senha);
                if (pessoa.getSenha().equals(sn)) {
                    request.getSession().setAttribute("user", pessoa.getNome());
                    response.sendRedirect("welcome.jsp");
                } else {
                    response.setContentType("text/html");
                    PrintWriter pw=response.getWriter();
                    pw.println("<script type=\"text/javascript\">");
                    pw.println("alert('Senha incorreta.');");
                    pw.println("</script>");
                    RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                    rd.include(request, response);
                }
            } else {
                response.setContentType("text/html");
                PrintWriter pw=response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Usuario nao cadastrado.');");
                pw.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                rd.include(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String returnMD5(String senha) {
        MessageDigest m= null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(senha.getBytes(),0,senha.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

}
