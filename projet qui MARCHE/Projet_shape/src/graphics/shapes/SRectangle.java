package graphics.shapes;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {

	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 10;
	
	private final Rectangle rect;
	
	public SRectangle(Rectangle rect)
	  {
	    super();
	    this.rect = new Rectangle(rect);
	  }

//
//	  public SRectangle(Point loc)
//	  {
//	    this(new Rectangle(loc, new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT)));
//	  }
//
//
//	  public SRectangle()
//	  {
//	    this(new Rectangle(DEFAULT_WIDTH, DEFAULT_HEIGHT));
//	  }


	  public SRectangle(Point point, int i, int j) {
		  this(new Rectangle(point, new Dimension(i, j)));
	}


	public Rectangle getRect()
	  {
	    return this.rect;
	  }

	  public Point getLoc ()
	  {
	    return this.rect.getLocation();
	  }

	  public void setLoc (Point point)
	  {
	    this.rect.setLocation(point);
	  }

	  public void translate (int dx, int dy)
	  {
	    this.rect.translate(dx, dy);
	  }

	  public Rectangle getBounds(Graphics g)
	  {
	    return this.rect.getBounds();
	  }

	  public void accept (ShapeVisitor visitor)
	  {
	    visitor.visitRectangle(this);
	  }


	  
	  public boolean contains(Point p, Graphics g)
	  {
	    return this.rect.contains(p);
	  }
}
