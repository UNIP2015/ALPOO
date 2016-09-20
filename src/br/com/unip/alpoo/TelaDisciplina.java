package br.com.unip.alpoo;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TelaDisciplina extends JFrame{
	public TelaDisciplina(Component parent) {
		setTitle("Cadastrar Disciplina");
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
		
		//NOME
		
		//CARGA HORARIA
		
		//AULAS SEMANA
		
		//CODIGO CURSO
		
		
		add(panel);
	}
}
