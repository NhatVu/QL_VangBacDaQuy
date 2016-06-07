package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CTP_BanHangTableModel extends AbstractTableModel {

	public final static int TEN_SAN_PHAM = 0;
	public final static int SO_LUONG = 1;
	public final static int DON_GIA = 2;
	public final static int THANH_TIEN = 3;
	
	
	private List<CTP_BanHangJTable> listCTP_BanHangJTable;
	
	private final String[] columnNames = new String[] {
            /*"Mã Sản Phẩm",*/ "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
    };
	
    private final Class[] columnClass = new Class[] {
        /*String.class,*/ String.class, Integer.class, Double.class, Double.class
    };
	
    
    
	public CTP_BanHangTableModel() {
		super();
		listCTP_BanHangJTable = new ArrayList<>();
	}


	public CTP_BanHangTableModel(List<CTP_BanHangJTable> listCTP_BanHangJTable) {
		super();
		this.listCTP_BanHangJTable = listCTP_BanHangJTable;
	}

	
	public List<CTP_BanHangJTable> getListCTP_BanHangJTable() {
		return listCTP_BanHangJTable;
	}



	public void setListCTP_BanHangJTable(List<CTP_BanHangJTable> listCTP_BanHangJTable) {
		this.listCTP_BanHangJTable = listCTP_BanHangJTable;
	}
	
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return listCTP_BanHangJTable.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        CTP_BanHangJTable row = listCTP_BanHangJTable.get(rowIndex);
        
        if(0 == columnIndex) {
            return row.getTenSanPham();
        }
        else if(1 == columnIndex) {
            return row.getSoLuong();
        }
        else if(2 == columnIndex) {
            return row.getDonGia();
        }
        else if ( 3 == columnIndex ){
        	return row.getThanhTien();
        }
        
        return null;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
    	// TODO Auto-generated method stub
    	CTP_BanHangJTable row = listCTP_BanHangJTable.get(rowIndex);
    	
    	if( columnIndex == 0 )
    	{
    		row.setTenSanPham((String)value);
    	}
    	if( columnIndex == 1 )
    	{
    		row.setSoLuong((Integer) value);
    	}
    	if( columnIndex == 2 )
    	{
    		row.setDonGia((Double) value);
    	}
    	if( columnIndex == 3 )
    	{
    		row.setThanhTien( (Double) value);
    	}
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	// TODO Auto-generated method stub
    	return true;
    }

	public void addObject( CTP_BanHangJTable ctp_BanHangJTable )
    {
    	listCTP_BanHangJTable.add(ctp_BanHangJTable);
    	fireTableDataChanged();
    }
	
	public void removeObject( int index )
	{
		listCTP_BanHangJTable.remove(index);
		fireTableDataChanged();
	}

}
