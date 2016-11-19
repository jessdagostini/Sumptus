package sumptus.view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sumptus.model.Area;

/**
 *
 * @author Jessica Dagostini
 */
public class AreaTableModel extends AbstractTableModel{
    private List<Area> areas;
    
    public AreaTableModel(List<Area> areas){
        this.areas = areas;
    }
    
    public void setAreas(List<Area> areas){
        this.areas = areas;
    }

    @Override
    public int getRowCount() {
        return areas.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 2;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Area area = areas.get(rowIndex);
        switch (columnIndex) {
            case 0: return area.getId();
            case 1: return area.getName();
            default:
                throw new AssertionError();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Área";
            default:
                throw new AssertionError();
        }
    }
    
}
