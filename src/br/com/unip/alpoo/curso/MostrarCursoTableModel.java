package br.com.unip.alpoo.curso;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import br.com.unip.alpoo.model.Curso;

public class MostrarCursoTableModel extends AbstractTableModel{
	private List<Curso> listCursos;
	private String[] columns = new String[]{"ID","Nome","Tipo","Carga Horaria","Codigo Instituto"};	
	public MostrarCursoTableModel(List<Curso> listCursos){
		this.listCursos = listCursos;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listCursos.size();
	}
	
	@Override
    public String getColumnName(int columnIndex) {
		System.out.println("row: " + this.columns[columnIndex]);
        // Retorna o conteÃºdo do Array que possui o nome das colunas
        return this.columns[columnIndex];
    }
	@Override
	public String getValueAt(int row, int column) {
		
		Curso c = listCursos.get(row);
		switch(column){
			case 0:
				return c.getId() +"";
			case 1:
				return c.getNome();
			case 2:
				return c.getTipo();
			case 3:
				return c.getCargaHoraria()+"";
			case 4:
				return c.getCodInstitulo()+"";
			default:
				// Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		
	}
	
	public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
	
	public Curso getItemAt(int row){
		System.out.println(this.listCursos.get(row).getNome());
		return this.listCursos.get(row);
	}
	
	
}

