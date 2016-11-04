package sumptus.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
            //id = dao.create(area);
            
            List<Areas> areasList = dao.findById(1);
            Areas areaParaMostrar = areasList.get(0);
            System.out.println("Area pesquisada: " + areaParaMostrar.getName());
            
            boolean deletou = dao.delete(1);
            System.out.println("Deletou? " + deletou);
        }
    }    
}
