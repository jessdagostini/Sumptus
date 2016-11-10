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
            id = dao.create(area);
            
            Areas aCreate = dao.findById(id);
            System.out.println("Area pesquisada: " + aCreate.getName());
            
            //boolean deletou = dao.delete(1);
            //System.out.println("Deletou? " + deletou);
            Areas area2 = new Areas();
            area2.setId(2);
            area2.setName("Saude");
            System.out.println("Deu certo? " + dao.update(area2));
            
            List<Areas> areas = dao.findAll();
            for(Areas areaFA : areas){
                System.out.println("Id = " + areaFA.getId() + " Nome = " + areaFA.getName());
            }
        }
    }    
}
