package gui;

import java.awt.Point;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;

public class Desktop extends JDesktopPane{
	
	private Point originalPoint, modifieddPoint;
	private JPanel originalImage, modifiedImage;
	private InternalFrame originalFrameInterno, modificadoFrameInterno;
	
	public JPanel getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(JPanel originalImage) {
		this.originalImage = originalImage;
	}

	public JPanel getModifiedImage() {
		return modifiedImage;
	}
	
	public InternalFrame getOriginalFrameInterno() {
		return originalFrameInterno;
	}

	public void setOriginalFrameInterno(InternalFrame originalFrameInterno) {
		this.originalFrameInterno = originalFrameInterno;
	}

	public InternalFrame getModificadoFrameInterno() {
		return modificadoFrameInterno;
	}

	public void setModificadoFrameInterno(InternalFrame modificadoFrameInterno) {
		this.modificadoFrameInterno = modificadoFrameInterno;
	}

	public void setModifiedImage(JPanel modifiedImage) {
		this.modifiedImage = modifiedImage;
	}

	public Desktop(JPanel imagemOriginal, JPanel imagemModificada){
		this.setOriginalImage(imagemOriginal);
		this.setModifiedImage(imagemModificada);
		originalFrameInterno = new InternalFrame("Original Image", 
				imagemOriginal);
		originalFrameInterno.setLocation(0, 30);
		modificadoFrameInterno = new InternalFrame("Modified Image", 
			    imagemModificada);
		modificadoFrameInterno.setLocation(400, 30);
		this.add(modificadoFrameInterno);
		this.add(originalFrameInterno);
	}
	
}
