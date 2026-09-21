<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transfermarket - Cadastrar Jogador</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { max-width: 400px; display: flex; flex-direction: column; gap: 10px; }
        input { padding: 8px; font-size: 14px; }
        button { padding: 10px; background-color: #007bff; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <h1>Cadastrar Jogador</h1>

    <form action="salvarJogador" method="POST">
        <label>Nome:</label>
        <input type="text" name="nome" required>

        <label>Clube Atual:</label>
        <input type="text" name="clube" required>

        <label>Posição:</label>
        <input type="text" name="posicao" required>

        <label>Número da Camisa:</label>
        <input type="number" name="numeroCamisa" required>

        <button type="submit">Salvar Jogador</button>
    </form>

    <br>
    <a href="listar.jsp">Voltar para a listagem</a>
</body>
</html>