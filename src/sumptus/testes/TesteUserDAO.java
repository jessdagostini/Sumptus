package sumptus.testes;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import sumptus.dao.DataBase;
import sumptus.dao.UserDAO;
import sumptus.model.User;

/**
 *
 * @author Jessica Dagostini
 */
public class TesteUserDAO {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException{
        User user = new User();
        
        try(Connection con = DataBase.connection()){
            UserDAO userDAO = new UserDAO(con);
            //SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSX");

            user.setName("Adelar Dagostini");
            user.setLogin("adelar");
            user.setPassword("348555");
            user.setAdmin(true);
            
            Integer id;
            id = userDAO.create(user);
            System.out.println("Criou usuário = " + id);
            
            User test = userDAO.findById(2);
            System.out.println("User = " + test.getId() + " " + test.getName());
            
            Boolean delete = userDAO.delete(2);
            System.out.println("Deletou? " + delete);
        }
    }
}
