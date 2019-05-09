package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class Shape {
	
	public abstract Point getLoc();
	
	public abstract void setLoc(Point p);
	
	//public abstract void translate(int x, int y);
	
	public abstract Rectangle getBounds();
	
	public abstract void accept(ShapeVisitor sv);

	protected abstract void translate(int x, int y);
}
