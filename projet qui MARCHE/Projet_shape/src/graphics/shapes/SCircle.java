package graphics.shapes;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class SCircle extends Shape
{
  public static final int DEFAULT_RADIUS = 10;


  private final Point loc;
  private int radius;


  public SCircle(Point loc, int radius)
  {
    super();
    this.loc = loc.getLocation();
    this.setRadius(radius);
  }


  public SCircle(int radius)
  {
    this(new Point(), radius);
  }


  public SCircle()
  {
    this(new Point(), DEFAULT_RADIUS);
  }


  //imp
  public int getRadius()
  {
    return this.radius;
  }


  public void setRadius(int radius)
  {
    if (radius > 0) {
      this.radius = radius;
    }
  }


  @Override
  public Point getLoc()
  {
    return this.loc.getLocation();
  }

  @Override
  public void setLoc(Point point)
  {
    this.loc.setLocation(point);
  }

  @Override
  public void translate(int dx, int dy)
  {
    this.loc.translate(dx, dy);
  }
  
  @Override
  public Rectangle getBounds(Graphics g)
  {
    return new Rectangle(
      this.loc.x - this.radius,
      this.loc.y - this.radius,
      2 * this.radius,
      2 * this.radius
    );
  }

  @Override
  public void accept(ShapeVisitor visitor)
  {
    visitor.visitCircle(this);
  }


  @Override
  public boolean contains(Point p, Graphics g)
  {
    return this.getLoc().distance(p) <= this.radius;
  }
}
