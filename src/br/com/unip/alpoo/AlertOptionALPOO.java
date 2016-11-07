package br.com.unip.alpoo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AlertOptionALPOO implements ActionListener {
	private String msg;
	public final static int SAVE = 1;
	public final static int EDIT = 2;
	public final static int DELETE = 3;
	
	private Component c;
	
	
	private int option;
	public AlertOptionALPOO(int option, Component c) {
		this.option = option;
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.option == AlertOptionALPOO.SAVE){
			JOptionPane.showMessageDialog(c, "Registro salvo com sucesso");
		}else if(this.option == AlertOptionALPOO.EDIT){
			JOptionPane.showMessageDialog(c, "Registro alterado com sucesso");
		}else {
			JOptionPane.showMessageDialog(c, "Registro excluido com sucesso");
		}
		
	}

}
