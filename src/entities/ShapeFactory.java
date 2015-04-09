package entities;

import java.util.Random;

import listener.ShapeListener;

public class ShapeFactory {
	//����һ����ά���飬��Ϊ֮�����ڴ�
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
	
	//�ڳ����е�����������õ�һ���µķ��飬ͬʱҪΪ�·���ע��ͼ�μ�����
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
