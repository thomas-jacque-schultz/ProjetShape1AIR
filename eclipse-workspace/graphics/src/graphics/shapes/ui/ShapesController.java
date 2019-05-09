package graphics.shapes.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	private Point mousePos;
	private boolean shiftDown;

	public ShapesController(Object newModel) {
		super(newModel);
		this.shiftDown = false;
	}

	public void mouseClicked(MouseEvent e) {
		SCollection model = (SCollection) this.getModel();
		this.mousePos = e.getPoint();
		Iterator<Shape> i = model.iterator();
		while(i.hasNext()) {
			Shape shape = i.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");
			
			Rectangle bounds = shape.getBounds();
			if(this.shiftDown) {
				if(this.mousePos.x >= bounds.x && this.mousePos.x <= bounds.x + bounds.width
						&& this.mousePos.y >= bounds.y && this.mousePos.y <= bounds.y + bounds.height) {
//					System.out.println("selected");
					selection.toggleSelection();
				}
			} else {
				if(this.mousePos.x >= bounds.x && this.mousePos.x <= bounds.x + bounds.width
						&& this.mousePos.y >= bounds.y && this.mousePos.y <= bounds.y + bounds.height) {
//					System.out.println("selected");
					selection.select();
				} else {
					selection.unselect();
				}
			}
		}
		this.getView().repaint();
	}
	
	public void mousePressed(MouseEvent e) {
//		System.out.println("Mouse pressed");
	}

	public void mouseReleased(MouseEvent e) {
//		System.out.println("Mouse released");
	}

	public void mouseEntered(MouseEvent e) {
//		System.out.println("Mouse entered");
	}

	public void mouseExited(MouseEvent e) {
//		System.out.println("Mouse exited");
	}

	public void mouseMoved(MouseEvent evt) {
//		System.out.println("Mouse moved");
	}

	public void mouseDragged(MouseEvent evt) {
		SCollection model = (SCollection) this.getModel();
		Iterator<Shape> i = model.iterator();
		while(i.hasNext()) {
			Shape shape = i.next();
			SelectionAttributes selection = (SelectionAttributes) shape.getAttributes("selection");
			if(selection != null && selection.isSelected()) {
				shape.translate(evt.getX() - this.mousePos.x, evt.getY() - this.mousePos.y);
			}
		}
		this.mousePos = evt.getPoint();
		this.getView().repaint();
	}

	public void keyTyped(KeyEvent evt) {
//		System.out.println("Key typed " + evt.getKeyCode());
	}

	public void keyPressed(KeyEvent evt) {
//		System.out.println("Key pressed " + evt.getKeyCode());
		if(evt.getKeyCode() == KeyEvent.VK_SHIFT) {
			this.shiftDown = true;
		}
	}

	public void keyReleased(KeyEvent evt) {
//		System.out.println("Key released " + evt.getKeyCode());
		if(evt.getKeyCode() == KeyEvent.VK_SHIFT) {
			this.shiftDown = false;
		}
	}
}
