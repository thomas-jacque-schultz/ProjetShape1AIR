package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {
	private boolean selected;
	
	public SelectionAttributes() {
		this.selected = false;
	}

	@Override
	public String getId() {
		return "selection";
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void select() {
		this.selected = true;
	}
	
	public void unselect() {
		this.selected = false;
	}
	
	public void toggleSelection() {
		this.selected = !this.selected;
	}

}
