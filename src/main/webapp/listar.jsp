<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.transfermarkt.model.Jogador" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transfermarket - Lista de Jogadores</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
        a { text-decoration: none; padding: 5px 10px; border-radius: 4px; color: white; }
        .btn-cadastrar { background-color: #28a745; display: inline-block; margin-bottom: 15px; }
        .btn-excluir { background-color: #dc3545; }
    </style>
</head>
<body>
    <h1>Transfermarket - Jogadores Cadastrados</h1>

    <a href="cadastrar.jsp" class="btn-cadastrar">Cadastrar Novo Jogador</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Clube</th>
            <th>Posição</th>
            <th>Camisa</th>
            <th>Ações</th>
        </tr>
        <%
            List<Jogador> jogadores = (List<Jogador>) request.getAttribute("jogadores");
            if (jogadores != null) {
                for (Jogador j : jogadores) {
        %>
        <tr>
            <td><%= j.getId() %></td>
            <td><%= j.getNome() %></td>
            <td><%= j.getClube() %></td>
            <td><%= j.getPosicao() %></td>
            <td><%= j.getNumeroCamisa() %></td>
            <td>
                <a href="excluirJogador?id=<%= j.getId() %>" class="btn-excluir" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>