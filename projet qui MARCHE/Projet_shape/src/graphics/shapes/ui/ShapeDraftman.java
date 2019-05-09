package graphics.shapes.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;

import graphics.shapes.SRectangle;
import graphics.shapes.SText;

import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;


public class ShapeDraftman extends Object implements ShapeVisitor
{
  public static final boolean DEFAULT_FILLED = true;
  public static final boolean DEFAULT_STROKED = true;


  private final Graphics graphics;

//  public static ColorAttributes getColorAttributes(Shape s)
//  {
//    ColorAttributes attr = (ColorAttributes) s.getAttributes(
//      ColorAttributes.ID
//    );
//
//    if (attr == null) {
//      attr = new ColorAttributes(DEFAULT_FILLED, DEFAULT_STROKED);
//      s.addAttributes(attr);
//    }
//
//    return attr;
//  }
//
//  public static FontAttributes getFontAttributes(Shape s)
//  {
//    FontAttributes attr = (FontAttributes) s.getAttributes(FontAttributes.ID);
//
//    if (attr == null) {
//      attr = new FontAttributes();
//      s.addAttributes(attr);
//    }
//
//    return attr;
// }


  public ShapeDraftman(Graphics graphics)
  {
    super();
    this.graphics = graphics;
  }


  @Override
  public void visitRectangle(SRectangle srect)
  {    //Color tmp_color = this.graphics.getColor();
    //Point loc = srect.getLoc();
    Rectangle rect = srect.getRect();
    Graphics2D g2d = (Graphics2D) this.graphics;
    g2d.draw(rect);
}

//    ColorAttributes color_attr = getColorAttributes(srect);
//    if (color_attr.filled) {
//      this.graphics.setColor(color_attr.filledColor);
//      this.graphics.fillRect(
//        loc.x + 1, loc.y + 1, rect.width - 1, rect.height - 1
//      );
//    }
//
//    if (color_attr.stroked) {
//      this.graphics.setColor(color_attr.strokedColor);
//      this.graphics.drawRect(loc.x, loc.y, rect.width, rect.height);
//    }
//
//    this.graphics.setColor(tmp_color);
 //}
//
//
//  /* drawOval() takes the location of a rectangle (upper left corner). */
//  @Override
  public void visitCircle(SCircle scircle)
 {
	  	
	    Graphics2D g2d = (Graphics2D) this.graphics;
	    g2d.drawOval(scircle.getLoc().x-scircle.getRadius(),scircle.getLoc().y-scircle.getRadius(),2*scircle.getRadius(),2*scircle.getRadius());
	    
//    Color tmp_color = this.graphics.getColor();
//
//    Point loc = scircle.getLoc();
//    int radius = scircle.getRadius();
//
//    ColorAttributes color_attr = getColorAttributes(scircle);
//
//    if (color_attr.filled) {
//      this.graphics.setColor(color_attr.filledColor);
//      this.graphics.fillOval(
//        Double.valueOf(loc.x - radius).intValue(),
//        Double.valueOf(loc.y - radius).intValue(),
//        radius * 2,
//        radius * 2
//      );
//    }
//
//    if (color_attr.stroked) {
//      this.graphics.setColor(color_attr.strokedColor);
//      this.graphics.drawOval(
//        Double.valueOf(loc.x - radius).intValue(),
//        Double.valueOf(loc.y - radius).intValue(),
//        radius * 2,
//        radius * 2
//      );
//    }
//
//    this.graphics.setColor(tmp_color);
 }
//
//
//  /* Draws an optional Rectangle around the text if ColorAttributes are found.

//  @Override
 public void visitText(SText stext)
 {
	 Graphics2D g2d = (Graphics2D) this.graphics;
	 g2d.drawString(stext.getText(),stext.getLoc().x,stext.getLoc().y);
//    Color tmp_color = this.graphics.getColor();
//    Font tmp_font = this.graphics.getFont();
//
//    Point loc = stext.getLoc();
//    String text = stext.getText();
//
//    FontAttributes font_attr = getFontAttributes(stext);
//    ColorAttributes color_attr = (ColorAttributes) stext.getAttributes(
//      ColorAttributes.ID
//    );
//
//    this.graphics.setFont(font_attr.font);
//
//    if (color_attr != null) {
//      SRectangle shape_bounds = new SRectangle(stext.getBounds(this.graphics));
//      shape_bounds.addAttributes(color_attr);
//      this.visitRectangle(shape_bounds);
//    }
//
//    this.graphics.setColor(font_attr.fontColor);
//    this.graphics.drawString(text, loc.x, loc.y);
//
//    this.graphics.setColor(tmp_color);
//    this.graphics.setFont(tmp_font);
}


//  @Override
public void visitCollection(SCollection scollection)
  {
	Iterator<Shape> i = scollection.Iterator();
	while (i.hasNext()) {
		i.next().accept(this);
	}
//  Color tmp_color = this.graphics.getColor();
//
//
//   this.graphics.setColor(tmp_color);
 }
}