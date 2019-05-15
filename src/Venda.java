import dao.VendaDao;
import helper.AtomicNumber;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet("/Venda")
public class Venda extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String produto= (String)request.getSession().getAttribute("produto");
        String btn = request.getParameter("button");

        VendaDao vendaDao = new VendaDao();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        switch (produto) {
            case "1":
                String qtd = request.getParameter("pd1");
                if (qtd != null) {
                    try {
                        float valor = Float.parseFloat(qtd);
                        valor = valor * 20;
                        modelo.Venda venda = new modelo.Venda(AtomicNumber.generateAtomicNumber(), timeStamp,valor);
                        vendaDao.insert(venda);
                        request.getSession().setAttribute("venda", "ok");
                        response.sendRedirect("welcome.jsp");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "2":
                String qtd1 = request.getParameter("pd2");
                if (qtd1 != null) {
                    try {
                        float valor = Float.parseFloat(qtd1);
                        valor = valor * 45;
                        modelo.Venda venda = new modelo.Venda(AtomicNumber.generateAtomicNumber(), timeStamp, valor);
                        vendaDao.insert(venda);
                        request.getSession().setAttribute("venda", "ok");
                        response.sendRedirect("welcome.jsp");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case "3":
                String qtd2 = request.getParameter("pd3");
                if (qtd2 != null) {
                    try {
                        float valor = Float.parseFloat(qtd2);
                        valor = valor * 12;
                        modelo.Venda venda = new modelo.Venda(AtomicNumber.generateAtomicNumber(), timeStamp, valor);
                        vendaDao.insert(venda);
                        request.getSession().setAttribute("venda", "ok");
                        response.sendRedirect("welcome.jsp");
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
