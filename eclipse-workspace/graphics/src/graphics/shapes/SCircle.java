package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape {
	private Point loc;
	private int radius;
	
	public SCircle(Point loc, int radius) {
		this.loc = loc;
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
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
		return new Rectangle(this.loc.x - this.radius, this.loc.y - this.radius, 2 * this.radius, 2 * this.radius);
	}

	@Override
	public void accept(ShapeVisitor visitor) {
		visitor.visitCircle(this);
	}

}
