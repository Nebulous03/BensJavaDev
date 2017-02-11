package nebulous.collegeApp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageUtils{
	
	// MADE BY THE OTHER GUY (ASHTON)
	
	public static BufferedImage resizeImage(BufferedImage image, int width, int height){
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
		
	}
	
	public static BufferedImage resizeImage(BufferedImage image, Dimension dimensions){
		int width = dimensions.width;
		int height = dimensions.height;
		
		BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
		
	}
	
}
