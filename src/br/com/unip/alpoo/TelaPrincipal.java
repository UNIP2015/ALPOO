package br.com.unip.alpoo;
import java.awt.Color;
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

import br.com.unip.alpoo.curso.TelaAlterarCurso;
import br.com.unip.alpoo.curso.TelaCurso;
import br.com.unip.alpoo.curso.TelaExcluirCurso;
import br.com.unip.alpoo.curso.TelaMostrarDisciplina;
import br.com.unip.alpoo.disciplina.TelaAlterarDisciplina;
import br.com.unip.alpoo.disciplina.TelaDisciplina;
import br.com.unip.alpoo.disciplina.TelaExcluirDisciplina;
import br.com.unip.alpoo.professor.TelaAlterarProfessor;
import br.com.unip.alpoo.professor.TelaExcluirProfessor;
import br.com.unip.alpoo.professor.TelaMostrarProfessor;
import br.com.unip.alpoo.professor.TelaProfessor;


public class TelaPrincipal extends JFrame{
	private JFrame reference;
	
	public TelaPrincipal() {
		setTitle("JAVA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		reference = this;
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400,300);
		panel.setLocation(0,0);
		panel.setBackground(Color.red); 
		
		JMenuItem m1 = new JMenuItem("Curso");
		m1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaCurso(reference);
				
			}
		});
		
		JMenuItem m2 = new JMenuItem("Professor");
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
				new TelaMostrarDisciplina(reference);
				
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
		
		JMenuItem mAlterarCurso = new JMenuItem("Alterar Curso");
		mAlterarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAlterarCurso(reference);		
			}
		});
		
		JMenuItem mExcluirCurso = new JMenuItem("Excluir Curso");
		mExcluirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirCurso(reference);		
			}
		});
		
		JMenuItem mAlterarProfessor = new JMenuItem("Alterar Professor");
		mAlterarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAlterarProfessor(reference);		
			}
		});
		
		JMenuItem mExcluirProfessor = new JMenuItem("Excluir Professor");
		mExcluirProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirProfessor(reference);		
			}
		});
		
		JMenuItem mAlterarDisciplina = new JMenuItem("Alterar Disciplina");
		mAlterarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaAlterarDisciplina(reference);		
			}
		});
		
		JMenuItem mExcluirDisciplina = new JMenuItem("Excluir Disciplina");
		mExcluirDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirDisciplina(reference);		
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
		
		//Cadastrar
		JMenu mnManutencao = new JMenu("Manuten��o");
		mnManutencao.add(mAlterarCurso);
		mnManutencao.add(mExcluirCurso);
		mnManutencao.addSeparator();
		mnManutencao.add(mAlterarProfessor);
		mnManutencao.add(mExcluirProfessor);
		mnManutencao.addSeparator();
		mnManutencao.add(mAlterarDisciplina);
		mnManutencao.add(mExcluirDisciplina);
			
		JMenu mnSair = new  JMenu("Sair");
		mnSair.add(mnSairItem);
		
		JMenuBar bar = new JMenuBar();
		bar.setSize(400, 30);
		bar.setLocation(0,0);
		bar.add(mnCadastrar);
		bar.add(mnMostrar);
		bar.add(mnManutencao);
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
