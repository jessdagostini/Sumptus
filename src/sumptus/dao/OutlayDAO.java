package sumptus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sumptus.dao.AreaDAO;
import sumptus.dao.PayFormDAO;
import sumptus.dao.UserDAO;
import sumptus.model.Outlay;
import sumptus.model.User;
/**
 *
 * @author Jessica Dagostini
 */
public class OutlayDAO {
    Connection con;
    AreaDAO areaDAO;
    PayFormDAO pformDAO;
    UserDAO userDAO;
    
    public OutlayDAO(Connection con){
        this.con = con;
        areaDAO = new AreaDAO(con);
        pformDAO = new PayFormDAO(con);
        userDAO = new UserDAO(con);
    }
    
    public Integer create(Outlay outlay) throws SQLException{
        String sql = "INSERT INTO outlays (user_id, area_id, payform_id, description, cost, purchase_date, payment_day) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Integer idCriado = 0;
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setInt(1, outlay.getUser().getId());
            stm.setInt(2, outlay.getArea().getId());
            stm.setInt(3, outlay.getPform().getId());
            stm.setString(4, outlay.getDescription());
            stm.setBigDecimal(5, outlay.getCost());
            java.sql.Date dataPurchase = new java.sql.Date(outlay.getPurchase_date().getTime());
            stm.setDate(6, dataPurchase);
            java.sql.Date dataPayment = new java.sql.Date(outlay.getPayment_day().getTime());
            stm.setDate(7, dataPayment);
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
    
    public Outlay findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM outlays WHERE id = ?";
        Outlay outlay = null;
        try(PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, id);
            stm.execute();

            try(ResultSet resultSet = stm.getResultSet()) {
                while(resultSet.next()) {
                    outlay = new Outlay();
                    outlay.setId(resultSet.getInt("id"));
                    outlay.setArea(areaDAO.findById(resultSet.getInt("area_id")));
                    outlay.setPform(pformDAO.findById(resultSet.getInt("payform_id")));
                    outlay.setUser(userDAO.findById(resultSet.getInt("user_id")));
                    outlay.setDescription(resultSet.getString("description"));
                    outlay.setCost(resultSet.getBigDecimal("cost"));
                    outlay.setPurchase_date(resultSet.getDate("purchase_date"));
                    outlay.setPayment_day(resultSet.getDate("payment_day"));
                    outlay.setTrue_value(resultSet.getBigDecimal("true_value"));
                    outlay.setPercentage(resultSet.getDouble("percentage"));
                    outlay.setTrue_payday(resultSet.getDate("true_payday"));
                }
            }
        } catch (Exception ex){
            System.out.println("Não encontrou por ID " + ex.getMessage());
        }

        return outlay;
    }
    
    public List<Outlay> findByUser(Integer user_id) throws SQLException {
        String sql = "SELECT * FROM outlays WHERE user_id = ? ORDER BY payment_day DESC";
        List<Outlay> outlays = new ArrayList<>();
        Outlay outlay = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, user_id);
            stm.execute();

            try(ResultSet resultSet = stm.getResultSet()) {
                while(resultSet.next()) {
                    outlay = new Outlay();
                    outlay.setId(resultSet.getInt("id"));
                    outlay.setArea(areaDAO.findById(resultSet.getInt("area_id")));
                    outlay.setPform(pformDAO.findById(resultSet.getInt("payform_id")));
                    outlay.setUser(userDAO.findById(resultSet.getInt("user_id")));
                    outlay.setDescription(resultSet.getString("description"));
                    outlay.setCost(resultSet.getBigDecimal("cost"));
                    outlay.setPurchase_date(resultSet.getDate("purchase_date"));
                    outlay.setPayment_day(resultSet.getDate("payment_day"));
                    outlay.setPaid(resultSet.getBoolean("paid"));
                    outlay.setTrue_value(resultSet.getBigDecimal("true_value"));
                    outlay.setPercentage(resultSet.getDouble("percentage"));
                    outlay.setTrue_payday(resultSet.getDate("true_payday"));
                    outlays.add(outlay);
                }
            }
        } catch (Exception ex){
            System.out.println("Não encontrou por ID " + ex.getMessage());
        }

        return outlays;
    }
    
    public String update(Outlay outlay) throws SQLException{
        String sql = "UPDATE outlays SET area_id = ?, payform_id = ?, description = ?, cost = ?, purchase_date = ?, payment_day = ? WHERE id = ?";
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, outlay.getArea().getId());
            stm.setInt(2, outlay.getPform().getId());
            stm.setString(3, outlay.getDescription());
            stm.setBigDecimal(4, outlay.getCost());            
            java.sql.Date dataPurchase = new java.sql.Date(outlay.getPurchase_date().getTime());
            stm.setDate(5, dataPurchase);
            java.sql.Date dataPayment = new java.sql.Date(outlay.getPayment_day().getTime());
            stm.setDate(6, dataPayment);
            stm.setInt(7, outlay.getId());
            stm.execute();
            
            con.commit();
            return "Dado atualizado com sucesso!";
        } catch (Exception ex){
            con.rollback();
            return("Erro ao atualizar = " + ex.getMessage());
        }
    }
    
    public String updatePaid(Outlay outlay) throws SQLException{
            String sql = "UPDATE outlays SET paid = ?, true_value = ?, percentage = ?, true_payday = ? WHERE id = ?";
        try(PreparedStatement stm = con.prepareStatement(sql)){            
            stm.setBoolean(1, outlay.savePaid());
            stm.setBigDecimal(2, outlay.getTrue_value());
            stm.setDouble(3, outlay.getPercentage());
            java.sql.Date dataRealPay = new java.sql.Date(outlay.getTrue_payday().getTime());
            stm.setDate(4, dataRealPay);
            stm.setInt(5, outlay.getId());
            stm.execute();
            
            con.commit();
            return "Dado atualizado com sucesso!";
        } catch (Exception ex){
            con.rollback();
            return("Erro ao atualizar = " + ex.getMessage());
        }
    }
    
    public boolean delete(Integer id) throws SQLException{
        String sql = "DELETE FROM outlays WHERE id = ?";
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.execute();
            
            con.commit();
            return true;
        } catch (Exception ex){
            System.out.println("Deu ruim pra exclui " + ex.getMessage());
            con.rollback();
            
            return false;
        }        
    }
}
