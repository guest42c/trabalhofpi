package gui;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import gui.barraMenu.BarraMenu;
import gui.panels.PainelImagem;

public class MainClass {

	public static void main(String[] args) {
		PainelImagem imagemOriginalPainel = new PainelImagem(),
		             imagemModificadoPainel = new PainelImagem();
		Desktop desktop = new Desktop(imagemOriginalPainel,imagemModificadoPainel);
		BarraMenu barraMenu = new BarraMenu(desktop.getOriginalFrameInterno() , 
				desktop.getModificadoFrameInterno());
		Frame framePrincipal = new Frame(barraMenu,desktop);
	}
}
