package br.com.unip.alpoo.professor;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Professor;

public class ProfessorTableModel extends AbstractTableModel {
	private List<Professor> listProf;
	private String[] columns = new String[]{"ID","NOME","ENDEREÇO","NUMERO","BAIRRO","CIDADE","ESTADO","TELEFONE","NASCIMENTO","ESPECIALIDADE","TITULO"};
	
	public ProfessorTableModel(List<Professor> l) {
		this.listProf = l;
	}
	
	@Override
	public int getRowCount() {
		return listProf.size();
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
		Professor p = listProf.get(rowIndex);
		
		switch(columnIndex){
			case 0:
				return p.getId() +"";
			case 1:
				return p.getNome();
			case 2:
				return p.getEndereco();
			case 3:
				return p.getNumero()+"";
			case 4:
				return p.getBairro();
			case 5:
				return p.getCidade();
			case 6:
				return p.getEstado();
			case 7:
				return p.getTelefone();
			case 8:
				return p.getDataNascimento();
			case 9: 
				return p.getEspecialidades();
			case 10: 
				return p.getTitulo();
			default:
				// Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}

}
