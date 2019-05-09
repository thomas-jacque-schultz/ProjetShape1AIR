package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.attributes.FontAttributes;

public class SText extends Shape {
	private Point loc;
	private String text;
	
	public SText(Point loc, String text) {
		this.loc = loc;
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point point) {
		this.loc = point;
	}

	@Override
	public void translate(int dx, int dy) {
		this.loc.x += dx;
		this.loc.y += dy;
	}

	@Override
	public Rectangle getBounds() {
		FontAttributes font = (FontAttributes) this.getAttributes("font");
		Rectangle rect = font.getBounds(this.text);
		rect.x += this.loc.x;
		rect.y += this.loc.y;
		return rect;
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitText(this);
	}
	
}
