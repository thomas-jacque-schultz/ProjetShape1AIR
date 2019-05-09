package graphics.shapes;

public interface ShapeVisitor {

	  public abstract void visitRectangle(SRectangle srec);
	  public abstract void visitCircle(SCircle scir);
	  public abstract void visitText(SText stex);
	  public abstract void visitCollection(SCollection scoll);

}
