package entities;

import java.util.Random;

import listener.ShapeListener;

public class ShapeFactory {
	//声明一个三维数组，并为之申请内存
	private int shapes[][][] = new int[][][]
	{
			{
				{
					1,0,0,0,
					1,1,1,0,
					0,0,0,0,
					0,0,0,0
				},
				{
					1,1,0,0,
					1,0,0,0,
					1,0,0,0,
					0,0,0,0,
				},
				{
					1,1,1,0,
					0,0,1,0,
					0,0,0,0,
					0,0,0,0
				},
				{
					0,1,0,0,
					0,1,0,0,
					1,1,0,0,
					0,0,0,0,
				}
				
				
			}
	};
	
	//在程序中调用这个方法得到一个新的方块，同时要为新方块注册图形监听器
	public Shape getShape(ShapeListener listener){
		System.out.println("ShapeFactory's getShape !");
		Shape shape = new Shape();
		shape.addShapeListener(listener);
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		shape.setStatus(0);
		return shape;
	}
	
}
