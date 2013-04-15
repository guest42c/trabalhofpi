package gui;

import gui.panels.PainelImagem;

import image.Imagem;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class InternalFrame extends JInternalFrame{
	
	private String janelaTitulo;

	public InternalFrame() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InternalFrame(String arg0, boolean arg1, boolean arg2, boolean arg3,
			boolean arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
		// TODO Auto-generated constructor stub
	}

	public InternalFrame(String arg0, boolean arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InternalFrame(String arg0, boolean arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

	public InternalFrame(String arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InternalFrame(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public InternalFrame(String titulo, JPanel painelImagem) {
		super(titulo);
		this.setContentPane(painelImagem);
		inicializaInternalFrame();
		// TODO Auto-generated constructor stub
	}
	
	public void inicializaInternalFrame(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.pack();
			this.setFocusable(true);
			this.setMaximizable(true);
			this.setClosable(true);
			this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	}

}
