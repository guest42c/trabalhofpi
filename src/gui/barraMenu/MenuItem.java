package gui.barraMenu;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * UFRGS - Universidade Federal do Rio Grande do Sul
 * Instituto de Informática - UFRGS 
 * Title:Questions, Options and Criteria
 * @author Rafael Hansen da Silva e Marcius Sthephanie Santiago Vieira
 * e-mail: rhsilva@inf.ufrgs.br, mssvieira@inf.ufrgs.br 
 */

public class MenuItem extends JMenuItem{

	public MenuItem(String nome, char mnemonico){
		super(nome);
		setMnemonic(mnemonico);
	}
	
	public MenuItem(String nome, char mnemonico, int primeiraTecla){
		super(nome);
		setMnemonic(mnemonico);
		setAccelerator(KeyStroke.getKeyStroke(
				mnemonico, primeiraTecla));
	}	
}
