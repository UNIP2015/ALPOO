package br.com.unip.alpoo.disciplina;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Disciplina;
import br.com.unip.alpoo.model.Professor;

public class DisciplinaTableModel extends AbstractTableModel {
	private List<Disciplina> listDisc;
	private String[] columns = new String[]{
			"ID",
			"NOME",
			"AULAS POR SEMANA",
			"CARGA HORARIA",
			"CODIGO CURSO"
			};
	
	public DisciplinaTableModel(List<Disciplina> l) {
		this.listDisc = l;
	}
	
	@Override
	public int getRowCount() {
		return listDisc.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columns.length;
	}
	
	@Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteÃºdo do Array que possui o nome das colunas
        return this.columns[columnIndex];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Disciplina d = listDisc.get(rowIndex);
		
		switch(columnIndex){
			case 0:
				return d.getId() +"";
			case 1:
				return d.getNome();
			case 2:
				return d.getAulasPorSemana();
			case 3:
				return d.getCargaHorario()+"";
			case 4:
				return d.getCodCurso();
			default:
				// Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

}
