package image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class Imagem extends BufferedImage{

	public Imagem(ColorModel cm, WritableRaster raster,
			boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
		super(cm, raster, isRasterPremultiplied, properties);
		// TODO Auto-generated constructor stub
	}

	public Imagem(int width, int height, int imageType, IndexColorModel cm) {
		super(width, height, imageType, cm);
		// TODO Auto-generated constructor stub
	}

	public Imagem(int width, int height, int imageType) {
		super(width, height, imageType);
		// TODO Auto-generated constructor stub
	}
	
	public Imagem(BufferedImage bufferedImage) {
		super(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
		int comprimento = bufferedImage.getWidth(), altura = bufferedImage.getHeight();
		int vectorPixelsX[] = bufferedImage.getRGB(0,0,comprimento,altura,null,0,comprimento);
		this.setRGB(0, 0, comprimento, altura, vectorPixelsX, 0, comprimento);
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage retornaBufferedImage() {
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), Imagem.TYPE_INT_RGB);
	    int comprimento = this.getWidth(), altura = this.getHeight();
		int vectorPixelsX[] = this.getRGB(0,0,comprimento,altura,null,0,comprimento);
		bufferedImage.setRGB(0, 0, comprimento, altura, vectorPixelsX, 0, comprimento);
		return bufferedImage;
		// TODO Auto-generated constructor stub
	}
	
	public Imagem(Imagem imagem) {
		super(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_ARGB);
		int comprimento = imagem.getWidth(), altura = imagem.getHeight();
		int vectorPixelsX[] = imagem.getRGB(0,0,comprimento,altura,null,0,comprimento).clone();
		this.setRGB(0, 0, comprimento, altura, vectorPixelsX, 0, comprimento);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Utiliza a biblioteca do Java, NÃO é mais utilizado no projeto.
	 */
	public void espelhamentoHorizontalAntigo() {
		int comprimento = this.getWidth(), altura = this.getHeight();  
		Imagem imagemAuxiliar = new Imagem(this);
		Graphics2D g = this.createGraphics();  
		g.drawImage(imagemAuxiliar, 0, 0, comprimento, altura, comprimento, 0, 0, altura, null);  
		g.dispose();  
	}
	
	public void espelhamentoHorizontal() {
		final int comprimento = this.getWidth(), altura = this.getHeight(),
		          colunaMaxima = comprimento - 1;
		int vetorOriginalPixels[] = this.getRGB(0, 0, comprimento, altura,
				null, 0, this.getWidth());
		int novoVetorPixel[] = new int[vetorOriginalPixels.length];
		for(int cont = 0; cont < vetorOriginalPixels.length; cont++){
			int linhaAtual = cont / comprimento, colunaAtual = cont % comprimento,
			    novaColuna = colunaMaxima - colunaAtual,
			    novaPosicao = linhaAtual * comprimento + novaColuna;
			novoVetorPixel[novaPosicao] = vetorOriginalPixels[cont];
		}
		this.setRGB(0, 0, comprimento, altura, novoVetorPixel, 0, comprimento);
	
	}  
	
	public void espelhamentoVertical() {
		final int comprimento = this.getWidth(), altura = this.getHeight(),
		          linhaMaxima = altura - 1;
		int vetorOriginalPixels[] = this.getRGB(0, 0, comprimento, altura,
				null, 0, this.getWidth());
		int novoVetorPixel[] = new int[vetorOriginalPixels.length];
		for(int cont = 0; cont < vetorOriginalPixels.length; cont++){
			int linhaAtual = cont / comprimento, colunaAtual = cont % comprimento,
			    novaLinha = linhaMaxima - linhaAtual,
			    novaPosicao = novaLinha * comprimento + colunaAtual;
			//System.out.println("cont: "+cont+" novaPosicao: "+novaPosicao);
			novoVetorPixel[novaPosicao] = vetorOriginalPixels[cont];
		}
		/*for(int cont = 0; cont < vetorOriginalPixels.length;cont++){
			vetorOriginalPixels[cont] = novoVetorPixel[cont];
		}*/
		this.setRGB(0, 0, comprimento, altura, novoVetorPixel, 0, comprimento);
	
	}  
	
	/*
	 * Utiliza a biblioteca do Java, NÃO é mais utilizado no projeto.
	 */
	public void espelhamentoVerticalAntigo() {
		int comprimento = this.getWidth(), altura = this.getHeight();  
		Imagem imagemAuxiliar = new Imagem(this);
		Graphics2D g = this.createGraphics();  
		g.drawImage(imagemAuxiliar, 0, 0, comprimento, altura, 0, altura, comprimento, 0, null);  
		g.dispose();  
	}
	
	public void luminancia(){
		/*
		 *L = 0.299*R + 0.587*G + 0.114*B, onde R, G e B são as componentes de cor do pixel
		 *original. Ao criar uma imagem a ser exibida em tons de cinza, para cada pixel pi, faça:
		 *Ri = Gi = Bi = Li; 
		 */
		int comprimento = this.getWidth(), altura = this.getHeight(),
		    vetorPixels[] = this.getRGB(0,0,comprimento,altura,null,0,comprimento);
		final int quantidadePixels = vetorPixels.length;
		for (int cont=0; cont < quantidadePixels;cont++) {
			int rgbPixel = vetorPixels[cont];
			Color rgbCor = new Color(rgbPixel);
			int redCor = rgbCor.getRed(), blueCor = rgbCor.getBlue(), greenCor = rgbCor.getGreen(),
			    luminancia = (int)Math.round(0.299 * redCor + 0.587 * greenCor + 0.114 * blueCor);
			if(luminancia < 0){
				luminancia = 0;
			}else if (luminancia > 255){
				luminancia = 255;
			}
			rgbCor = new Color(luminancia,luminancia,luminancia);
			vetorPixels[cont] = rgbCor.getRGB();
		}
		this.setRGB(0, 0, comprimento, altura, vetorPixels, 0, comprimento);
	}
	
	public void quantizacao(int quantidadeTons) throws ArithmeticException{
		quantidadeTons--;
		int comprimento = this.getWidth(), altura = this.getHeight(),
		    vetorPixels[] = this.getRGB(0,0,comprimento,altura,null,0,comprimento);
		final int quantidadePixels = vetorPixels.length;
		for (int cont=0; cont < quantidadePixels;cont++) {
			int rgbPixel = vetorPixels[cont];
			Color rgbCor = new Color(rgbPixel);
			int luminancia = rgbCor.getRed();
			luminancia = (Math.round((luminancia /255F)*quantidadeTons)) ;
			luminancia *= 255;
			luminancia /= quantidadeTons;
			System.out.println("luminancia: "+luminancia);
			if (luminancia > 255){
				luminancia = 255;
			}
			rgbCor = new Color(luminancia,luminancia,luminancia);
			vetorPixels[cont] = rgbCor.getRGB();
		}
		this.setRGB(0, 0, comprimento, altura, vetorPixels, 0, comprimento);
	}
	
}
