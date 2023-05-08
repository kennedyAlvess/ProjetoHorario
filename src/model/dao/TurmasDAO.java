package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import model.entidades.Turma;

public class TurmasDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Turma Turma) {
        String sql = "INSERT INTO turmas(codigo,nomecc,horario,turm,vagas,periodo, semestre, docente) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma());
            stmt.setString(2,Turma.getNome());
            stmt.setString(3, Turma.getHorarios());
            stmt.setInt(4, Turma.getTurma());
            stmt.setInt(5, Turma.getVagas());
            stmt.setString(6, Turma.getPeriodo());
            stmt.setInt(7, Turma.getSemestre());
            stmt.setString(8, Turma.getDocente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Turma Turma) {
        String sql = "UPDATE turmas SET codigo=?,nomecc=?, horario=?, turm=?, vagas=?,periodo=?,semestre=?,docente=? WHERE codigo=? and periodo=? and turm=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma());
            stmt.setString(2,Turma.getNome());
            stmt.setString(3, Turma.getHorarios());
            stmt.setInt(4, Turma.getTurma());
            stmt.setInt(5, Turma.getVagas());
            stmt.setString(6, Turma.getPeriodo());
            stmt.setInt(7, Turma.getSemestre());
            stmt.setString(8, Turma.getDocente());
            stmt.setString(9,Turma.getCodTurma());
            stmt.setString(10, Turma.getPeriodo());
            stmt.setInt(11, Turma.getTurma());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Turma Turma) {
        String sql = "DELETE FROM turmas WHERE codigo=? and turm=? and periodo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma());
            stmt.setInt(2,Turma.getTurma());
            stmt.setString(3, Turma.getPeriodo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, "ERRO AO REMOVER TURMA", ex);
            return false;
        }
    }

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
                turma.setDocente(resultado.getString("docente"));
                turma.setVagas(Integer.parseInt(resultado.getString("vagas")));
                turma.setPeriodo(resultado.getString("periodo"));
                turma.setTurma(Integer.parseInt(resultado.getString("turm")));
                turma.setHorarios(resultado.getString("horario"));
                retorno.add(turma);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os Turmas");
        }
        return retorno;
    }

    public List<Turma> horariosDocente(String nome) {
        String sql = "SELECT horario,codigo FROM turmas where docente=? ";
        List<Turma> horarioDocente = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Turma Turma = new Turma();
                Turma.setHorarios(resultado.getString("horario"));
                Turma.setCodTurma(resultado.getString("codigo"));
                horarioDocente.add(Turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horarioDocente;
    }
}
