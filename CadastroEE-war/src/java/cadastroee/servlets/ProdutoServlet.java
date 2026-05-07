package cadastroee.servlets;

import cadastroee.controller.ProdutoFacade;
import cadastroee.model.Produto;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Guilherme Wille
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    @EJB
    private ProdutoFacade facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "listar";
        }

        switch (acao) {
            case "listar":
                List<Produto> lista = facade.findAll();
                request.setAttribute("listaProdutos", lista);
                request.getRequestDispatcher("ProdutoLista.jsp").forward(request, response);
                break;

            case "formIncluir":
                request.getRequestDispatcher("ProdutoDados.jsp").forward(request, response);
                break;

            case "incluir":
                Produto novo = new Produto();
                novo.setNome(request.getParameter("nome"));
                novo.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                novo.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda")));
                
                facade.create(novo);
                response.sendRedirect("ProdutoServlet?acao=listar");
                break;

            case "excluir":
                Integer id = Integer.parseInt(request.getParameter("id"));
                Produto pExcluir = facade.find(id);
                facade.remove(pExcluir);
                response.sendRedirect("ProdutoServlet?acao=listar");
                break;
                
            default:
                response.sendRedirect("ProdutoServlet?acao=listar");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}