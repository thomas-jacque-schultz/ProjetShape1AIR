package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftMan implements ShapeVisitor {
	public static ColorAttributes DEFAULT_COLOR_ATTRIBUTES = new ColorAttributes(false, true, Color.BLACK, Color.BLACK);
	public static FontAttributes DEFAULT_FONT_ATTRIBUTES = new FontAttributes();
	
	private Graphics g;
	
	public ShapeDraftMan(Graphics g) {
		this.g = g;
	}
	
	@Override
	public void visitCollection(SCollection c) {
		Iterator<Shape> i = c.iterator();
		while(i.hasNext()) {
			i.next().accept(this);
		}
		SelectionAttributes selection = (SelectionAttributes) c.getAttributes("selection");
		if(selection != null && selection.isSelected()) {
			this.doSelection(c.getBounds());
		}
	}
	
	@Override
	public void visitRectangle(SRectangle r) {
		Graphics2D g2d = (Graphics2D) this.g;
		ColorAttributes color = (ColorAttributes) r.getAttributes("color");
		Rectangle rect = r.getRect();
		if(color == null) {
			color = DEFAULT_COLOR_ATTRIBUTES;
		}
		if(color.filled()) {
			g2d.setColor(color.filledColor());
			g2d.fill(rect);
		}
		if(color.stroked()) {
			g2d.setColor(color.strokedColor());
			g2d.draw(rect);
		}
		SelectionAttributes selection = (SelectionAttributes) r.getAttributes("selection");
		if(selection != null && selection.isSelected()) {
			this.doSelection(rect);
		}
	}
	
	@Override
	public void visitCircle(SCircle c) {
		Graphics2D g2d = (Graphics2D) this.g;
		Rectangle bounds = c.getBounds();
		ColorAttributes color = (ColorAttributes) c.getAttributes("color");
		if(color == null) {
			color = DEFAULT_COLOR_ATTRIBUTES;
		}
		if(color.filled()) {
			g2d.setColor(color.filledColor());
			g2d.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		if(color.stroked()) {
			g2d.setColor(color.strokedColor());
			g2d.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		SelectionAttributes selection = (SelectionAttributes) c.getAttributes("selection");
		if(selection != null && selection.isSelected()) {
			this.doSelection(bounds);
		}
	}
	
	@Override
	public void visitText(SText t) {
		Graphics2D g2d = (Graphics2D) this.g;
		ColorAttributes color = (ColorAttributes) t.getAttributes("color");
		Rectangle bounds = t.getBounds();
		if(color == null) {
			color = DEFAULT_COLOR_ATTRIBUTES;
		}
		if(color.filled()) {
			g2d.setColor(color.filledColor());
			g2d.fill(bounds);
		}
		if(color.stroked()) {
			g2d.setColor(color.strokedColor());
			g2d.draw(bounds);
		}
		FontAttributes font = (FontAttributes) t.getAttributes("font");
		if(font == null) {
			font = DEFAULT_FONT_ATTRIBUTES;
		}
		g2d.setFont(font.font());
		g2d.setColor(font.fontColor());
		g2d.drawString(t.getText(), t.getLoc().x, t.getLoc().y);
		SelectionAttributes selection = (SelectionAttributes) t.getAttributes("selection");
		if(selection != null && selection.isSelected()) {
			this.doSelection(bounds);
		}
	}
	
	private void doSelection(Rectangle bounds) {
		Graphics2D g2d = (Graphics2D) this.g;
		g2d.setColor(Color.GRAY);
		int[] x1 = {bounds.x - 5, bounds.x - 5, bounds.x + bounds.width + 5, bounds.x + bounds.width + 5};
		int[] x2 = {bounds.x, bounds.x - 5, bounds.x + bounds.width + 5, bounds.x + bounds.width};
		int[] y1 = {bounds.y - 5, bounds.y -5, bounds.y + bounds.height + 5, bounds.y + bounds.height +5};
		int[] y2 = {bounds.y - 5, bounds.y, bounds.y + bounds.height, bounds.y + bounds.height +5};
		for(int i=0; i<x1.length; i++) {
			g2d.drawLine(x1[i], y1[i], x2[i], y2[i]);
		}
	}
	
}
