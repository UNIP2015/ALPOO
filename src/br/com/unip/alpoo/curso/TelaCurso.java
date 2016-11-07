package br.com.unip.alpoo.curso;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.unip.alpoo.dao.DAOCurso;
import br.com.unip.alpoo.model.Curso;


public class TelaCurso extends JFrame implements ActionListener{ 
	private JTextField txtNome;
	private JTextField txtCarga;
	private JRadioButton rdBacharel;
	private JRadioButton rdGestao;
	private JRadioButton rdOutros;
	private ButtonGroup groupRadio;
	private JList cbNome;

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
	
		txtNome = new JTextField();
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
		
		cbNome = new JList(lista);
		cbNome.setSize(200, 200);
		cbNome.setLocation(5, 45);
		
		panel.add(cbNome);
		
		//TIPO DE CURSO
		JLabel lbTipoCurso = new JLabel("Tipo de Curso");
		lbTipoCurso.setSize(200, 20);
		lbTipoCurso.setLocation(245, 25);
		panel.add(lbTipoCurso);
		
		rdBacharel = new JRadioButton("Bacharel");
		rdBacharel.setSize(200, 20);
		rdBacharel.setLocation(245, 45);
		panel.add(rdBacharel);
		
		rdGestao = new JRadioButton("Gestão");
		rdGestao.setSize(200, 20);
		rdGestao.setLocation(245, 65);
		panel.add(rdGestao);
		
		rdOutros = new JRadioButton("Outros");
		rdOutros.setSize(200, 20);
		rdOutros.setLocation(245, 85);
		panel.add(rdOutros);
		
		groupRadio = new ButtonGroup();
		groupRadio.add(rdBacharel);
		groupRadio.add(rdGestao);
		groupRadio.add(rdOutros);
		
		
		//CARGA HORARIA
		JLabel lbCarga = new JLabel("Carga Horaria");
		lbCarga.setSize(200, 20);
		lbCarga.setLocation(245, 105);
		panel.add(lbCarga);
		
		txtCarga = new JTextField();
		txtCarga.setSize(115,20);
		txtCarga.setLocation(245, 125);
		panel.add(txtCarga);
		
		JButton confirmButton = new JButton("Cadastrar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(100, 250);
		panel.add(confirmButton);
		
		DAOCurso dao = new DAOCurso();
		confirmButton.addActionListener(this);
		
		Button clearButton = new Button("Limpar");
		clearButton.setSize(100, 30);
		clearButton.setLocation(200, 250);
		panel.add(clearButton);
		
		//CODIGO INSTITUTO
		
		add(panel);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Curso c = new Curso();
		c.setCargaHoraria(txtCarga.getText());
		c.setCodInstitulo(1);
		
		
		String value = (String) cbNome.getSelectedValue();
		c.setNome(value);
	
		
		if(rdOutros.isSelected()){
			c.setTipo(rdOutros.getText());
		}else if(rdGestao.isSelected()){
			c.setTipo(rdGestao.getText());
		}else if(rdBacharel.isSelected()){
			c.setTipo(rdBacharel.getText());
		}else {
			c.setTipo("Nenhum");
		}
		
		
		DAOCurso dao = new DAOCurso();
		dao.save(c);
		
	}

	
}
