package graphics.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;


public abstract class Shape extends Object
{
  private final Map<String, Attributes> attributes;


  protected Shape()
  {
    super();
    this.attributes = new TreeMap<String, Attributes>();
  }


  public abstract Point getLoc();

  public abstract void setLoc(Point point);

  public abstract void translate(int dx, int dy);

  public abstract Rectangle getBounds(Graphics g);

  public abstract void accept(ShapeVisitor visitor);

  public abstract boolean contains(Point p, Graphics g);


/*
  public Attributes getAttributes(String id)
  {
    return this.attributes.get(id);
  }


  public void addAttributes(Attributes a)
  {
    this.attributes.put(a.getId(), a);
  }
*/
}
