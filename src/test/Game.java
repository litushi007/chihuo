package test;

import javax.swing.*;//�� javax�������swing������� ���ж��� ��������

import controller.Controller;//�����������Controller��
import view.GamePanel;
import entities.*;

public class Game {
	
	public static void main(String[] args) {
		//����һ�����ι���������ShapeFactory   �ǲ���ͼ�εĹ�����������в�ͬ��״��ͼ��
		ShapeFactory shapeFactory = new ShapeFactory();
		//����һ������������Ground ��Ӧ�����ϰ����࣬����ͼ�����䵽�ײ�����ϰ����һ���֣���Ҫ������Щ����
		Ground ground = new Ground();
		//����һ����Ϸ���������gamePanle ����Ϸ��������
		GamePanel gamePanel = new GamePanel();
		/*���ݱ��ι�������������Ϸ����ʼ��һ����������Controller ��Ӧ������������࣬
		����ͼ�ε�һЩ�������������������ϰ�����ô�������εȲ���*/
		Controller controller = new Controller(ground,shapeFactory,gamePanel);
		//����һ���������,JFrame ,Java  GUI �Ķ�������
		JFrame frame = new JFrame();
		//���øô���رպ��������,����ǵ����ڹر�ʱ�� ���ͷ�java �������Դ��û����㿪���˴��ڻ��ڴ������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*���øô���Ŀ��Ϊ ��Ϸ�����Ϊ+20���߶�Ϊ ��Ϸ���߶�Ϊ+40���������������frame�Ĵ�С��
		 Ҫ��GamePanle�������20���أ���40 ���أ�����Ȼ�Ǳ������ͱ߿�ռ������*/
		frame.setSize(gamePanel.getSize().width+20,gamePanel.getSize().height+40);
		//����Ϸ�����ӵ�������
		frame.add(gamePanel);
		//������Ϸ���ļ��̼����¼�������Ϊ����������
		gamePanel.addKeyListener(controller);
		frame.addKeyListener(controller);
		//���ô���ɼ�
		frame.setVisible(true);
		//ִ�п�����������Ϸ����
		controller.newGame();
	}

}
