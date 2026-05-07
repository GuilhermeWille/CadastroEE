<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Produto</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h1>Incluir Novo Produto</h1>
        <form action="ProdutoServlet" method="POST">
            <input type="hidden" name="acao" value="incluir">
            
            <label>Nome:</label><br>
            <input type="text" name="nome" required><br><br>
            
            <label>Quantidade:</label><br>
            <input type="number" name="quantidade" required><br><br>
            
            <label>Preço de Venda:</label><br>
            <input type="text" name="precoVenda" required><br><br>
            
            <input type="submit" value="Salvar Produto">
            <a href="ProdutoServlet?acao=listar">Cancelar</a>
        </form>
    </body>
</html>