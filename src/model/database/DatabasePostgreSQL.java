package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgreSQL implements Database {
    private Connection connection;

    //Setando conexão com o banco de dados local
    @Override
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDprojeto","postgres","19738246");
            return this.connection;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Drive não encontrado ou erro na conexao com o banco de dados");
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar fechar o banco de dados");
        }
    }
}

