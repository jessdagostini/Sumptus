package sumptus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sumptus.model.Area;
import sumptus.model.PayForm;

/**
 *
 * @author Jessica Dagostini
 */
public class PayFormDAO {
    private Connection con;
    
    public PayFormDAO(Connection con){
        this.con = con;
    }
    
    public Integer create(PayForm form) throws SQLException{
        String sql = "INSERT INTO payforms(form) VALUES(?)";
        Integer id = 0;
        
        try(PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stm.setString(1, form.getForm());
            stm.execute();
            
            con.commit();
            try(ResultSet rs = stm.getGeneratedKeys()){
                while(rs.next()){
                    id = rs.getInt(1);
                }
                return id;
            }
        } catch(Exception ex){
            System.out.println("Problemas ao criar o usuário " + ex.getMessage());
            con.rollback();
            return 0;
        }
    }
    
    public String update(PayForm form) throws SQLException{
        String sql = "UPDATE payforms SET form = ? WHERE id = ?";
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, form.getForm());
            stm.setInt(2, form.getId());
            stm.execute();
            
            con.commit();
            return "Forma de Pagamento Atualizada";
        } catch(Exception ex){
            return ("Não foi possível atualizar " + ex.getMessage());
        }
    }
    
    public PayForm findById(Integer id) throws SQLException{
        String sql = "SELECT * FROM payforms WHERE id = (?)";
        PayForm pform = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.execute();
            
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    pform = new PayForm();
                    pform.setId(rs.getInt("id"));
                    pform.setForm(rs.getString("form"));
                }
            }
            return pform;
        }catch(Exception ex){
            System.out.println("Problemas para encontrar registro " + ex.getMessage());
        }        
        return pform;
    }
    
    public List<PayForm> findAll() throws SQLException{
        String sql = "SELECT * FROM payforms";
        List<PayForm> pforms = new ArrayList<>();
        PayForm pform = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()){
                while(resultSet.next()){
                    pform = new PayForm();
                    pform.setId(resultSet.getInt("id"));
                    pform.setForm(resultSet.getString("form"));
                    pforms.add(pform);
                }
            }
        }
        return pforms;
    }
    
    public List<PayForm> findByName(String name) throws SQLException{
        String sql = "SELECT * FROM payforms WHERE form = ?";
        List<PayForm> pforms = new ArrayList<>();
        PayForm pform = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, name);
            stm.execute();
            
            try(ResultSet resultSet = stm.getResultSet()){
                while(resultSet.next()){
                    pform = new PayForm();
                    pform.setId(resultSet.getInt("id"));
                    pform.setForm(resultSet.getString("form"));
                    pforms.add(pform);
                }
            }
        }
        return pforms;
    }
    
    public String delete(Integer id) throws SQLException{
        String sql = "DELETE FROM payforms WHERE id = (?)";
        PayForm pform = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.executeUpdate();
            
            con.commit();
            return "Deletado com Sucesso!";
        } catch (Exception ex){
            con.rollback();
            return ("Erro ao tentar excluir: " + ex.getMessage());
        }
    }
}
