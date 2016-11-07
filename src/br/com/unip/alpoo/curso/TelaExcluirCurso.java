package br.com.unip.alpoo.curso;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.unip.alpoo.AlertOptionALPOO;
import br.com.unip.alpoo.FrameALPO;
import br.com.unip.alpoo.dao.DAOCurso;
import br.com.unip.alpoo.model.Curso;


public class TelaExcluirCurso extends FrameALPO{ 
	private JTable table;
	private JRadioButton rdBacharel;
	private JRadioButton rdGestao;
	private JLabel lbTipoCurso;
	private JRadioButton rdOutros;
	private ButtonGroup groupRadio;
	private JLabel lbCarga;
	private JTextField txtCarga;
	private JLabel lbId;
	private JLabel lbNome;
	private DefaultListModel lista;
	
	private List<Curso> lsCursos;
	private int currentId;
	private Curso cursoSelected;
	private DAOCurso dao;

	public TelaExcluirCurso(Component parent) {
		setTitle("Excluir Curso");
		setSize(400,720);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setSize(400,700);
		panel.setLayout(null);
		
		//ID	
		lbId = new JLabel("ID");
		lbId.setSize(390, 20);
		lbId.setLocation(5,5);
		panel.add(lbId);
		
		//NOME
		lbNome = new JLabel("Nome");
		lbNome.setSize(390, 20);
		lbNome.setLocation(5,25);
		panel.add(lbNome);
	
		JTextField txtNome = new JTextField();
		txtNome.setSize(390,20);
		txtNome.setLocation(5, 45);
		
		String[] cursos = new String[]{
				
		};
		
		lista = new DefaultListModel();
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
		lbTipoCurso = new JLabel("Tipo de Curso");
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
		lbCarga = new JLabel("Carga Horaria");
		lbCarga.setSize(200, 20);
		lbCarga.setLocation(245, 105);
		panel.add(lbCarga);
		
		txtCarga = new JTextField();
		txtCarga.setSize(115,20);
		txtCarga.setLocation(245, 125);
		panel.add(txtCarga);
		
		dao = new DAOCurso();
		
		Button confirmButton = new Button("Excluir");
		confirmButton.setSize(100, 30);
		confirmButton.setLocation(100, 250);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dao.delete(cursoSelected);
				JOptionPane.showMessageDialog(null, "Registro deletado com sucesso");

				
			}
		});
		panel.add(confirmButton);
		
		
//		List<Curso> list = Curso.getListCursos();
		lsCursos = dao.all();
		MostrarCursoTableModel dm = new MostrarCursoTableModel(lsCursos);
		table = new JTable();
		table.setModel(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	MostrarCursoTableModel dm = (MostrarCursoTableModel) table.getModel();
		        	Curso c = dm.getItemAt(row);
		        	cursoSelected = c;
		        	System.out.println(c.getNome());;
		        	
		        	lbNome.setText(c.getNome());
		        	lbNome.setEnabled(false);
		        	lbId.setText("ID "+ c.getId());
		        	
		        	lbCarga.setText(c.getCargaHoraria()+"");
		        	lbCarga.setEnabled(false);
		        	
		        	int size = lista.getSize();
		        	
		        	rdBacharel.setSelected(false);
		        	rdGestao.setSelected(false);
		        	rdOutros.setSelected(false);
		        	
		        	switch(c.getTipo()){
		        		case "Bacharel" :
		        			rdBacharel.setSelected(true);
		        			break;
		        		case "Gestão" :
		        			rdGestao.setSelected(true);
		        			break;
		        		case "Outros" :
		        			rdOutros.setSelected(true);
		        			break;
		        		
		        	}
		        	
		        	for(int i =0; i < size; i++){
		        		String nome = lista.get(i).toString();
		        		if(nome.equals(c.getNome())){
		        			lbNome.setText("Nome: "+c.getNome());
		        			
		        		}
		        		
		        	}
		        	
		        	
		        	

		        }
		    }
		});
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(390, 250);
		
		addBottom(jscpane,cbNome);
		jscpane.setLocation(jscpane.getLocation().x, jscpane.getLocation().y + 45);
		panel.add(jscpane);
		
		add(panel);	
	}

	
}
