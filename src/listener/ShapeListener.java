package listener;

import entities.*;

public interface ShapeListener {
	
	void shapeMoveDown(Shape shape);
	
	boolean isShapeMoveDownable(Shape shape);

}
