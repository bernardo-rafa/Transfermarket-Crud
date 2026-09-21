package br.com.transfermarket.dao;

import br.com.transfermarket.model.Jogador;
import br.com.transfermarket.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogadorDAO {

    // 1. CADASTRAR
    public void cadastrar(Jogador jogador) {
        String sql = "INSERT INTO jogador (nome, clube, posicao, numero_camisa) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getClube());
            stmt.setString(3, jogador.getPosicao());
            stmt.setInt(4, jogador.getNumeroCamisa());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar jogador: " + e.getMessage(), e);
        }
    }

    // 2. LISTAR
    public List<Jogador> listar() {
        String sql = "SELECT * FROM jogador ORDER BY id";
        List<Jogador> jogadores = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Jogador j = new Jogador();
                j.setId(rs.getLong("id"));
                j.setNome(rs.getString("nome"));
                j.setClube(rs.getString("clube"));
                j.setPosicao(rs.getString("posicao"));
                j.setNumeroCamisa(rs.getInt("numero_camisa"));
                jogadores.add(j);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogadores: " + e.getMessage(), e);
        }
        return jogadores;
    }

    // 3. ALTERAR (Update)
    public void alterar(Jogador jogador) {
        String sql = "UPDATE jogador SET nome = ?, clube = ?, posicao = ?, numero_camisa = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getClube());
            stmt.setString(3, jogador.getPosicao());
            stmt.setInt(4, jogador.getNumeroCamisa());
            stmt.setLong(5, jogador.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar jogador: " + e.getMessage(), e);
        }
    }

    // 4. EXCLUIR
    public void excluir(Long id) {
        String sql = "DELETE FROM jogador WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir jogador: " + e.getMessage(), e);
        }
    }
}