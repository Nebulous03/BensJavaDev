package abstractClass;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnimalPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public AnimalPanel(String image, double scale){
		
		String path = image;
	    File file = new File(path);
	    BufferedImage original;
	    JLabel label;
	     
		try {
			
			original = ImageIO.read(file);
			
			int w = original.getWidth();
			int h = original.getHeight();
			BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			AffineTransform at = new AffineTransform();
			at.scale(scale, scale);
			AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			result = scaleOp.filter(original, result);
			
			label = new JLabel(new ImageIcon(result));
			
			add(label);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
