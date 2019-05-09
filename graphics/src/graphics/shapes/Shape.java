package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;

public abstract class Shape {
	Map<String, Attributes> attributes;
	
	public Shape() {
		this.attributes = new TreeMap<>();
	}
	
	public void addAttributes(Attributes a) {
		this.attributes.put(a.getId(), a);
	}
	
	public Attributes getAttributes(String key) {
		return this.attributes.get(key);
	}
	
	public abstract Point getLoc();
	
	public abstract void setLoc(Point point);
	
	public abstract void translate(int dx, int dy);
	
	public abstract Rectangle getBounds();
	
	public abstract void accept(ShapeVisitor visitor);
}
