package gui;

import java.awt.Dimension;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Frame extends JFrame{
	
	private JMenuBar barraMenu;
	private JDesktopPane dekstopPainel;
		
	public JDesktopPane getDekstopPainel() {
		
		return dekstopPainel;
	}

	public void setDekstopPainel(JDesktopPane dekstopPainel) {
		this.removeAll();
		this.dekstopPainel = dekstopPainel;
		this.add(this.dekstopPainel);
		this.dekstopPainel.revalidate();
	}

	private void inicializacaoFrame(){
		this.setTitle("Image Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		final Dimension dimensaoInicial = new Dimension(800,600);
		this.setMinimumSize(dimensaoInicial);
		this.setVisible(true);
	}
	
	public Frame (JMenuBar barraMenu, JDesktopPane dekstopPainel){
		this.setJMenuBar(barraMenu);
		this.add(dekstopPainel);
		inicializacaoFrame();
	}

}
