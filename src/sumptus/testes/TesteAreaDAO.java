package sumptus.testes;

import java.sql.Connection;
import java.sql.SQLException;
import sumptus.dao.AreaDAO;
import sumptus.dao.DataBase;
import sumptus.model.Areas;

/**
 *
 * @author Jessica Dagostini
 */
public class TesteAreaDAO {
    public static void main(String[] args) throws SQLException{
        Areas area = new Areas();
        area.setName("Educação");
        
        Integer id;
        try(Connection con = DataBase.connection()){
            AreaDAO dao = new AreaDAO(con);
            id = dao.create(area);
            
            System.out.println("Nova area adicionada: " + id);
        }
    }    
}
