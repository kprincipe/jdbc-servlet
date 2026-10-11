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

        saida.println("<!DOCTYPE html><html>");
        saida.println("<head>");
        saida.println("<title>JDBC-Servlet - Cidades</title>");
        saida.println("<link rel='stylesheet' href='css/estilos.css'>");
        saida.println("</head>");
        saida.println("<body>");
        saida.println("<h2>&#8594; <span class='titulo'>Cidades do Banco de Dados<span></h2>");
        saida.println("<ul>");

        for (Cidade c : dao.listarTodas()) {
            saida.println("<li>" + c.getNome() + " - " + c.getEstado().getSigla() + "</li>");
        }

        saida.println("</ul><a href='/'>Voltar</a>");
        saida.println("</ul></body></html>");
    }
}