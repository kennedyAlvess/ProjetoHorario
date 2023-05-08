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
        String sql = "INSERT INTO professores(nome, matricula, titulacao, email) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Professor.getNome());
            stmt.setString(2, Professor.getMatricula());
            stmt.setString(3, Professor.getTitulacao());
            stmt.setString(4, Professor.getEmail());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Professor Professor) {
        String sql = "UPDATE professores SET nome=?, titulacao=?, email=? WHERE matricula=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Professor.getNome());
            stmt.setString(2, Professor.getTitulacao());
            stmt.setString(3, Professor.getEmail());
            stmt.setString(4, Professor.getMatricula());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Professor Professor) {
        String sql = "DELETE FROM professores WHERE matricula=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Professor.getMatricula());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Professor> listar() {
        String sql = "Select * from professores order by nome";
        List<Professor> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Professor professor = new Professor();
                professor.setNome(resultado.getString("nome"));
                professor.setMatricula(resultado.getString("matricula"));
                professor.setTitulacao(resultado.getString("titulacao"));
                professor.setEmail(resultado.getString("email"));
                retorno.add(professor);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os professores");
        }
        return retorno;
    }

    public List<String> validarProfessorMat() {
        String sql = "SELECT matricula FROM professores";
        List<String> matExistentes = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Professor professor = new Professor();
                professor.setMatricula(resultado.getString("matricula"));
                matExistentes.add(professor.getMatricula());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComponenteCurricularDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matExistentes;
    }
}

