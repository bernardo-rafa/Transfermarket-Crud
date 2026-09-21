package br.com.transfermarket.controller;

import br.com.transfermarket.dao.JogadorDAO;
import br.com.transfermarket.model.Jogador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JogadorController", urlPatterns = {"/jogadorController", "/salvarJogador", "/listarJogadores", "/excluirJogador"})
public class JogadorController extends HttpServlet {

    private JogadorDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new JogadorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/listarJogadores") || action.equals("/")) {
            List<Jogador> lista = dao.listar();
            request.setAttribute("jogadores", lista);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        } else if (action.equals("/excluirJogador")) {
            Long id = Long.parseLong(request.getParameter("id"));
            dao.excluir(id);
            response.sendRedirect("listarJogadores");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String clube = request.getParameter("clube");
        String posicao = request.getParameter("posicao");
        String numeroStr = request.getParameter("numeroCamisa");

        Integer numeroCamisa = (numeroStr != null && !numeroStr.isEmpty()) ? Integer.parseInt(numeroStr) : null;

        Jogador jogador = new Jogador();
        jogador.setNome(nome);
        jogador.setClube(clube);
        jogador.setPosicao(posicao);
        jogador.setNumeroCamisa(numeroCamisa);

        // Verifica se é um cadastro ou alteração (se houver ID preenchido)
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            dao.cadastrar(jogador);
        } else {
            jogador.setId(Long.parseLong(idStr));
            dao.alterar(jogador);
        }

        response.sendRedirect("listarJogadores");
    }
}