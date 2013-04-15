package image;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImagemIO {

	public static BufferedImage abrirImage(String referencia) throws IOException{  
		BufferedImage bufferedImage = null;   
		bufferedImage = ImageIO.read(new File(referencia));  
		return bufferedImage;
	}
	
	public static void salvarImagem(String refencia, BufferedImage imagem) {  
		BufferedOutputStream saida;
		try {
			saida = new BufferedOutputStream(new FileOutputStream(refencia));
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(saida);
			JPEGEncodeParam parametros = encoder.getDefaultJPEGEncodeParam(imagem);
			//int qualidade = 5;
			//qualidade = Math.max(0, Math.min(qualidade, 100));
			//parametros.setQuality((float) qualidade / 100.0f, false);
			parametros.setQuality(1, false);
			encoder.setJPEGEncodeParam(parametros);
			encoder.encode(imagem);
			saida.close();
		}catch (Exception excecao) {
			excecao.printStackTrace();  
		}	  
	}  
}
