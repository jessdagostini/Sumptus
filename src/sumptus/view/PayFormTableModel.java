package sumptus.view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sumptus.model.PayForm;

/**
 *
 * @author Jessica Dagostini
 */
public class PayFormTableModel extends AbstractTableModel{
    private List<PayForm> pforms;
    
    public PayFormTableModel(List<PayForm> pforms){
        this.pforms = pforms;
    }
    
    public void setPayforms(List<PayForm> pforms){
        this.pforms = pforms;
    }

    @Override
    public int getRowCount() {
        return pforms.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 2;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PayForm pform = pforms.get(rowIndex);
        switch (columnIndex) {
            case 0: return pform.getId();
            case 1: return pform.getForm();
            default:
                throw new AssertionError();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Forma de Pagamento";
            default:
                throw new AssertionError();
        }
    }
    
}
