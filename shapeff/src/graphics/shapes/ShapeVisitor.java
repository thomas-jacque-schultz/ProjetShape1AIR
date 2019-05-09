package graphics.shapes;

public interface ShapeVisitor {

		public abstract void visitRectangle(SRectangle srec);
		
		public abstract void visitCollection(SCollection scol);
}
