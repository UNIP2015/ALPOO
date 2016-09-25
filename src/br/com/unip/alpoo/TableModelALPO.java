package br.com.unip.alpoo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelALPO extends AbstractTableModel{
	private List<?> list;
	public TableModelALPO(List<?> l) {
		this.list = l;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
