package sumptus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sumptus.model.Area;

/**
 *
 * @author Jessica Dagostini
 */
public class AreaDAO {
    private Connection con;
    
    public AreaDAO(Connection con){
        this.con = con;
    }
    
    public Integer create(Area area) throws SQLException{
        String sql = "INSERT INTO areas(area) VALUES(?)";
        Integer idCriado = 0;
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, area.getName());
            stm.execute();
            
            try (ResultSet resultSet = stm.getGeneratedKeys()) {
                while (resultSet.next()) {
                    idCriado = resultSet.getInt(1);
                }
            }            
            con.commit();
        } catch (Exception ex) {
            System.out.println("Erro ao tentar executar insercao: " + ex.getMessage());
            con.rollback();
        }
        
        return idCriado;
    }
    
    public boolean update(Area area) throws SQLException{
        String sql = "UPDATE areas SET area = ? WHERE id = ?";
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, area.getName());
            stm.setInt(2, area.getId());
            stm.execute();
            
            con.commit();           
            
            return true;
        } catch(Exception ex){
            System.out.println("Erro ao tentar executar autalização de dados: " + ex.getMessage());
            con.rollback();
        }
        return false;
    }
    
    public List<Area> findByName(String nome) throws SQLException{
        String sql = "SELECT * FROM areas WHERE area = (?)";
        List<Area> areas = new ArrayList<>();
        Area area = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, nome);
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()){
                while(resultSet.next()){
                    area = new Area();
                    area.setId(resultSet.getInt("id"));
                    area.setName(resultSet.getString("area"));
                    areas.add(area);
                }
            }
        }
        return areas;
    }
    
    public List<Area> findAll() throws SQLException{
        String sql = "SELECT * FROM areas";
        List<Area> areas = new ArrayList<>();
        Area area = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()){
                while(resultSet.next()){
                    area = new Area();
                    area.setId(resultSet.getInt("id"));
                    area.setName(resultSet.getString("area"));
                    areas.add(area);
                }
            }
        }
        return areas;
    }
    
    public Area findById(Integer id) throws SQLException{
        String sql = "SELECT * FROM areas WHERE id = (?)";
        Area area = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()){
                while(resultSet.next()){
                    area = new Area();
                    area.setId(resultSet.getInt("id"));
                    area.setName(resultSet.getString("area"));
                }
            }
        }
        return area;
    }
    
    public boolean delete(Integer id) throws SQLException{
        String sql = "DELETE FROM areas WHERE id = (?)";
        Area area = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.executeUpdate();
            
            con.commit();
            return true;
        } catch (Exception ex){
            System.out.println("Erro ao tentar excluir: " + ex.getMessage());
            con.rollback();
            return false;
        }
    }
}
