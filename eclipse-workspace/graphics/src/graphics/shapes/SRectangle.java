package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {
	private Rectangle rect;
	
	public SRectangle(Point point, int width, int height) {
		this.rect = new Rectangle(point.x, point.y, width, height);
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	
	public Point getLoc() {
		return new Point(this.rect.x, this.rect.y);
	}
	
	public void setLoc(Point point) {
		this.rect.x = point.x;
		this.rect.y = point.y;
	}
	
	public void translate(int dx, int dy) {
		this.rect.x += dx;
		this.rect.y += dy;
	}
	
	public Rectangle getBounds() {
		return this.rect;
	}
	
	public void accept(ShapeVisitor visitor) {
		visitor.visitRectangle(this);
	}
	
}
