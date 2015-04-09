package test;

import javax.swing.*;//把 javax包里面的swing包里面的 所有东西 引进来。

import controller.Controller;//导入控制器，Controller型
import view.GamePanel;
import entities.*;

public class Game {
	
	public static void main(String[] args) {
		//定义一个变形工厂变量，ShapeFactory   是产生图形的工厂，会产生有不同形状的图形
		ShapeFactory shapeFactory = new ShapeFactory();
		//定义一个背景变量，Ground 类应该是障碍物类，就是图形下落到底层会变成障碍物的一部分，主要处理这些问题
		Ground ground = new Ground();
		//定义一个游戏面板容器，gamePanle 是游戏主界面类
		GamePanel gamePanel = new GamePanel();
		/*根据变形工厂、背景、游戏面板初始化一个控制器，Controller 类应该是中央控制类，
		处理图形的一些动作监听，比如遇到障碍物怎么处理，变形等操作*/
		Controller controller = new Controller(ground,shapeFactory,gamePanel);
		//定义一个窗体变量,JFrame ,Java  GUI 的顶层容器
		JFrame frame = new JFrame();
		//设置该窗体关闭后结束进程,这句是当窗口关闭时候 ，释放java 虚拟机资源，没这句你开多了窗口会内存溢出。
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*设置该窗体的宽度为 游戏面板宽度为+20，高度为 游戏面板高度为+40。这句是设置整个frame的大小，
		 要比GamePanle这个面板宽20像素，高40 像素，很显然是标题栏和边框占得像素*/
		frame.setSize(gamePanel.getSize().width+20,gamePanel.getSize().height+40);
		//将游戏面板添加到窗体中
		frame.add(gamePanel);
		//设置游戏面板的键盘监听事件，参数为控制器变量
		gamePanel.addKeyListener(controller);
		frame.addKeyListener(controller);
		//设置窗体可见
		frame.setVisible(true);
		//执行控制器的新游戏方法
		controller.newGame();
	}

}
