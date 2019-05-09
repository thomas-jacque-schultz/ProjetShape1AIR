package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

public class FontAttributes extends Attributes {
	public static final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN,  12);
	public static final Color DEFAULT_COLOR = Color.MAGENTA;
	
	private Font font;
	private Color color;
	
	public FontAttributes() {
		this.font = DEFAULT_FONT;
		this.color = DEFAULT_COLOR;
	}

	@Override
	public String getId() {
		return "font";
	}
	
	public Font font() {
		return this.font;
	}
	
	public Color fontColor() {
		return this.color;
	}
	
	public Rectangle getBounds(String text) {
		Graphics2D g2d = (Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
		FontRenderContext context = ((Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics()).getFontRenderContext();
		return font.getStringBounds(text, context).getBounds();
	}

}
