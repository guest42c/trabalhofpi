package gui.barraMenu;

import javax.swing.Action;
import javax.swing.JMenu;

/**
 * UFRGS - Universidade Federal do Rio Grande do Sul
 * Instituto de Informática - UFRGS 
 * Title: 
 * @author Rafael Hansen da Silva
 * e-mail: rhsilva@inf.ufrgs.br
 */


public class Menu extends JMenu{

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(Action acao) {
		super(acao);
		// TODO Auto-generated constructor stub
	}

	public Menu(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String name, char mnemonico) {
		super(name);
		setMnemonic(mnemonico);
		// TODO Auto-generated constructor stub
	}
}
