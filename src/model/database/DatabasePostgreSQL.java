package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabasePostgreSQL {

    private static DatabasePostgreSQL instance;
    private Connection connection;

   
    private DatabasePostgreSQL() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDprojeto","postgres", System.getenv("senhaDB"));
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Drive não encontrado ou erro na conexao com o banco de dados");
        }
    }

    public static synchronized DatabasePostgreSQL getInstance(){
        if(instance == null){
            instance = new DatabasePostgreSQL();
        }

        return instance;
    }
    
    public Connection getConexao(){
        return this.connection;
    }
}

