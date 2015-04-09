package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import entities.*;
import entities.util.Global;

public class GamePanel extends JPanel{
	
	private Ground ground;
	private Shape shape;
	
	public void display(Ground ground,Shape shape){
		this.ground=ground;
		this.shape=shape;
		System.out.println("GamePanel's display !");
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE , Global.HEIGHT * Global.CELL_SIZE);
		
		if(shape != null && ground != null){
			shape.drawMe(g);
			ground.drawMe(g);
		}
		
	}
	
	public GamePanel(){
		this.setSize(Global.WIDTH * Global.CELL_SIZE,Global.HEIGHT * Global.CELL_SIZE);
	}
	
	

}
