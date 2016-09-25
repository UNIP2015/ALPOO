package br.com.unip.alpoo.curso;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.unip.alpoo.disciplina.DisciplinaTableModel;
import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Disciplina;

public class TelaMostrarDisciplina extends JFrame {
	public TelaMostrarDisciplina(Component parent) {
		setTitle("Mostrar Disciplina");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);
		
		List<Disciplina> list = Disciplina.list();
		DisciplinaTableModel dm = new DisciplinaTableModel(list);
		JTable table = new JTable();
		table.setModel(dm);
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(390, 250);
		jscpane.setLocation(5,30);
		panel.add(jscpane);
		
		
		add(panel);
	}
}
