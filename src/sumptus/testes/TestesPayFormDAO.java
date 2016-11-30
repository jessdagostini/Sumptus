package sumptus.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import sumptus.dao.DataBase;
import sumptus.dao.PayFormDAO;
import sumptus.model.PayForm;

/**
 *
 * @author Jessica Dagostini
 */
public class TestesPayFormDAO {
    public static void main(String[] args) throws SQLException{
        try(Connection con = DataBase.connection()){
            PayFormDAO payDAO = new PayFormDAO(con);
            PayForm payf = new PayForm();
            payf.setForm("Cartão Banrisul");
            
            Integer id = payDAO.create(payf);
            System.out.println("PayForm ID = " + id);
            //Integer id = 2;
            PayForm payfo = payDAO.findById(id);
            System.out.println("Forma = " + payfo.getForm());
            payfo.setForm("Cartão");
            String saida = payDAO.update(payfo);
            System.out.println("Atualizou informação? " + saida);
            
            //List<PayForm> pforms = payDAO.findByName("Cartão");
             /*for(PayForm pform : pforms){
                System.out.println("Id = " + pform.getId() + " Forma = " + pform.getForm());
            }*/
           // saida = payDAO.delete(id);
            //System.out.println("Deletou? " + saida);
        }catch(Exception ex){
            System.out.println("Deu ruim na conexão " + ex.getMessage());
        }        
    }    
}
