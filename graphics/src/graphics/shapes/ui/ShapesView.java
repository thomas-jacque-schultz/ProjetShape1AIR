package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {
	public ShapesView(Object model) {
		super(model);
		this.setFocusable(true);
	}
	
	@Override
	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Shape c = (Shape) this.getModel();
		c.accept(new ShapeDraftMan(g));
	}
}
