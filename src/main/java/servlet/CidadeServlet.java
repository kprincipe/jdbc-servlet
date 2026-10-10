package servlet;

import dao.CidadeDAO;
import model.Cidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cidades")
public class CidadeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter saida = resp.getWriter();

        CidadeDAO dao = new CidadeDAO();

        saida.println("<!DOCTYPE html><html><body>");
        saida.println("<h2>Cidades do Banco de Dados</h2>");
        saida.println("<ul>");

        for (Cidade c : dao.listarTodas()) {
            saida.println("<li>" + c.getNome() + " - " + c.getEstado().getSigla() + "</li>");
        }
        saida.println("</ul></body></html>");
    }
}