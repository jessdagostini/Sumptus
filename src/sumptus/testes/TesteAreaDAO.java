package sumptus.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import sumptus.dao.AreaDAO;
import sumptus.dao.DataBase;
import sumptus.model.Area;

/**
 *
 * @author Jessica Dagostini
 */
public class TesteAreaDAO {
    public static void main(String[] args) throws SQLException{
        Area area = new Area();
        area.setName("Educação");
        
        Integer id;
        try(Connection con = DataBase.connection()){
            AreaDAO dao = new AreaDAO(con);
            id = dao.create(area);
            
            Area aCreate = dao.findById(id);
            System.out.println("Area pesquisada: " + aCreate.getName());
            
            //boolean deletou = dao.delete(1);
            //System.out.println("Deletou? " + deletou);
            Area area2 = new Area();
            area2.setId(2);
            area2.setName("Saude");
            System.out.println("Deu certo? " + dao.update(area2));
            
            List<Area> areas = dao.findAll();
            for(Area areaFA : areas){
                System.out.println("Id = " + areaFA.getId() + " Nome = " + areaFA.getName());
            }
        }
    }    
}
