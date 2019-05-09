package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import graphics.shapes.attributes.SelectionAttributes;

public class SCollection extends Shape{
	
	private List<Shape> shapescol;
	
	public SCollection() {
		this.shapescol=new ArrayList<>();
	}

	public Iterator<Shape> iterator() {
		return this.shapescol.iterator();
	}
	public void add(Shape sh) {
		this.shapescol.add(sh);
	}
	public Point getLoc() {
		return null;
	}
	public void setLoc(Point p) {
		
	}
	public void translate(int x,int y) {
		for(Shape sh : this.shapescol) {
			sh.translate(x,y);
		}
	}
	public Rectangle getBounds() {
		return null;
	}
	
	public void accept(ShapeVisitor sv) {
		sv.visitCollection(this);
	}
	

}
