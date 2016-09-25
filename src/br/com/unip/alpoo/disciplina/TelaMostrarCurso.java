package br.com.unip.alpoo.disciplina;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.unip.alpoo.curso.MostrarCursoTableModel;
import br.com.unip.alpoo.model.Curso;

public class TelaMostrarCurso extends JFrame {
	public TelaMostrarCurso(Component parent){
		setTitle("Mostrar Curso");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);
		
		List<Curso> list = Curso.getListCursos();
		MostrarCursoTableModel dm = new MostrarCursoTableModel(list);
		JTable table = new JTable();
		table.setModel(dm);
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(390, 250);
		jscpane.setLocation(5,30);
		panel.add(jscpane);
		
		
		add(panel);
	}
}
