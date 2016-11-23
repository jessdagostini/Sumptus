package sumptus.testes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import sumptus.dao.AreaDAO;
import sumptus.dao.DataBase;
import sumptus.dao.OutlayDAO;
import sumptus.dao.PayFormDAO;
import sumptus.dao.UserDAO;
import sumptus.model.Area;
import sumptus.model.Outlay;
import sumptus.model.PayForm;
import sumptus.model.User;

/**
 *
 * @author Jessica Dagostini
 */
public class TesteOutlayDAO {
     public static void main(String[] args) throws SQLException {
         try (Connection con = DataBase.connection()) {
             Integer id;
             
             OutlayDAO DAO = new OutlayDAO(con);
             Outlay out = new Outlay();
             Area area = new AreaDAO(con).findById(2);
             PayForm pform = new PayFormDAO(con).findById(2);
             User user = new UserDAO(con).findById(1);
             
             out.setUser(user);
             out.setArea(area);
             out.setPform(pform);
             out.setDescription("Esta é uma descrição de gasto");
             out.setCost(new BigDecimal("12.37"));
             out.setPurchase_date(new java.sql.Timestamp(new java.util.Date().getTime()));
             out.setPayment_day(new java.sql.Timestamp(new java.util.Date().getTime()));
             
             id = DAO.create(out);
             System.out.println("Outlay criado - Id: " + id);
             
             out = DAO.findById(2);
             System.out.println("Valor" + out.getCost());
             out.setPform(new PayFormDAO(con).findById(4));
             boolean salvou;
             salvou = DAO.update(out);
             System.out.println("Salvou? " + salvou);
             System.out.println(out.getCost());
             
             DAO.delete(4);
             
         }
     }
}
