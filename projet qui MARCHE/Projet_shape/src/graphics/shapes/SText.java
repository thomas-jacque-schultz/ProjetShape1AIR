package graphics.shapes;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.Objects;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.ui.ShapeDraftman;


public class SText extends Shape
{
  public static final String DEFAULT_TEXT = "Text";

  public static final int TEXT_BOUND_MARGIN = 10;


  private String text;
  private final Point loc;


  public SText(String text, Point loc)
  {
    super();
    this.text = text;
    this.loc = loc.getLocation();
  }


  public SText(String text)
  {
    this(text, new Point());
  }


  public SText(Point loc)
  {
    this(DEFAULT_TEXT, loc);
  }


  public SText()
  {
    this(DEFAULT_TEXT, new Point());
  }


  public SText(Point point, String string) {
	this.loc=point;
	this.text=string;
}


public String getText()
  {
    return this.text;
  }


  public void setText(String text)
  {
    this.text = Objects.requireNonNull(text);
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
//    Font font = ShapeDraftsman.getFontAttributes(this).font;
//    FontRenderContext context = g.getFontMetrics(font).getFontRenderContext();
//
//    Rectangle bounds = new TextLayout(this.text, font, context).getPixelBounds(
//      context,
//      Double.valueOf(this.getLoc().getX()).floatValue(),
//      Double.valueOf(this.getLoc().getY()).floatValue()
//    );
//
//    ColorAttributes attr = (ColorAttributes) this.getAttributes(
//      ColorAttributes.ID
//    );
//
//    if (attr != null) {
//      if (attr.stroked) {
//        bounds.setSize(
//          bounds.width + TEXT_BOUND_MARGIN * 2,
//          bounds.height + TEXT_BOUND_MARGIN * 2
//        );
//        bounds.translate(-TEXT_BOUND_MARGIN, -TEXT_BOUND_MARGIN);
//      } else if (attr.filled) {
//        bounds.setSize(
//          bounds.width + (TEXT_BOUND_MARGIN - 1) * 2,
//          bounds.height + (TEXT_BOUND_MARGIN - 1) * 2
//        );
//        bounds.translate(-TEXT_BOUND_MARGIN + 1, -TEXT_BOUND_MARGIN + 1);
//      }
//    }
//
//    return bounds;
    
    return null;
  }


  @Override
  public void accept(ShapeVisitor visitor)
  {
    visitor.visitText(this);
  }


  @Override
  public boolean contains(Point p, Graphics g)
  {
    return this.getBounds(g).contains(p);
  }
}
