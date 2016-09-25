package br.com.unip.alpoo.curso;
import java.awt.Button;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class TelaCurso extends JFrame{ 
	public TelaCurso(Component parent) {
		setTitle("Cadastrar Curso");
		setSize(400,320);
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
		JLabel lbTipoCurso = new JLabel("Tipo de Curso");
		lbTipoCurso.setSize(200, 20);
		lbTipoCurso.setLocation(245, 25);
		panel.add(lbTipoCurso);
		
		JRadioButton rdBacharel = new JRadioButton("Bacharel");
		rdBacharel.setSize(200, 20);
		rdBacharel.setLocation(245, 45);
		panel.add(rdBacharel);
		
		JRadioButton rdGestao = new JRadioButton("Gestão");
		rdGestao.setSize(200, 20);
		rdGestao.setLocation(245, 65);
		panel.add(rdGestao);
		
		JRadioButton rdOutros = new JRadioButton("Outros");
		rdOutros.setSize(200, 20);
		rdOutros.setLocation(245, 85);
		panel.add(rdOutros);
		
		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(rdBacharel);
		groupRadio.add(rdGestao);
		groupRadio.add(rdOutros);
		
		
		//CARGA HORARIA
		JLabel lbCarga = new JLabel("Carga Horaria");
		lbCarga.setSize(200, 20);
		lbCarga.setLocation(245, 105);
		panel.add(lbCarga);
		
		JTextField txtCarga = new JTextField();
		txtCarga.setSize(115,20);
		txtCarga.setLocation(245, 125);
		panel.add(txtCarga);
		
		Button confirmButton = new Button("Cadastrar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(100, 250);
		panel.add(confirmButton);
		
		Button clearButton = new Button("Limpar");
		clearButton.setSize(100, 30);
		clearButton.setLocation(200, 250);
		panel.add(clearButton);
		
		//CODIGO INSTITUTO
		
		add(panel);	
	}

	
}
