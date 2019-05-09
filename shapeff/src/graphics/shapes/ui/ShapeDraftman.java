package graphics.shapes.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.Shape;

public class ShapeDraftman  implements ShapeVisitor {
	
	private Graphics g;
	
	public ShapeDraftman(Graphics g) {
		this.g=g;
	}

	@Override
	public void visitRectangle(SRectangle srec) {
		// TODO Auto-generated method stub
		Graphics2D g2d= (Graphics2D) this.g;
		Rectangle rect = srec.getRect();
		
		g2d.draw(rect);
	}

	@Override
	public void visitCollection(SCollection scol) {
		// TODO Auto-generated method stub
		Iterator<Shape> iterator = scol.iterator();
		while(iterator.hasNext()) {
			iterator.next().accept(this);
		}
	}

}
