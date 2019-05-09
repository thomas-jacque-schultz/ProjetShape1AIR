package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class SRectangle extends Shape {

	private Rectangle rect;
	
	public SRectangle(Point point, int witdh, int height) {
		this.rect = new Rectangle(point.x, point.y, witdh, height);
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	public Point getLoc() {
		return null;
	}
	public void setLoc(Point p) {
		
	}
	public void translate(int x, int y) {
		
	}
	public Rectangle getBounds() {
		return null;
	}
	public void accept(ShapeVisitor sv) {
		sv.visitRectangle(this);
	}

}
