<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transfermarket - Início</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; }
        .menu-container { display: flex; flex-direction: column; align-items: center; gap: 15px; }
        a { text-decoration: none; padding: 15px 30px; border-radius: 5px; color: white; font-size: 18px; width: 200px; }
        .btn-cadastrar { background-color: #28a745; }
        .btn-listar { background-color: #007bff; }
        a:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <h1>Bem-vindo ao Transfermarket</h1>
    <p>Escolha uma opção abaixo para gerenciar os jogadores:</p>

    <div class="menu-container">
        <!-- Direciona para a página de cadastro -->
        <a href="cadastrar.jsp" class="btn-cadastrar">Cadastrar Jogador</a>

        <!-- Direciona para o Servlet que lista os jogadores -->
        <a href="listarJogadores" class="btn-listar">Listar Jogadores</a>
    </div>
</body>
</html>