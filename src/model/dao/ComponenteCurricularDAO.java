package model.dao;
import model.entidades.ComponenteCurricular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComponenteCurricularDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(ComponenteCurricular componentecurricular) {
        String sql = "INSERT INTO componentecurricular(nomecc, cargahorariacc, codigocc, semestre, obrigatoriedade) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getNome().toUpperCase());
            stmt.setInt(2, componentecurricular.getCargaHoraria());
            stmt.setString(3, componentecurricular.getCodigo().toUpperCase());
            stmt.setInt(4, componentecurricular.getSemestre());
            stmt.setString(5, componentecurricular.getObrigatoriedade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar inserir um componente curricular!*");
            return false;
        }
    }

    public boolean alterar(ComponenteCurricular componentecurricular) {
        String sql = "UPDATE componentecurricular SET nomecc=?, cargahorariacc=?, semestre=?, obrigatoriedade=? WHERE codigocc=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getNome().toUpperCase());
            stmt.setInt(2, componentecurricular.getCargaHoraria());
            stmt.setString(5, componentecurricular.getCodigo());
            stmt.setInt(3, componentecurricular.getSemestre());
            stmt.setString(4, componentecurricular.getObrigatoriedade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar alterar um componente curricular!*");
            return false;
        }
    }

    public boolean remover(ComponenteCurricular componentecurricular) {
        String sql = "DELETE FROM componentecurricular WHERE codigocc=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar remover um componente curricular!*");
            return false;
        }
    }

    public List<ComponenteCurricular> listar() {
        String sql = "select * from componentecurricular order by nomecc";
        List<ComponenteCurricular> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ComponenteCurricular componentecurricular = new ComponenteCurricular();
                componentecurricular.setNome(resultado.getString("nomecc"));
                componentecurricular.setCargaHoraria(resultado.getInt("cargahorariacc"));
                componentecurricular.setCodigo(resultado.getString("codigocc"));
                componentecurricular.setSemestre(resultado.getInt("semestre"));
                componentecurricular.setObrigatoriedade(resultado.getString("obrigatoriedade"));
                retorno.add(componentecurricular);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar listar componentes curriculares!*");
        }
        return retorno;
    }

    public List<String> validarCodigoCC() {
        String sql = "SELECT codigocc FROM componentecurricular";
        List<String> ccExistentes = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ComponenteCurricular componentecurricular = new ComponenteCurricular();
                componentecurricular.setCodigo(resultado.getString("codigocc"));
                ccExistentes.add(componentecurricular.getCodigo());
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao tentar validar um componente curricular!*");
        }
        return ccExistentes;
    }
}





