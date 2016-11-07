package br.com.unip.alpoo.professor;
import java.awt.Button;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.unip.alpoo.AlertOptionALPOO;



public class TelaAlterarProfessor extends JFrame{
	public TelaAlterarProfessor(Component parent) {
		setTitle("Alterar Professor");
		setSize(400,350);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);
		
		//ID
		
		JLabel lbID = new JLabel("ID");
		lbID.setLocation(5, 5);
		lbID.setSize(90,20);
		panel.add(lbID);
		
		//Nome do professor
		JLabel lbNome = new JLabel("Nome do Professor");
		lbNome.setSize(390, 15);
		lbNome.setLocation(5, 25);
		panel.add(lbNome);
		
		JTextField txtNome = new JTextField();
		txtNome.setSize(390, 20);
		txtNome.setLocation(5, 45);
		panel.add(txtNome);
		
		//Endereço
		JLabel lbEndereco = new JLabel("Endereço");
		lbEndereco.setSize(390, 20);
		lbEndereco.setLocation(5, 65);
		panel.add(lbEndereco);
		
		JTextField txtEndereco = new JTextField();
		txtEndereco.setSize(390, 20);
		txtEndereco.setLocation(5, 85);
		panel.add(txtEndereco);
		
		//Numero
		JLabel lbNumero = new JLabel("Numero");
		lbNumero.setSize(180, 20);
		lbNumero.setLocation(5, 105);
		panel.add(lbNumero);
		
		JTextField txtNumero = new JTextField();
		txtNumero.setSize(180, 20);
		txtNumero.setLocation(5, 125);
		panel.add(txtNumero);
		
		//Bairro
		JLabel lbBairro = new JLabel("Bairro");
		lbBairro.setSize(200, 20);
		lbBairro.setLocation(195, 105);
		panel.add(lbBairro);
		
		JTextField txtBairro = new JTextField();
		txtBairro.setSize(200, 20);
		txtBairro.setLocation(195, 125);
		panel.add(txtBairro);
		
		//Cidade
		JLabel lbCidade = new JLabel("Cidade");
		lbCidade.setSize(180, 20);
		lbCidade.setLocation(5, 145);
		panel.add(lbCidade);
		
		JTextField txtCidade = new JTextField();
		txtCidade.setSize(180, 20);
		txtCidade.setLocation(5, 165);
		panel.add(txtCidade);
		
		//Estado
		JLabel lbEstado = new JLabel("Estado");
		lbEstado.setSize(200, 20);
		lbEstado.setLocation(195, 145);
		panel.add(lbEstado);
		
		String[] ufs = new String[]{
				"AC","AL","AP","AM","BA",
				"CE","DF","ES","GO","MA",
				"MT","MS","MG","PR","PB",
				"PA","PE","PI","RJ","RN",
				"RS","RO","RR","SC","SE",
				"SP","TO"
		};
		
		JComboBox cbEstado = new JComboBox(ufs);
		cbEstado.setSize(200, 20);
		cbEstado.setLocation(195, 165);
		
		panel.add(cbEstado);
		
		
		try {
			//Telefone
			JLabel lbTelefone = new JLabel("Telefone");
			lbTelefone.setSize(180, 20);
			lbTelefone.setLocation(5, 185);
			panel.add(lbTelefone);
			
			MaskFormatter formater = new MaskFormatter("(##) ####-####");
			JFormattedTextField txtTelefone = new JFormattedTextField(formater);
			txtTelefone.setSize(180, 20);
			txtTelefone.setLocation(5, 205);
			panel.add(txtTelefone);
			
			
			//Data
			JLabel lbDataNasc = new JLabel("Data de Nascimento.");
			lbDataNasc.setLocation(195, 185);
			lbDataNasc.setSize(200,20);
			panel.add(lbDataNasc);
			
			formater = new MaskFormatter("##/##/####");
			JFormattedTextField txtDateNasc = new JFormattedTextField(formater);
			txtDateNasc.setSize(200, 20);
			txtDateNasc.setLocation(195, 205);
			panel.add(txtDateNasc);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Especialidade
		JLabel lbEspecialidade = new JLabel("Especialidades");
		lbEspecialidade.setSize(180, 20);
		lbEspecialidade.setLocation(5, 225);
		panel.add(lbEspecialidade);
		
		String[] especialidades = new String[]{
				"Direito","Informatica",
				"Matematica", "Medicina"
		};
		
		JComboBox cbEspecialidades = new JComboBox(especialidades);
		cbEspecialidades.setSize(180, 20);
		cbEspecialidades.setLocation(5, 245);
		
		panel.add(cbEspecialidades);
		
		
		//Titulo
		JLabel lbTitulo = new JLabel("Titulo");
		lbTitulo.setSize(200, 20);
		lbTitulo.setLocation(195, 225);
		panel.add(lbTitulo);
		
		String[] titulos = new String[]{
				"Especialista Lato Sensu","Mestrado",
				"Doutorado"
		};
		
		JComboBox cbTitulo = new JComboBox(titulos);
		cbTitulo.setSize(200, 20);
		cbTitulo.setLocation(195, 245);
		
		panel.add(cbTitulo);
		
		Button confirmButton = new Button("Alterar");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(100, 270);
		confirmButton.addActionListener(new AlertOptionALPOO(AlertOptionALPOO.EDIT,this));
		panel.add(confirmButton);
		
		add(panel);
	}
}
