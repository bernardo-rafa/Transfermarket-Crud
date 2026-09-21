package br.com.transfermarket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // URL de conexão com o PostgreSQL apontando para o seu banco DBtransfermarket
    private static final String URL = "jdbc:postgresql://localhost:5432/DBtransfermarket";
    private static final String USER = "postgres";
    private static final String PASS = "123456";

    public static Connection getConnection() {
        try {
            // Registra o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro ao conectar com o PostgreSQL: " + e.getMessage(), e);
        }
    }
}