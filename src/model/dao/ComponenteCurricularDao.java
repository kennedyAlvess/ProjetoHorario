package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.entidades.ComponenteCurricular;
/**
 * Classes DAO onde é feita toda conexão com o banco de dados apra obter dados amarzenados
 */
public class ComponenteCurricularDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Metodos para manipulação do banco de dados (Inserir, remover,listar entre outros)
     * {@link #inserir(ComponenteCurricular)}
     * {@link #alterar(ComponenteCurricular)}
     * {@link #remover(ComponenteCurricular)}
     * {@link #listar()}
     * @see #validarCodigoCC()
     * @param componentecurricular
     * @return
     */
    public boolean inserir(ComponenteCurricular componentecurricular) {
        String sql = "INSERT INTO componentecurricular(nomecc, cargahorariacc, codigo,semestre,obrigatoriedade) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getNome());
            stmt.setInt(2, componentecurricular.getCargaHoraria());
            stmt.setString(3, componentecurricular.getCodigo());
            stmt.setInt(4, componentecurricular.getSemestre());
            stmt.setString(5, componentecurricular.getObrigatoriedade());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ComponenteCurricularDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(ComponenteCurricular componentecurricular) {
        String sql = "UPDATE componentecurricular SET nomecc=?, cargahorariacc=?, semestre=?,obrigatoriedade=? WHERE codigo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getNome());
            stmt.setInt(2, componentecurricular.getCargaHoraria());
            stmt.setInt(3, componentecurricular.getSemestre());
            stmt.setString(4, componentecurricular.getObrigatoriedade());
            stmt.setString(5, componentecurricular.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ComponenteCurricularDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(ComponenteCurricular componentecurricular) {
        String sql = "DELETE FROM componentecurricular WHERE codigo=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, componentecurricular.getCodigo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ComponenteCurricularDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                componentecurricular.setCodigo(resultado.getString("codigo"));
                componentecurricular.setSemestre(resultado.getInt("semestre"));
                componentecurricular.setObrigatoriedade(resultado.getString("obrigatoriedade"));
                retorno.add(componentecurricular);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar os ComponenteCurriculares");
        }
        return retorno;
    }

    public List<String> validarCodigoCC() {
        String sql = "SELECT codigo FROM componentecurricular";
        List<String> ccExistentes = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ComponenteCurricular componentecurricular = new ComponenteCurricular();
                componentecurricular.setCodigo(resultado.getString("codigo"));
                ccExistentes.add(componentecurricular.getCodigo());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComponenteCurricularDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ccExistentes;
    }
}





