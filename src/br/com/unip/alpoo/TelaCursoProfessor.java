package br.com.unip.alpoo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.unip.alpoo.FrameALPO;
import br.com.unip.alpoo.curso.MostrarCursoTableModel;
import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Professor;

public class TelaCursoProfessor extends FrameALPO {
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
	private JPanel panel;
	private Curso c;
	private JLabel lbNomeProf;
	private JLabel lbEspecilidade;
	private JLabel lbTitulo;
	
	
	public TelaCursoProfessor(Component parent){
		setTitle("Mostrar Curso/Professor");
		setSize(400,500);
		setResizable(false);
		setLocationRelativeTo(parent);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		panel = new JPanel();
		panel.setSize(400,300);
		panel.setLayout(null);

		//ID	
		lbId = new JLabel("ID");
		lbId.setSize(390, 20);
		lbId.setLocation(5,5);
		panel.add(lbId);
		
			
		txtNome = new JTextField();
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

		lbNome = new JLabel("Nome: ");
		lbNome.setSize(200, 200);
		panel.add(lbNome);
		
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
		//
		
		lbNomeProf = new JLabel("Nome do Professor");
		lbNomeProf.setSize(400,20);
		lbNomeProf.setLocation(5, 150);
		panel.add(lbNomeProf);
		
		lbEspecilidade = new JLabel("Especialidade");
		lbEspecilidade.setSize(200,20);
		addBottom(lbEspecilidade, lbNomeProf);
		panel.add(lbEspecilidade);
		
		lbTitulo = new JLabel("Titulo");
		lbTitulo.setSize(400, 20);
		addBottom(lbTitulo, lbEspecilidade);
		panel.add(lbTitulo);
			
		
		//
		
		List<Curso> list = Curso.getListCursos();
		MostrarCursoTableModel dm = new MostrarCursoTableModel(list);
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
		        	System.out.println(c.getNome());;
		        	
		        	txtNome.setText(c.getNome());
		        	txtNome.setEnabled(false);
		        	lbId.setText("ID "+ c.getId());
		        	
		        	txtCarga.setText(c.getCargaHoraria()+"");
		        	txtCarga.setEnabled(false);
		        	
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
		        	
		        	Random r = new Random();
		        	List<Professor> l = Professor.list();
		        	Professor p = l.get(r.nextInt(l.size()));
		        	lbNomeProf.setText("Nome do Professor: "+p.getNome());
		        	lbEspecilidade.setText("Especialidade: "+p.getEspecialidades());
		        	lbTitulo.setText("Titulo: "+p.getTitulo());
		        	
		        	
		        	
		        	

		        }
		    }
		});
		
		JScrollPane jscpane = new JScrollPane(table);
		jscpane.setSize(390, 250);
		addBottom(jscpane, lbTitulo);
		jscpane.setLocation(jscpane.getLocation().x, jscpane.getLocation().y+10);
		panel.add(jscpane);
		
		//
		
		
		add(panel);
	}
}
