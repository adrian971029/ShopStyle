import dao.PessoaDao;
import modelo.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String cfSenha = request.getParameter("cfPassword");

        if (senha.equals(cfSenha)) {
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoa = new Pessoa(nome, endereco, cep, email, senha);
            pessoaDao.insert(pessoa);
//            response.setContentType("text/html");
//            PrintWriter pw=response.getWriter();
//            pw.println("<script type=\"text/javascript\">");
//            pw.println("alert('Sucesso');");
//            pw.println("</script>");
//            RequestDispatcher rd=request.getRequestDispatcher("userlogin.jsp");
//            rd.include(request, response);
            response.sendRedirect("welcome.jsp");
        } else {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Senhas informadas não coincidem.');");
            pw.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("userlogin.jsp");
            rd.include(request, response);
            response.sendRedirect("cadastro.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
