package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entidades.Professor;

public class ProfessorDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Professor Professor) {
        String sql = "INSERT INTO Professores(nome, matricula, titulacao, email, telefone) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Professor.getNome());
            stmt.setInt(2, Professor.getMatricula());
            stmt.setString(3, Professor.getTitulacao());
            stmt.setString(4, Professor.getEmail());
            stmt.setString(5, Professor.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Professor Professor) {
        String sql = "UPDATE Professors SET nome=?, titulacao=?, email=?, telefone=? WHERE MatProfessor=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Professor.getNome());
            stmt.setString(2, Professor.getTitulacao());
            stmt.setString(3, Professor.getEmail());
            stmt.setString(4, Professor.getTelefone());
            stmt.setInt(5, Professor.getMatricula());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Professor Professor) {
        String sql = "DELETE FROM Professors WHERE MatProfessor=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, Professor.getMatricula());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Professor> listar() {
        String sql = "SELECT * FROM Professors";
        List<Professor> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Professor Professor = new Professor();
                Professor.setNome(resultado.getString("MtProfessor"));
                Professor.setMatricula(resultado.getInt("nome"));
                Professor.setTitulacao(resultado.getString("cpf"));
                Professor.setEmail(resultado.getString("telefone"));
                Professor.setTelefone(resultado.getString("telefone"));
                retorno.add(Professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Professor buscar(Professor Professor) {
        String sql = "SELECT * FROM Professors WHERE cdProfessor=?";
        Professor retorno = new Professor();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, Professor.getMatricula());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Professor.setNome(resultado.getString("nome"));
                Professor.setMatricula(resultado.getInt("matricula"));
                Professor.setTitulacao(resultado.getString("titulacao"));
                Professor.setEmail(resultado.getString("email"));               
                Professor.setTelefone(resultado.getString("telefone"));
                retorno = Professor;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}

