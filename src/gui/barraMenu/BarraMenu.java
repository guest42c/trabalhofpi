package gui.barraMenu;

import gui.InternalFrame;
import gui.panels.PainelImagem;
import image.Imagem;
import image.ImagemIO;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BarraMenu extends JMenuBar implements MenuConstantes, ActionListener{
	
	private PainelImagem painelImagemOriginal, painelImagemModificada;
	private InternalFrame imagemFrameOriginal, imagemInternoModificado;
	private Imagem imagemOriginal, imagemModificada;
	private boolean imagemEmEscalaCinza = false;
	
	public JPanel getPainelImagemOriginal() {
		return painelImagemOriginal;
	}

	public void setPainelImagemOriginal(PainelImagem painelImagemOriginal) {
		this.painelImagemOriginal = painelImagemOriginal;
	}

	public JPanel getPainelImagemModificada() {
		return painelImagemModificada;
	}

	private void setPainelImagemModificada(PainelImagem painelImagemModificada) {
		this.painelImagemModificada = painelImagemModificada;
		imagemEmEscalaCinza = false;
	}
	
	public InternalFrame getImagemFrameOriginal() {
		return imagemFrameOriginal;
	}

	private void setImagemFrameOriginal(InternalFrame imagemFrameOriginal) {
		this.imagemFrameOriginal = imagemFrameOriginal;
	}

	public InternalFrame getImagemInternoModificado() {
		return imagemInternoModificado;
	}

	public void setImagemInternoModificado(InternalFrame imagemInternoModificado) {
		this.imagemInternoModificado = imagemInternoModificado;
	}

	private JMenu arquivoMenu(){
		Menu arquivoMenu = new Menu(FILE, 'F');
		
		MenuItem abrirMenuItem = new MenuItem(OPEN, 'O', ActionEvent.CTRL_MASK);
		abrirMenuItem.addActionListener(this);
		arquivoMenu.add(abrirMenuItem);
		
		MenuItem salvarOriginalMenuItem = new MenuItem(SAVE_ORIGINAL_IMAGE, 'S', ActionEvent.CTRL_MASK);
		salvarOriginalMenuItem.addActionListener(this);
		arquivoMenu.add(salvarOriginalMenuItem);
		
		MenuItem salvarModificadoMenuItem = new MenuItem(SAVE_MODIFIED_IMAGE, 'N', ActionEvent.CTRL_MASK);
		salvarModificadoMenuItem.addActionListener(this);
		arquivoMenu.add(salvarModificadoMenuItem);
		
		MenuItem sairMenuItem = new MenuItem(EXIT, 'E', ActionEvent.CTRL_MASK);
		sairMenuItem.addActionListener(this);
		arquivoMenu.add(sairMenuItem);
		
		return arquivoMenu;
	}
	
	private JMenu editarMenu(){
		Menu editarMenu = new Menu(EDIT, 'E');
		
		MenuItem mostrarOriginalMenuItem = new MenuItem(SHOW_ORIGINAL_IMAGE, 'I', ActionEvent.CTRL_MASK);
		mostrarOriginalMenuItem.addActionListener(this);
		editarMenu.add(mostrarOriginalMenuItem);
		
		MenuItem mostrarModificadoMenuItem = new MenuItem(SHOW_MODIFIED_IMAGE, 'M',ActionEvent.CTRL_MASK);
		mostrarModificadoMenuItem.addActionListener(this);
		editarMenu.add(mostrarModificadoMenuItem);
				
		return editarMenu;
	}
	
	private JMenu operacoesMenu(){
		Menu operacoesMenu = new Menu(OPERATIONS, 'O');
		
		MenuItem copiarMenuItem = new MenuItem(COPY, 'C', ActionEvent.CTRL_MASK);
		copiarMenuItem.addActionListener(this);
		operacoesMenu.add(copiarMenuItem);
		
		MenuItem espelhamentoHorizontalMenuItem = new MenuItem(HORIZONTAL_FLIP, 'H',ActionEvent.CTRL_MASK);
		espelhamentoHorizontalMenuItem.addActionListener(this);
		operacoesMenu.add(espelhamentoHorizontalMenuItem);
		
		MenuItem espelhamentoVerticalMenuItem = new MenuItem(VERTICAL_FLIP, 'V',ActionEvent.CTRL_MASK);
		espelhamentoVerticalMenuItem.addActionListener(this);
		operacoesMenu.add(espelhamentoVerticalMenuItem);
		
		MenuItem escalaCinzaMenuItem = new MenuItem(GRAY_SCALE, 'G', ActionEvent.CTRL_MASK);
		escalaCinzaMenuItem.addActionListener(this);
		operacoesMenu.add(escalaCinzaMenuItem);
		
		MenuItem quantizacaoMenuItem = new MenuItem(QUANTIZATION, 'Q',ActionEvent.CTRL_MASK);
		quantizacaoMenuItem.addActionListener(this);
		operacoesMenu.add(quantizacaoMenuItem);
		
		return operacoesMenu;
	}
	
	public BarraMenu(InternalFrame imagemFrameOriginal, InternalFrame imagemInternoModificado){
		
		this.setImagemFrameOriginal(imagemFrameOriginal);
		this.setImagemInternoModificado(imagemInternoModificado);
		this.setPainelImagemOriginal((PainelImagem)imagemFrameOriginal.getContentPane());
		this.setPainelImagemModificada((PainelImagem)imagemInternoModificado.getContentPane());
		
		JMenu arquivoMenu = arquivoMenu();
		this.add(arquivoMenu);
		
		JMenu editarMenu = editarMenu();
		this.add(editarMenu);
		
		JMenu operacoesMenu = operacoesMenu();
		this.add(operacoesMenu);
	}

	private void abrirArquivo() throws IOException{
		JFileChooser abrirArquivo = new JFileChooser();
		int returnVal = abrirArquivo.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	String caminhoArquivo = abrirArquivo.getSelectedFile().getAbsolutePath();
	    	BufferedImage imagem = ImagemIO.abrirImage(caminhoArquivo);
	    	Imagem imagemAberta = new Imagem(imagem);
	    	this.painelImagemOriginal.setImagemDoPainel(imagemAberta);
	    	this.imagemFrameOriginal.pack();
	    	this.imagemOriginal = imagemAberta;
		    System.gc();
		}

	}
	
	public void salvarArquivo(PainelImagem painelImage){
		
		JFileChooser salvarArquivo = new JFileChooser();

		int returnVal = salvarArquivo.showSaveDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	String refencia = salvarArquivo.getSelectedFile().getAbsolutePath();
			ImagemIO.salvarImagem(refencia, painelImage.getImagemDoPainel().retornaBufferedImage());

		}	
	}
	
	private void selecionaFrameInterno(InternalFrame frameInterno){
		frameInterno.setVisible(true);
			try {
				frameInterno.setSelected(true);
			} catch (PropertyVetoException e1) {
			}
	}

	private void copiarImagem() {
	    Imagem imagemCopiada = new Imagem(painelImagemOriginal.getImagemDoPainel());
	    this.imagemEmEscalaCinza = false;
    	this.painelImagemModificada.setImagemDoPainel(imagemCopiada);
    	this.imagemInternoModificado.pack();
        System.gc();
    }
	
	private void espelhamentoHorizontal(PainelImagem painelImagem) {
		Imagem imagem = painelImagem.getImagemDoPainel();
		imagem.espelhamentoHorizontal();
		imagemFrameOriginal.repaint();
	}

	private void espelhamentoVertical(PainelImagem painelImagem) {
		Imagem imagem = painelImagem.getImagemDoPainel();
		imagem.espelhamentoVertical();
		imagemFrameOriginal.repaint();
	}
	
	private void escalaCinza(PainelImagem painelImagem) {
		Imagem imagem = painelImagem.getImagemDoPainel();
		imagem.luminancia();
		this.imagemEmEscalaCinza = true;
		imagemInternoModificado.repaint();
	}
	
	
	private void quantizacao(PainelImagem painelImagem) {
		Imagem imagem = painelImagem.getImagemDoPainel();
		final int numeroMinimoTons = 2, numeroMaximoTons = 256;
		try{
			int quantidadeTons = Integer.parseInt(JOptionPane.showInputDialog(this, QUANTIZATION_MESSAGE, QUANTIZATION, JOptionPane.QUESTION_MESSAGE));
			if(numeroMinimoTons > quantidadeTons || quantidadeTons > numeroMaximoTons){
				throw new Exception("Teste");
			}
			imagem.quantizacao(quantidadeTons);
		    imagemInternoModificado.repaint();	
		}catch(NumberFormatException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, NUMBER_FORMAT_EXCPETION_MESSAGE, ERROR_TITLE, 
					JOptionPane.ERROR_MESSAGE);	
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,  "Please, digit a numbers in the field between " +
					""+numeroMinimoTons+" and "+numeroMaximoTons+".", ERROR_TITLE,JOptionPane.ERROR_MESSAGE);	
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent evento) {
		 String nomeEvento = evento.getActionCommand();
		 if(nomeEvento.equals(OPEN)){
			 try {
				 abrirArquivo();
				Dimension dimensaoImagem = imagemFrameOriginal.getSize();
				this.imagemFrameOriginal.setMaximumSize(dimensaoImagem); 
				this.imagemFrameOriginal.setVisible(true);
				this.imagemFrameOriginal.setSelected(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else if(nomeEvento.equals(SAVE_ORIGINAL_IMAGE) && 
				 painelImagemOriginal.getImagemDoPainel() != null){
			 salvarArquivo(painelImagemOriginal);
		 }else if(nomeEvento.equals(SAVE_MODIFIED_IMAGE) && 
				 painelImagemModificada.getImagemDoPainel() != null){
			 salvarArquivo(painelImagemModificada);
		 }else if(nomeEvento.equals(EXIT)){
			 System.exit(0);
		 }else if(nomeEvento.equals(SHOW_ORIGINAL_IMAGE) && painelImagemOriginal.getImagemDoPainel() != null){
			 selecionaFrameInterno(imagemFrameOriginal);
		 }else if(nomeEvento.equals(SHOW_MODIFIED_IMAGE) && painelImagemModificada.getImagemDoPainel() != null){
			 selecionaFrameInterno(imagemInternoModificado);
		}else if(nomeEvento.equals(COPY) && painelImagemOriginal.getImagemDoPainel() != null){
			copiarImagem();
			Dimension dimensaoImagem = imagemInternoModificado.getSize();
			this.imagemInternoModificado.setMaximumSize(dimensaoImagem); 
			this.imagemInternoModificado.setVisible(true);
			try {
				this.imagemInternoModificado.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(nomeEvento.equals(HORIZONTAL_FLIP) && painelImagemOriginal.getImagemDoPainel() != null){
			espelhamentoHorizontal(painelImagemOriginal);
		}else if(nomeEvento.equals(VERTICAL_FLIP) && painelImagemOriginal.getImagemDoPainel() != null){
			espelhamentoVertical(painelImagemOriginal);
		}else if(nomeEvento.equals(GRAY_SCALE) && painelImagemModificada.getImagemDoPainel() != null){
			escalaCinza(painelImagemModificada);
		}else if(nomeEvento.equals(QUANTIZATION) && painelImagemModificada.getImagemDoPainel() != null
				 && this.imagemEmEscalaCinza){
			quantizacao(painelImagemModificada);
		}
	}

}
