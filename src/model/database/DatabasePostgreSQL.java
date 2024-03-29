package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgreSQL {
    private Connection connection;

   
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("caminho_para_seu_banco_de_dados","user","senha");
            return this.connection;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Drive não encontrado ou erro na conexao com o banco de dados");
            return null;
        }
    }
    
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar fechar o banco de dados");
        }
    }
}

