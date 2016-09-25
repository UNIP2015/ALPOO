package br.com.unip.alpoo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import br.com.unip.alpoo.curso.TelaCurso;
import br.com.unip.alpoo.curso.TelaMostrarCurso;
import br.com.unip.alpoo.disciplina.TelaDisciplina;
import br.com.unip.alpoo.disciplina.TelaMostrarDisciplina;
import br.com.unip.alpoo.professor.TelaMostrarProfessor;
import br.com.unip.alpoo.professor.TelaProfessor;


public class TelaPrincipal extends JFrame{
	private JFrame reference;
	
	public TelaPrincipal() {
		setTitle("Caadastros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		reference = this;
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400,300);
		panel.setLocation(0,0);
		
		JMenuItem m1 = new JMenuItem("Curso");
		m1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaCurso(reference);
				
			}
		});
		
		JMenuItem m2 = new JMenuItem("Profesor");
		m2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaProfessor(reference);
				
			}
		});
		JMenuItem m3 = new JMenuItem("Disciplina");
		m3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaDisciplina(reference);
				
			}
		});
		
		///Botões de exibição do menu mostrar
		JMenuItem mnMostrarCursos = new JMenuItem("Cursos");
		mnMostrarCursos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaMostrarCurso(reference);
				
			}
		});
		
		JMenuItem mnMostrarProfessores = new JMenuItem("Professores");
		mnMostrarProfessores.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaMostrarProfessor(reference);
				
			}
		});
		
		JMenuItem mnMostrarDisciplinas = new JMenuItem("Disciplinas");
		mnMostrarDisciplinas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaMostrarDisciplina(reference);
				
			}
		});
		
		JMenuItem mnSairItem = new JMenuItem("Sair");
		mnSairItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int confirma = JOptionPane.showConfirmDialog(null, "Você deseja sair?");
				if(confirma == JOptionPane.OK_OPTION){
					System.exit(0);
				}
				
			}
		});
		
		
		//Cadastrar
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.add(m1);
		mnCadastrar.add(m2);
		mnCadastrar.add(m3);
		
		//Cadastrar
		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.add(mnMostrarCursos);
		mnMostrar.add(mnMostrarProfessores);
		mnMostrar.add(mnMostrarDisciplinas);
		mnMostrar.addSeparator();
			
		JMenu mnSair = new  JMenu("Sair");
		mnSair.add(mnSairItem);
		
		JMenuBar bar = new JMenuBar();
		bar.setSize(400, 30);
		bar.setLocation(0,0);
		bar.add(mnCadastrar);
		bar.add(mnMostrar);
		bar.add(mnSair);
		
		panel.add(bar);
		
		add(panel);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		try{
//			UIManager.setLookAndFeel(
//					"com.sun.java.swing.plaf.motif.MotifLookAndFeel"
//			);
			
		}catch(Exception e){
			//Handle exception
			System.out.println("Not loaded");
		}finally{
			new TelaPrincipal();
		}
		
	}
}
