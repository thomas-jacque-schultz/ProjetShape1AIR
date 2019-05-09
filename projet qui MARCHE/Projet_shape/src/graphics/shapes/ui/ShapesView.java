package graphics.shapes.ui;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;

import graphics.shapes.SRectangle;
import graphics.shapes.SText;

import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;
import graphics.ui.View;


public class ShapesView extends View
{
  private static final long serialVersionUID = 7765669436540625314L;


  public static SCollection getShowCaseShapes()
  {
    SCollection collection = new SCollection();

    SRectangle r1 = new SRectangle(new Rectangle(10, 10, 20, 30));
    //r1.addAttributes(new ColorAttributes(true, true, Color.GREEN, Color.BLUE));
    //r1.addAttributes(new SelectionAttributes());
    collection.add(r1);

    /*SCircle c1 = new SCircle(new Point(30, 100), 25);
    c1.addAttributes(new ColorAttributes(true, true, Color.RED, Color.BLUE));
    c1.addAttributes(new SelectionAttributes());
    collection.add(c1);

    SText t1 = new SText("I am a text.", new Point(100, 100));
    t1.addAttributes(new ColorAttributes(true, true, Color.YELLOW, Color.BLUE));
    t1.addAttributes(new FontAttributes());
    t1.addAttributes(new SelectionAttributes());
    collection.add(t1);

    SCircle c2 = new SCircle(new Point(60, 80), 25);
    c2.addAttributes(new ColorAttributes(true, false, Color.CYAN, Color.BLUE));
    c2.addAttributes(new SelectionAttributes());
    collection.add(c2);

    SText t2 = new SText("I am another text.", new Point(180, 200));
    t2.addAttributes(new ColorAttributes(true, false, Color.GRAY, Color.WHITE));
    t2.addAttributes(new FontAttributes(Color.RED));
    t2.addAttributes(new SelectionAttributes());
    collection.add(t2);

    SRectangle r3 = new SRectangle(new Rectangle(50, 15, 60, 30));
    r3.addAttributes(new ColorAttributes(
      false, true, Color.DARK_GRAY, Color.BLACK
    ));
    r3.addAttributes(new SelectionAttributes());
    collection.add(r3);

    SCircle c3 = new SCircle(new Point(40, 175), 30);
    c3.addAttributes(new ColorAttributes(
      false, true, Color.BLACK, Color.LIGHT_GRAY
    ));
    c3.addAttributes(new SelectionAttributes());
    collection.add(c3);

    SText t3 = new SText("I am framed.", new Point(200, 180));
    t3.addAttributes(new ColorAttributes(false, true, Color.BLACK, Color.PINK));
    t3.addAttributes(new FontAttributes(Color.BLUE));
    t3.addAttributes(new SelectionAttributes());
    collection.add(t3);

    SText t4 = new SText("#I exist.#", new Point(250, 250));
    t4.addAttributes(new ColorAttributes(
      false, false, Color.BLACK, Color.PINK
    ));
    t4.addAttributes(new FontAttributes(
      new Font("Arial", Font.BOLD | Font.ITALIC, 20), Color.BLACK
    ));
    t4.addAttributes(new SelectionAttributes());
    collection.add(t4);

    */

    return collection;
  }


  private static SCollection fallbackModel(SCollection model)
  {
    if (model == null) {
      return getShowCaseShapes();
    }

    return model;
  }


  public ShapesView(SCollection model)
  {
    super(fallbackModel(model));

    this.setFocusable(true);
    this.setAutoscrolls(true);
  }


  @Override
public Controller defaultController(Object model)
  {
    return new ShapesController(model);
  }


  @Override
  public SCollection getModel()
  {
    return (SCollection) super.getModel();
  }


  public void setModel(SCollection model)
  {
    super.setModel(model);

    this.setPreferredSize(model.getBounds(this.getGraphics()).getSize());
    this.revalidate();
    this.repaint();
  }


  @Override
  public void setModel(Object model)
  {
    this.setModel((SCollection) model);
  }


  private void paintBackground(Graphics graphics)
  {
    Color tmp_color = graphics.getColor();

    graphics.setColor(Color.WHITE);
    graphics.drawRect(0, 0, this.getWidth(), this.getHeight());
    graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

    graphics.setColor(tmp_color);
  }


  @Override
  protected void paintComponent(Graphics graphics)
  {
    super.paintComponent(graphics);

    this.paintBackground(graphics);

    ShapeDraftman drawer = new ShapeDraftman(graphics);

    this.getModel().accept(drawer);

//    for (SelectionShape s : this.getController().getSelections()) {
//      s.accept(drawer);
//    }
  }
}