package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SCollection extends Shape {
	Set<Shape> shapes;
	
	public SCollection() {
		this.shapes = new HashSet<>();
//		this.shapes = new ArrayList<>();
	}
	
	public Iterator<Shape> iterator() {
		return this.shapes.iterator();
	}
	
	public void add(Shape shape) {
		this.shapes.add(shape);
	}
	
	public Point getLoc() {
		Rectangle bounds = this.getBounds();
		return new Point(bounds.x, bounds.y);
	}
	
	public void setLoc(Point point) {
		Point p0 = this.getLoc();
		this.translate(point.x - p0.x, point.y - p0.y);
	}
	
	public void translate(int dx, int dy) {
		Iterator<Shape> i = this.iterator();
		while(i.hasNext()) {
			i.next().translate(dx, dy);
		}
	}
	
	public Rectangle getBounds() {
		int xmin = Integer.MAX_VALUE, ymin = Integer.MAX_VALUE;
		int xmax = 0, ymax = 0;
		Iterator<Shape> i = this.iterator();
		while(i.hasNext()) {
			Rectangle bounds = i.next().getBounds();
			xmin = Math.min(xmin, bounds.x);
			ymin = Math.min(ymin, bounds.y);
			xmax = Math.max(xmax, bounds.x + bounds.width);
			ymax = Math.max(ymax, bounds.y + bounds.height);
		}
		return new Rectangle(xmin, ymin, xmax - xmin, ymax - ymin);
	}
	
	public void accept(ShapeVisitor visitor) {
		visitor.visitCollection(this);
	}
	
}
