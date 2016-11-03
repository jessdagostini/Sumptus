package sumptus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sumptus.model.Areas;

/**
 *
 * @author Jessica Dagostini
 */
public class AreaDAO {
    private Connection con;
    
    public AreaDAO(Connection con){
        this.con = con;
    }
    
    public Integer create(Areas area) throws SQLException{
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
    
}
