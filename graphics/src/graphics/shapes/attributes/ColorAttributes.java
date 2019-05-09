package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {
	private boolean filled;
	private boolean stroked;
	private Color filledColor;
	private Color strokedColor;
	
	public ColorAttributes(boolean filled, boolean stroked, Color filledColor, Color strokedColor) {
		this.filled = filled;
		this.stroked = stroked;
		this.filledColor = filledColor;
		this.strokedColor = strokedColor;
	}

	@Override
	public String getId() {
		return "color";
	}
	
	public boolean filled() {
		return this.filled;
	}
	
	public boolean stroked() {
		return this.stroked;
	}
	
	public Color filledColor() {
		return this.filledColor;
	}
	
	public Color strokedColor() {
		return this.strokedColor;
	}
	
}
