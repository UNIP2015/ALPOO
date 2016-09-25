package br.com.unip.alpoo.disciplina;
import java.awt.Button;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class TelaExcluirDisciplina extends JFrame{
	public TelaExcluirDisciplina(Component parent) {
		setTitle("Excluir Disciplina");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);
		
		//ID 
		JLabel lbID = new JLabel("ID");
		lbID.setSize(200, 20);
		lbID.setLocation(5,5);
		panel.add(lbID);
		
		
		//NOME
		JLabel lbNome = new JLabel("Nome");
		setDefaultSize(lbNome);
		addBottom(lbNome, lbID);
		panel.add(lbNome);
		
		JTextField txtNome = new JTextField();
		setDefaultSize(txtNome);
		addBottom(txtNome, lbNome);
		panel.add(txtNome);
		
		
		//AULAS SEMANA
		JLabel lbAulas = new JLabel("Aulas por Semana");
		setDefaultSize(lbAulas,2);
		addBottom(lbAulas, txtNome);
		panel.add(lbAulas);
		
		//Options
		JRadioButton rd1 = new JRadioButton("1");
		setDefaultSize(rd1, 6);
		addBottom(rd1, lbAulas);
		panel.add(rd1);
		
		JRadioButton rd2 = new JRadioButton("2");
		setDefaultSize(rd2, 6);
		addBottom(rd2, lbAulas,6);
		panel.add(rd2);
		
		JRadioButton rd3 = new JRadioButton("3");
		setDefaultSize(rd3, 6);
		addBottom(rd3, rd1);
		panel.add(rd3);
		
		JRadioButton rd4 = new JRadioButton("4");
		setDefaultSize(rd4, 6);
		addBottom(rd4, rd1,6);
		panel.add(rd4);
		
		JRadioButton rd5 = new JRadioButton("5");
		setDefaultSize(rd5, 6);
		addBottom(rd5, rd3);
		panel.add(rd5);
		
		JRadioButton rd6 = new JRadioButton("6");
		setDefaultSize(rd6, 6);
		addBottom(rd6, rd3,6);
		panel.add(rd6);
		
		ButtonGroup groupCarga = new ButtonGroup();
		groupCarga.add(rd1);
		groupCarga.add(rd2);
		groupCarga.add(rd3);
		groupCarga.add(rd4);
		groupCarga.add(rd5);
		groupCarga.add(rd6);
		
		
		
		
		//CARGA HORARIA
		JLabel lbCarga = new JLabel("Carga Horaria");
		setDefaultSize(lbCarga,2);
		addBottom(lbCarga, txtNome,2);
		panel.add(lbCarga);
		
		JTextField txtCarga = new JTextField();
		setDefaultSize(txtCarga,2);
		addBottom(txtCarga, lbCarga,2);
		panel.add(txtCarga);
		
		//CODIGO CURSO
		JLabel lbCdCurso = new JLabel("Codigo do Curso");
		setDefaultSize(lbCdCurso,2);
		addBottom(lbCdCurso, txtCarga,2);
		panel.add(lbCdCurso);
		
		JTextField txtCdCurso = new JTextField();
		setDefaultSize(txtCdCurso,2);
		addBottom(txtCdCurso, lbCdCurso,2);
		panel.add(txtCdCurso);
		
		Button confirmButton = new Button("Excluir");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(100, 200);
		panel.add(confirmButton);	
		
		add(panel);
	}
	private void setDefaultSize(Component c){
		c.setSize(390,20);
	}
	private void setDefaultSize(Component c, int divisor){
		int r = 390/divisor;
		r -= 5;
		c.setSize(r,20);
	}
	
	private void addBottom(Component component, Component elementTop){
		int y = elementTop.getLocation().y + elementTop.getSize().height;
		component.setLocation(elementTop.getLocation().x, y);
	}
	private void addBottom(Component component, Component elementTop, int divisor){
		int y = elementTop.getLocation().y + elementTop.getSize().height;
		int x = 390 / divisor;
		x += 10;
		component.setLocation(x, y);
	}
}
