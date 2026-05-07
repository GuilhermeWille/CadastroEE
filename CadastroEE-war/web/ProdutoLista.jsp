<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Produtos</title>
    </head>
    <body>
        <h2>Produtos Cadastrados</h2>
        <table border="1">
            <tr>
                <th>ID</th><th>Nome</th><th>Qtd</th><th>Preço</th><th>Ações</th>
            </tr>
            <c:forEach var="p" items="${listaProdutos}">
                <tr>
                    <td>${p.idProduto}</td>
                    <td>${p.nome}</td>
                    <td>${p.quantidade}</td>
                    <td><fmt:formatNumber value="${p.precoVenda}" type="currency"/></td>
                    <td>
                        <a href="ProdutoServlet?acao=excluir&id=${p.idProduto}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="ProdutoDados.jsp">Cadastrar Novo Produto</a>
    </body>
</html>