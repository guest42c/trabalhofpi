package gui.panels;

import image.Imagem;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PainelImagem extends JPanel {


	private Imagem imagemDoPainel, imagemDesenha;
	private Dimension dimensaoPainel = new Dimension();
	private final Dimension dimensaoPadrao = new Dimension(640,480);
	
	public Imagem getImagemDoPainel() {
		return imagemDoPainel;
	}

	public void setImagemDoPainel(Imagem imagemDoPainel) {
		this.imagemDoPainel = imagemDoPainel;
		this.setDimensaoPainel(imagemDoPainel.getWidth(),imagemDoPainel.getHeight());
		Dimension dimensaoImagem = new Dimension (imagemDoPainel.getWidth(), imagemDoPainel.getHeight());
		this.getParent().setMaximumSize(dimensaoImagem);
		this.repaint();
	}

	public Dimension getDimensaoPainel() {
		return dimensaoPainel;
	}

	public void setDimensaoPainel(Dimension dimensaoPainel) {
		this.dimensaoPainel = dimensaoPainel;
		this.setPreferredSize(dimensaoPainel);
		this.revalidate();
	}
	
	public void setDimensaoPainel(double comprimento, double altura) {
		this.dimensaoPainel.setSize(comprimento, altura);
		this.setPreferredSize(dimensaoPainel);
		this.revalidate();
	}

	public Dimension getDimensaoPadrao() {
		return dimensaoPadrao;
	}

	public PainelImagem() {
		super();
		imagemDoPainel = null;
		this.setDimensaoPainel(dimensaoPadrao);
		// TODO Auto-generated constructor stub
	}
	
	public PainelImagem(Imagem imagemDoPainel) {
		super();
		this.imagemDoPainel = imagemDoPainel;
		this.setDimensaoPainel(imagemDoPainel.getWidth(),imagemDoPainel.getHeight());
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if (imagemDoPainel != null){
			g.drawImage(imagemDoPainel, 0, 0, null);  
		}
		else{
			g.fillRect(0,0,this.getWidth(),this.getHeight());  
		}
	}

}
