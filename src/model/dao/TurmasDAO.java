package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;

import model.entidades.Turma;

public class TurmasDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // public boolean inserir(Turma turma) {
    //     String sql = "INSERT INTO turmas(nome, codigo, semestre, vagas, docentes) VALUES(?,?,?,?)";
    //     try {
    //         PreparedStatement stmt = connection.prepareStatement(sql);
    //         stmt.setString(1, turma.getNome());
    //         stmt.setString(2, turma.get());
    //         stmt.setString(3, turma.getTitulacao());
    //         stmt.setString(4, turma.getEmail());
    //         stmt.execute();
    //         return true;
    //     } catch (SQLException ex) {
    //         Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
    //         return false;
    //     }
    // }

    // public boolean alterar(Turma Turma) {
    //     String sql = "UPDATE Turmaes SET nome=?, titulacao=?, email=? WHERE matricula=?";
    //     try {
    //         PreparedStatement stmt = connection.prepareStatement(sql);
    //         stmt.setString(1, Turma.getNome());
    //         stmt.setString(2, Turma.getTitulacao());
    //         stmt.setString(3, Turma.getEmail());
    //         stmt.setString(4, Turma.getMatricula());
    //         stmt.execute();
    //         return true;
    //     } catch (SQLException ex) {
    //         Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
    //         return false;
    //     }
    // }

    // public boolean remover(Turma Turma) {
    //     String sql = "DELETE FROM Turmaes WHERE matricula=?";
    //     try {
    //         PreparedStatement stmt = connection.prepareStatement(sql);
    //         stmt.setString(1, Turma.getMatricula());
    //         stmt.execute();
    //         return true;
    //     } catch (SQLException ex) {
    //         Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
    //         return false;
    //     }
    // }

    public List<Turma> listar() {
        String sql = "Select * from turmas order by nomecc";
        List<Turma> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Turma turma = new Turma();
                turma.setNome(resultado.getString("nomecc"));
                turma.setCodTurma(resultado.getString("codigo"));
                //turma.adicionarDocente(resultado.getString("docente"));
                turma.setVagas(Integer.parseInt(resultado.getString("vagas")));
                turma.setPeriodo(resultado.getString("periodo"));
                turma.setTurma(Integer.parseInt(resultado.getString("turm")));
                retorno.add(turma);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os Turmas");
        }
        return retorno;
    }

    // public Turma buscar(Turma Turma) {
    //     String sql = "SELECT * FROM Turmaes WHERE matricula=?";
    //     Turma retorno = new Turma();
    //     try {
    //         PreparedStatement stmt = connection.prepareStatement(sql);
    //         stmt.setString(1, Turma.getMatricula());
    //         ResultSet resultado = stmt.executeQuery();
    //         if (resultado.next()) {
    //             Turma.setNome(resultado.getString("nome"));
    //             Turma.setMatricula(resultado.getString("matricula"));
    //             Turma.setTitulacao(resultado.getString("titulacao"));
    //             Turma.setEmail(resultado.getString("email"));               
    //             retorno = Turma;
    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //     return retorno;
    // }

    // public List<String> matricula() {
    //     String sql = "SELECT matricula FROM Turmaes";
    //     List<String> matriculas = new ArrayList<>();
    //     try {
    //         PreparedStatement stmt = connection.prepareStatement(sql);
    //         ResultSet resultado = stmt.executeQuery();
    //         while (resultado.next()) {
    //             Turma Turma = new Turma();
    //             Turma.setMatricula(resultado.getString("matricula"));
    //             matriculas.add(Turma.getMatricula());
    //         }
    //     } catch (SQLException ex) {
    //         Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //     return matriculas;
    // }
}
