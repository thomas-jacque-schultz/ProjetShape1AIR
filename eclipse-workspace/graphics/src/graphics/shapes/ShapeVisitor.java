package graphics.shapes;

public interface ShapeVisitor {
	public abstract void visitCollection(SCollection c);
	
	public abstract void visitRectangle(SRectangle r);
	
	public abstract void visitCircle(SCircle c);
	
	public abstract void visitText(SText t);
	
}
