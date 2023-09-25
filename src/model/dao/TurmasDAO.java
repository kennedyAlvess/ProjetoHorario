package model.dao;
import model.entidades.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TurmasDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Turma Turma) {
        String sql = "INSERT INTO turmas(codigo,nomecc,horario,turm,vagas,semestre, docente,cargahoraria) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma().toUpperCase());
            stmt.setString(2,Turma.getNome().toUpperCase());
            stmt.setString(3, Turma.getHorarios().toUpperCase());
            stmt.setInt(4, Turma.getTurma());
            stmt.setInt(5, Turma.getVagas());
            stmt.setInt(6, Turma.getSemestre());
            stmt.setString(7, Turma.getDocente().toUpperCase());
            stmt.setInt(8, Turma.getCargahoraria());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar inserir uma turma!*");
            return false;
        }
    }

    public boolean alterar(Turma Turma) {
        String sql = "UPDATE turmas SET codigo=?,nomecc=?, horario=?, turm=?, vagas=?,semestre=?,docente=? WHERE codigo=? and turm=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma().toUpperCase());
            stmt.setString(2,Turma.getNome().toUpperCase());
            stmt.setString(3, Turma.getHorarios().toUpperCase());
            stmt.setInt(4, Turma.getTurma());
            stmt.setInt(5, Turma.getVagas());
            stmt.setInt(6, Turma.getSemestre());
            stmt.setString(7, Turma.getDocente().toUpperCase());
            stmt.setString(8,Turma.getCodTurma());
            stmt.setInt(9, Turma.getTurma());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar alterar uma turma!*");
            return false;
        }
    }

    public boolean remover(Turma Turma) {
        String sql = "DELETE FROM turmas WHERE codigo=? and turm=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,Turma.getCodTurma());
            stmt.setInt(2,Turma.getTurma());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar remover uma turma!*");
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
                turma.setTurma(Integer.parseInt(resultado.getString("turm")));
                turma.setHorarios(resultado.getString("horario"));
                turma.setSemestre(Integer.parseInt(resultado.getString("semestre")));
                turma.setCargahoraria(Integer.parseInt(resultado.getString("cargahoraria")));
                retorno.add(turma);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar listar turmas!*");
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
            System.err.println("Erro ao tentar validar horarios docente em turmasDAO!*");
        }
        return horarioDocente;
    }

    public List<Turma> horariosSemestre(int semestre) {
        String sql = "SELECT horario,codigo FROM turmas where semestre=?";
        List<Turma> horarioSemestre = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, semestre);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Turma Turma = new Turma();
                Turma.setHorarios(resultado.getString("horario"));
                Turma.setCodTurma(resultado.getString("codigo"));
                horarioSemestre.add(Turma);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar consultar horarios semestre em turmasDAO!*");
        }
        return horarioSemestre;
    }

    public boolean cadastrarCargaHoraria(Turma turma){
        String sql = "update professores set cargahoraria = cargahoraria+? where nome=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, (turma.getCargahoraria()/15));
            stmt.setString(2, turma.getDocente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar atualizar carga horaria professor em turmasDAO!*");
            return false;
        }
    }

    public List<Turma> validarTurma(){
        String sql = "Select * from turmas";
        List<Turma> turmasCadastradas = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                Turma turma = new Turma();
                turma.setNome(resultado.getString("nomecc"));
                turma.setCodTurma(resultado.getString("codigo"));
                turma.setDocente(resultado.getString("docente"));
                turma.setVagas(Integer.parseInt(resultado.getString("vagas")));
                turma.setTurma(Integer.parseInt(resultado.getString("turm")));
                turma.setHorarios(resultado.getString("horario"));
                turma.setSemestre(resultado.getInt("semestre"));
                turmasCadastradas.add(turma);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar validar uma turma!*");
        }
        return turmasCadastradas;
    }

    public List<String> cargaHrProfessor(){
        String sql = "Select nome from professores where cargahoraria = 20";
        List<String> professorFull = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                professorFull.add(resultado.getString("nome"));
            }          
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar consultar carga horaria professor em turmasDAO!*");
        }
        return professorFull;
    }
}
