/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class TableScroller extends ComponentAdapter
	{
            TableModel model;
            JTable table;

    public TableScroller(TableModel model, JTable table) {
        this.model = model;
        this.table = table;
    }
            
		public void componentResized( ComponentEvent event )
		{
			int lastRow = model.getRowCount() - 1;
			int cellTop = table.getCellRect(lastRow, 0, true).y;
			JScrollPane jsp = (JScrollPane) SwingUtilities.getAncestorOfClass(JScrollPane.class, table);
			JViewport jvp = jsp.getViewport();
			int portHeight = jvp.getSize().height;
			int position  = cellTop - ( portHeight - table.getRowHeight() - table.getRowMargin());
			if( position >= 0 )
			{
				jvp.setViewPosition(new Point(0, position));
			}
		}
	}
