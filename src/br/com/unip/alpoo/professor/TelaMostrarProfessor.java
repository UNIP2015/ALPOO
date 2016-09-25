package br.com.unip.alpoo.professor;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



import br.com.unip.alpoo.curso.MostrarCursoTableModel;
import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Professor;

public class TelaMostrarProfessor extends JFrame{
	public TelaMostrarProfessor(Component parent) {
		setTitle("Mostrar Professor");
		setSize(800,300);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(600,300);
		panel.setLayout(null);
		
		List<Professor> list = Professor.list();
		ProfessorTableModel dm = new ProfessorTableModel(list);
		JTable table = new JTable();
		table.setModel(dm);
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(790, 250);
		jscpane.setLocation(5,30);
		panel.add(jscpane);
		
		
		add(panel);
	}
}
