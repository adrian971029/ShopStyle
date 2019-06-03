import dao.ProdutoDao;
import helper.AtomicNumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Produto")
public class Produto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String qtd = request.getParameter("quantidade");
        String descricao = request.getParameter("descricao");
        String tamanho = request.getParameter("optradio");

        modelo.Produto produto = new modelo.Produto(nome, Float.parseFloat(preco), Integer.parseInt(qtd), descricao);
        produto.setId(AtomicNumber.generateAtomicNumber());
        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.insert(produto);
        response.sendRedirect("index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
