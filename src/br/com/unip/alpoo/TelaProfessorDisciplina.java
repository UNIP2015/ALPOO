package br.com.unip.alpoo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.unip.alpoo.FrameALPO;
import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Disciplina;
import br.com.unip.alpoo.model.Professor;
import br.com.unip.alpoo.professor.ProfessorTableModel;
import br.com.unip.alpoo.professor.TelaMostrarProfessor;

public class TelaProfessorDisciplina extends FrameALPO{
	private JTable table;
	private JLabel lbId;
	private JLabel lbNome;
	private JTextField txtNome;
	
	private JLabel lbTipoCurso;
	private JRadioButton rdBacharel;
	private JRadioButton rdGestao;
	private JRadioButton rdOutros;
	private ButtonGroup groupRadio;
	private JLabel lbCarga;
	private JTextField txtCarga;
	private DefaultListModel lista;
	
	private Curso c;
	private JLabel lbDisciplina;
	
	
	protected JLabel lbEndereco;
	protected JTextField txtEndereco;
	protected JLabel lbNumero;
	protected JTextField txtNumero;
	protected JLabel lbBairro;
	protected JTextField txtBairro;
	protected JLabel lbCidade;
	protected JTextField txtCidade;
	protected JLabel lbEstado;
	protected JComboBox cbEstado;
	protected JLabel lbTelefone;
	protected MaskFormatter formater;
	protected JLabel lbDataNasc;
	protected JFormattedTextField txtDateNasc;
	protected JLabel lbEspecialidade;
	protected JComboBox cbEspecialidades;
	protected JLabel lbTitulo;
	protected JComboBox cbTitulo;
	protected String[] ufs;
	protected String[] titulos;
	protected String[] especialidades;
	protected JPanel panel;
	private JLabel lbID;
	
	public TelaProfessorDisciplina(Component parent){
		setTitle("Mostrar Professor");
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);
		
		//
		
		
		//ID
		
		lbID = new JLabel("ID");
		lbID.setLocation(5, 5);
		lbID.setSize(90,20);
		panel.add(lbID);
		
		//Nome do professor
		lbNome = new JLabel("Nome do Professor");
		lbNome.setSize(390, 15);
		lbNome.setLocation(5, 25);
		panel.add(lbNome);
		
		txtNome = new JTextField();
		txtNome.setSize(390, 20);
		txtNome.setLocation(5, 45);
		panel.add(txtNome);
		
		//Endereço
		lbEndereco = new JLabel("Endereço");
		lbEndereco.setSize(390, 20);
		lbEndereco.setLocation(5, 65);
		panel.add(lbEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setSize(390, 20);
		txtEndereco.setLocation(5, 85);
		panel.add(txtEndereco);
		
		//Numero
		lbNumero = new JLabel("Numero");
		lbNumero.setSize(180, 20);
		lbNumero.setLocation(5, 105);
		panel.add(lbNumero);
		
		txtNumero = new JTextField();
		txtNumero.setSize(180, 20);
		txtNumero.setLocation(5, 125);
		panel.add(txtNumero);
		
		//Bairro
		lbBairro = new JLabel("Bairro");
		lbBairro.setSize(200, 20);
		lbBairro.setLocation(195, 105);
		panel.add(lbBairro);
		
		txtBairro = new JTextField();
		txtBairro.setSize(200, 20);
		txtBairro.setLocation(195, 125);
		panel.add(txtBairro);
		
		//Cidade
		lbCidade = new JLabel("Cidade");
		lbCidade.setSize(180, 20);
		lbCidade.setLocation(5, 145);
		panel.add(lbCidade);
		
		txtCidade = new JTextField();
		txtCidade.setSize(180, 20);
		txtCidade.setLocation(5, 165);
		panel.add(txtCidade);
		
		//Estado
		lbEstado = new JLabel("Estado");
		lbEstado.setSize(200, 20);
		lbEstado.setLocation(195, 145);
		panel.add(lbEstado);
		
		ufs = new String[]{
				"AC","AL","AP","AM","BA",
				"CE","DF","ES","GO","MA",
				"MT","MS","MG","PR","PB",
				"PA","PE","PI","RJ","RN",
				"RS","RO","RR","SC","SE",
				"SP","TO"
		};
		
		cbEstado = new JComboBox(ufs);
		cbEstado.setSize(200, 20);
		cbEstado.setLocation(195, 165);
		
		panel.add(cbEstado);
		
		
		
		
		try {
			//Telefone
			lbTelefone = new JLabel("Telefone");
			lbTelefone.setSize(180, 20);
			lbTelefone.setLocation(5, 185);
			panel.add(lbTelefone);
			
			formater = new MaskFormatter("(##) ####-####");
			JFormattedTextField txtTelefone = new JFormattedTextField(formater);
			txtTelefone.setSize(180, 20);
			txtTelefone.setLocation(5, 205);
			panel.add(txtTelefone);
			
			
			//Data
			lbDataNasc = new JLabel("Data de Nascimento.");
			lbDataNasc.setLocation(195, 185);
			lbDataNasc.setSize(200,20);
			panel.add(lbDataNasc);
			
			formater = new MaskFormatter("##/##/####");
			txtDateNasc = new JFormattedTextField(formater);
			txtDateNasc.setSize(200, 20);
			txtDateNasc.setLocation(195, 205);
			panel.add(txtDateNasc);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Especialidade
		lbEspecialidade = new JLabel("Especialidades");
		lbEspecialidade.setSize(180, 20);
		lbEspecialidade.setLocation(5, 225);
		panel.add(lbEspecialidade);
		
		especialidades = new String[]{
				"Direito","Informatica",
				"Matematica", "Medicina"
		};
		
		cbEspecialidades = new JComboBox(especialidades);
		cbEspecialidades.setSize(180, 20);
		cbEspecialidades.setLocation(5, 245);
		
		panel.add(cbEspecialidades);
		
		
		//Titulo
		lbTitulo = new JLabel("Titulo");
		lbTitulo.setSize(200, 20);
		lbTitulo.setLocation(195, 225);
		panel.add(lbTitulo);
		
		titulos = new String[]{
				"Especialista Lato Sensu","Mestrado",
				"Doutorado"
		};
		
		cbTitulo = new JComboBox(titulos);
		cbTitulo.setSize(200, 20);
		cbTitulo.setLocation(195, 245);
		
		panel.add(cbTitulo);
			
		
		
		//
		
		JPanel panelTable = new JPanel();
		panelTable.setSize(800,300);
		panelTable.setLayout(null);
		addBottom(panelTable, panel);
		
		
		lbDisciplina = new JLabel("Nome da Disciplina");
		lbDisciplina.setSize(400,20);
		int x = this.getSize().width / 2;
		
		lbDisciplina.setLocation(x,20);
		panel.add(lbDisciplina);
		
		
		List<Professor> list = Professor.list();
		ProfessorTableModel dm = new ProfessorTableModel(list);
		table = new JTable();
		table.setModel(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	ProfessorTableModel dm = (ProfessorTableModel) table.getModel();
		        	Professor p = dm.getItemAt(row);
		        	
		        	lbID.setText("ID: "+p.getId()+"");
		        	txtNome.setText(p.getNome());
		        	txtNome.setEnabled(false);
		        	
		        	txtBairro.setText(p.getBairro());
		        	txtBairro.setEnabled(false);
		        	
		        	txtCidade.setText(p.getCidade());
		        	txtCidade.setEnabled(false);
		        	
		        	txtDateNasc.setText(p.getDataNascimento());
		        	txtDateNasc.setEnabled(false);
		        	
		        	txtEndereco.setText(p.getEndereco());
		        	txtEndereco.setEnabled(false);
		        	
		        	txtNumero.setText(p.getNumero()+"");
		        	txtNumero.setEnabled(false);
		        	
		        	for(int i =0;  i < ufs.length; i++){
		        		String uf = ufs[i];
						if(uf.equals(p.getEstado())){
							cbEstado.setSelectedIndex(i);
						}
					}
		        	
		        	for(int i =0;  i < especialidades.length; i++){
		        		String esp = especialidades[i];
						if(esp.equals(p.getEspecialidades())){
							cbEspecialidades.setSelectedIndex(i);
						}
					}
		        	
		        	for(int i =0;  i < titulos.length; i++){
		        		String titulo = titulos[i];
						if(titulo.equals(p.getTitulo())){
							cbTitulo.setSelectedIndex(i);
						}
					}
		        	
		        	List<Disciplina> lsDisc = Disciplina.list();
		        	Random r = new Random();
		        	Disciplina d = lsDisc.get(r.nextInt(lsDisc.size()));
		        	
		        	System.out.println(d.getNome());
		        	
		        	lbDisciplina.setText("Nome da Disciplina " + d.getNome());
		        	

		        }
		    }
		});
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(790, 250);
		jscpane.setLocation(5,30);
		panelTable.add(jscpane);
		
		
		add(panelTable);
		add(panel);
	}
}
