package br.com.unip.alpoo;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaCurso extends JFrame{ 
	public TelaCurso(Component parent) {
		setTitle("Cadastrar Curso");
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
		JLabel lbId = new JLabel("ID");
		lbId.setSize(390, 20);
		lbId.setLocation(5,390);
		panel.add(lbId);
		
		//NOME
		JLabel lbNome = new JLabel("Nome");
		lbNome.setSize(390, 20);
		lbNome.setLocation(5,25);
		panel.add(lbNome);
	
		JTextField txtNome = new JTextField();
		txtNome.setSize(390,20);
		txtNome.setLocation(5, 45);
		
		String[] cursos = new String[]{
				
		};
		
		DefaultListModel lista = new DefaultListModel();
		lista.addElement("Administração de Empresa");
		lista.addElement("Bio Medicia");
		lista.addElement("Ciências Biologicas");
		lista.addElement("Ciência da Computação");
		lista.addElement("Direito");
		lista.addElement("Educação Fisica");
		lista.addElement("Farmacologia");
		lista.addElement("Rede de Computadores");
		lista.addElement("Sistema de Informações");
		
		JList cbNome = new JList(lista);
		cbNome.setSize(200, 200);
		cbNome.setLocation(5, 45);
		
		panel.add(cbNome);
		
		//TIPO DE CURSO
		JLabel lbTipoCurso = new JLabel("Tido de Curso");
		lbTipoCurso.setSize(200, 20);
		lbTipoCurso.setLocation(5, 65);
		panel.add(lbTipoCurso);
		
		

		
		//CARGA HORARIA
		
		//CODIGO INSTITUTO
		
		add(panel);	
	}

	
}