package br.com.unip.alpoo;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.List;

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
import br.com.unip.alpoo.disciplina.DisciplinaTableModel;
import br.com.unip.alpoo.model.Curso;
import br.com.unip.alpoo.model.Disciplina;

public class TelaCursoDisciplina extends FrameALPO {
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
	private JLabel lbCdCurso;
	private JTextField txtCdCurso;
	private JLabel lbID;
	private JLabel lbAulas;
	private JRadioButton rd1;
	private JRadioButton rd2;
	private JRadioButton rd3;
	private JRadioButton rd4;
	private JRadioButton rd5;
	private JRadioButton rd6;
	private ButtonGroup groupCarga;
	private JScrollPane jscpane;
	private JLabel lbNomeCurso;
	private JTextField txtNomeCurso;
	
	
	public TelaCursoDisciplina(Component parent){
		setTitle("Mostrar Curso/Disciplina");
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
		lbID = new JLabel("ID");
		lbID.setSize(200, 20);
		lbID.setLocation(5,5);
		panel.add(lbID);
		
		
		//NOME
		lbNome = new JLabel("Nome");
		setDefaultSize(lbNome);
		addBottom(lbNome, lbID);
		panel.add(lbNome);
		
		txtNome = new JTextField();
		setDefaultSize(txtNome);
		addBottom(txtNome, lbNome);
		panel.add(txtNome);
		
		
		//AULAS SEMANA
		lbAulas = new JLabel("Aulas por Semana");
		setDefaultSize(lbAulas,2);
		addBottom(lbAulas, txtNome);
		panel.add(lbAulas);
		
		//Options
		rd1 = new JRadioButton("1");
		setDefaultSize(rd1, 6);
		addBottom(rd1, lbAulas);
		panel.add(rd1);
		
		rd2 = new JRadioButton("2");
		setDefaultSize(rd2, 6);
		addBottom(rd2, lbAulas,6);
		panel.add(rd2);
		
		rd3 = new JRadioButton("3");
		setDefaultSize(rd3, 6);
		addBottom(rd3, rd1);
		panel.add(rd3);
		
		rd4 = new JRadioButton("4");
		setDefaultSize(rd4, 6);
		addBottom(rd4, rd1,6);
		panel.add(rd4);
		
		rd5 = new JRadioButton("5");
		setDefaultSize(rd5, 6);
		addBottom(rd5, rd3);
		panel.add(rd5);
		
		rd6 = new JRadioButton("6");
		setDefaultSize(rd6, 6);
		addBottom(rd6, rd3,6);
		panel.add(rd6);
		
		groupCarga = new ButtonGroup();
		groupCarga.add(rd1);
		groupCarga.add(rd2);
		groupCarga.add(rd3);
		groupCarga.add(rd4);
		groupCarga.add(rd5);
		groupCarga.add(rd6);
		
		
		
		
		//CARGA HORARIA
		lbCarga = new JLabel("Carga Horaria");
		setDefaultSize(lbCarga,2);
		addBottom(lbCarga, txtNome,2);
		panel.add(lbCarga);
		
		txtCarga = new JTextField();
		setDefaultSize(txtCarga,2);
		addBottom(txtCarga, lbCarga,2);
		panel.add(txtCarga);
		
		//CODIGO CURSO
		lbCdCurso = new JLabel("Codigo do Curso");
		setDefaultSize(lbCdCurso,2);
		addBottom(lbCdCurso, txtCarga,2);
		panel.add(lbCdCurso);
		
		txtCdCurso = new JTextField();
		setDefaultSize(txtCdCurso,2);
		addBottom(txtCdCurso, lbCdCurso,2);
		panel.add(txtCdCurso);
		
		
		lbNomeCurso= new JLabel("Nome do Curso");
		setDefaultSize(lbNomeCurso,2);
		addBottom(lbNomeCurso, txtCdCurso,2);
		panel.add(lbNomeCurso);
		
		txtNomeCurso = new JTextField();
		setDefaultSize(txtNomeCurso,2);
		addBottom(txtNomeCurso, lbNomeCurso,2);
		panel.add(txtNomeCurso);
		
		//CD curso
		
		
		//Nome do curso
		
		
		//
		
		List<Disciplina> list = Disciplina.list();
		DisciplinaTableModel dm = new DisciplinaTableModel(list);
		table = new JTable();
		table.setModel(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	DisciplinaTableModel dm = (DisciplinaTableModel) table.getModel();
		        	Disciplina d = dm.getItemAt(row);
		       
		        	lbID.setText("ID: "+d.getId()+"");
		        	txtNome.setText(d.getNome());
		        	txtNome.setEnabled(false);
		        	
		        	
		        	txtCdCurso.setText(d.getCodCurso());
		        	txtCdCurso.setEnabled(false);
		        	
		        	txtCarga.setText(d.getCargaHorario());
		        	txtCarga.setEnabled(false);
		        	
		        	rd1.setSelected(false);
		        	rd2.setSelected(false);
		        	rd3.setSelected(false);
		        	rd4.setSelected(false);
		        	rd5.setSelected(false);
		        	rd6.setSelected(false);
		        	
		        	switch(d.getAulasPorSemana()){
			        	case "1":
			        		rd1.setSelected(true);
			        		break;
			        	case "2":
			        		rd2.setSelected(true);
			        		break;
			        	case "3":
			        		rd3.setSelected(true);
			        		break;
			        	case "4":
			        		rd4.setSelected(true);
			        		break;
			        	case "5":
			        		rd5.setSelected(true);
			        		break;
			        	case "6":
			        		rd6.setSelected(true);
			        		break;
		        	}
		        	
		        	List<Curso> lsCurso = Curso.getListCursos();
		        	
		        	if(d.getCodCursoNumber() > lsCurso.size()){
		        		//Não faz nada
		        	}else{
		        		int index = d.getCodCursoNumber();
		        		index = index - 1;
		        		Curso c = lsCurso.get(index);
		        		txtNomeCurso.setText(c.getNome());
		        		txtNomeCurso.setEnabled(false);
		        	}
		        	       	
		        	
		        	

		        }
		    }
		});
		jscpane = new JScrollPane(table);
		jscpane.setSize(390, 250);
		addBottom(jscpane, rd5);
		jscpane.setLocation(jscpane.getLocation().x, jscpane.getLocation().y + 40);
		panel.add(jscpane);
		
		//
				
		add(panel);
	}
}
