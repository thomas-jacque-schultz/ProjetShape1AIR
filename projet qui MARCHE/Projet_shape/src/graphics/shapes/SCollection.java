package graphics.shapes;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;


public class SCollection extends Shape{
	
	  private final Set<Shape> shapes;

	  public SCollection(Set<Shape> shapes)
	  {
	    super();
	    this.shapes = new HashSet<Shape>(Objects.requireNonNull(shapes));
	  }


	  public SCollection()
	  {
		  this(Collections.emptySet());
	  }


	  public Iterator<Shape> Iterator()
	  {
	    return this.shapes.iterator();
	  }


	  public void add(Shape shape)
	  {
	    this.shapes.add(shape);
	  }


	  public boolean delete(Shape shape)
	  {
	    Iterator<Shape> iter = this.Iterator();

	    while (iter.hasNext()) {
	      Shape current = iter.next();

	      if (current instanceof SCollection) {
	        SCollection current_coll = (SCollection) current;

	        if (current == shape) {
	          current_coll.shapes.clear();
	          return true;
	        }

	        if (current_coll.delete(shape)) {
	          return true;
	        }
	      } else {
	        if (current == shape) {
	          iter.remove();
	          return true;
	        }
	      }
	    }

	    return false;
	  }


	  public Shape getTarget(Point p, Graphics g)
	  {
	    for (Shape s : this.shapes) {
	      if (s.contains(p, g)) {
	        return s;
	      }
	    }

	    return null;
	  }


	 
	  public Point getLoc()
	  {
	    int mean_x = 0;
	    int mean_y = 0;

	    for (Shape s : this.shapes) {
	      mean_x +=
	        Double.valueOf(s.getLoc().getX() / this.shapes.size()).intValue();
	      mean_y +=
	        Double.valueOf(s.getLoc().getY() / this.shapes.size()).intValue();
	    }

	    return new Point(mean_x, mean_y);
	  }


	 
	  public void setLoc(Point point)
	  {
	    for (Shape s : this.shapes) {
	      s.setLoc(point);
	    }
	  }


	  
	  public void translate(int dx, int dy)
	  {
	    for (Shape s : this.shapes) {
	      s.translate(dx, dy);
	    }
	  }

	  
	  public Rectangle getBounds(Graphics g)
	  {
	    Rectangle bounds = new Rectangle(-1, -1);

	    for (Shape s : this.shapes) {
	      bounds = bounds.union(s.getBounds(g));
	    }

	    return bounds;
	  }


	  public void accept(ShapeVisitor visitor)
	  {
	    for (Shape s : this.shapes) {
	      s.accept(visitor);
	    }
	  }


	  public boolean contains(Point p, Graphics g)
	  {
	    for (Shape s : this.shapes) {
	      if (s.contains(p, g)) {
	        return true;
	      }
	    }

	    return false;
	  }
}
