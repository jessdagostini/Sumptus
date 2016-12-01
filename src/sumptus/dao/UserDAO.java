package sumptus.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sumptus.model.PayForm;
import sumptus.model.User;

/**
 *
 * @author Jessica Dagostini
 */
public class UserDAO {
    private Connection con;
    
    public UserDAO(Connection con){
        this.con = con;
    }
    
    public String create(User user) throws SQLException{
        String sql = "INSERT INTO users(name, login, password, admin, created) VALUES(?, ?, ?, ?, ?)";
        Integer id = 0;
    
        try(PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stm.setString(1, user.getName());
            stm.setString(2, user.getLogin());
            stm.setString(3, user.getPassword());
            stm.setBoolean(4, user.getAdmin());
            Date created = new Date(System.currentTimeMillis());
            stm.setDate(5, created);
            stm.execute();
            
            con.commit();
            try(ResultSet rs = stm.getGeneratedKeys()){
                while(rs.next()){
                    id = rs.getInt(1);
                }
                return "Usuário criado com sucesso!";
            }
        } catch(Exception ex){
            con.rollback();
            return ("Problemas ao criar o usuário " + ex.getMessage());
        }
    }
    
    public String update(User user) throws SQLException{
        String sql = "UPDATE users SET name = ?, login = ?, password = ? WHERE id = ?";
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, user.getName());
            stm.setString(2, user.getLogin());
            stm.setString(3, user.getPassword());
            stm.setInt(4, user.getId());
            stm.execute();
            
            con.commit();
            return "Usuário atualizado!";
        } catch(Exception ex){
            return("Não foi possível atualizar " + ex.getMessage());
        }
    }
    
    public User findById(Integer id) throws SQLException{
        String sql = "SELECT * FROM users WHERE id = (?)";
        User user = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setInt(1, id);
            stm.execute();
            
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setLogin(rs.getString("login"));
                    user.setAdmin(rs.getBoolean("admin"));
                }
            }
            return user;
        }catch(Exception ex){
            System.out.println("Problemas para encontrar registro " + ex.getMessage());
        }        
        return user;
    }
    
    public List<User> findAll() throws SQLException{
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        User user = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.execute();
            
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setLogin(rs.getString("login"));
                    user.setAdmin(rs.getBoolean("admin"));
                    users.add(user);
                }
            }
        }
        return users;
    }  
        
    public User findByLogin(String login) throws SQLException{
        String sql = "SELECT * FROM users WHERE login = ?";
        User user = null;
        
        try(PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1, login);
            stm.execute();
            
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setAdmin(rs.getBoolean("admin"));
                }
            }
        }
        return user;
    }
    
    public boolean delete(Integer id) throws SQLException{
        String sql = "DELETE FROM users WHERE id = (?)";
        User user = null;
        
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
