package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import listener.ShapeListener;
import view.*;
import entities.*;

public class Controller extends KeyAdapter implements ShapeListener{
	private Shape shape;
	private Ground ground;
	private ShapeFactory shapeFactory;
	private GamePanel gamePanel;

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			if(ground.isMoveable(shape, Shape.ROTATE))
				shape.rotate();
			break;
		case KeyEvent.VK_DOWN:
			if(isShapeMoveDownable(shape))
				shape.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			if(ground.isMoveable(shape, Shape.LEFT))
				shape.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			if(ground.isMoveable(shape, Shape.RIGHT))
				shape.moveRight();
			break;
		}
		
		gamePanel.display(ground, shape);
		
	}

	@Override
	public synchronized boolean isShapeMoveDownable(Shape shape) {
		if(this.shape != shape){
			return false;
		}
		if(ground.isMoveable(shape, Shape.DOWN))
			return true;
		ground.accept(this.shape);
		if(!ground.isFull()){
			this.shape = shapeFactory.getShape(this);
		}
		return false;
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		gamePanel.display(ground,shape);
	}
	
	public void newGame(){
		shape = shapeFactory.getShape(this);
	}
	
	public Controller(Ground ground,ShapeFactory shapeFactory,GamePanel gamePanel){
		this.ground = ground;
		this.shapeFactory = shapeFactory;
		this.gamePanel = gamePanel;
	}

}
