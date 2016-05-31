/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import table.TableDataAdapter;

/**
 *
 * @author Administrator
 */
public class TableModel extends AbstractTableModel {
    private List<TableDataAdapter> mObjectList = new ArrayList();
    
    private String[] mColumnNames;

    public TableModel(String[] mColumnNames) {
        super();
        this.mColumnNames = mColumnNames;
    }

    public void addObject(TableDataAdapter obj)
    {
    	mObjectList.add(obj);
    	fireTableDataChanged();
    }
    
     public void removeObject(int index)
    {
    	mObjectList.remove(index);
    	fireTableDataChanged();
    }
    
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return mColumnNames[column];
               
    }
    
    @Override
    public int getRowCount() {
        return mObjectList.size();
    }

    @Override
    public int getColumnCount() {
        return mColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return mObjectList.get(rowIndex).getDataAt(columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TableDataAdapter obj = mObjectList.get(rowIndex);
        obj.setDataAt(columnIndex, (String) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public List<TableDataAdapter> getmObjectList() {
        return mObjectList;
    }

    public void setmObjectList(ArrayList<TableDataAdapter> mObjectList) {
        this.mObjectList = mObjectList;
    }

    public String[] getmColumnNames() {
        return mColumnNames;
    }

    public void setmColumnNames(String[] mColumnNames) {
        this.mColumnNames = mColumnNames;
    }



    
    
    
    
}
