package graphics.shapes.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

public class ShapesView extends View {


		public ShapesView(Object model) {
			super(model);
			this.setFocusable(true);
		}
		
		public Controller defaultController(Object model) {
			return new ShapesController(model);
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Shape c = (Shape) this.getModel();
			c.accept(new ShapeDraftman(g));
		}




}
