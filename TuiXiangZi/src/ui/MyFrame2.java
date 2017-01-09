package ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImagingOpException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * 显示窗口
 */
public class MyFrame2 extends Frame implements KeyListener{
	//人物
	JLabel wolf_Lable;
	
	//构造函数
	public MyFrame2(){

		//设置人物
		setWolf();
		
		//设置树木  
		for(int i = 0;i<11;i++){//第一行竖着的
			treeInit(0,i);
		}
		for(int i=0;i<15;i++){//第一行横着
			treeInit(i,0);
		}
		for(int i=0;i<11;i++){//右边竖行
			treeInit(14,i);
		}
		for(int i=0;i<15;i++){//下面的一行
			treeInit(i,10);
		}
		//设置窗口的背景
		BackGroundInit();
		//设置主窗口
		setMainFrameUI();
		//设置监听事件
		this.addKeyListener(this);
	}

	
	//树木的初始化
	private void treeInit(int x,int y) {
		Icon tree = new ImageIcon("./src/pic/tree.png");
		JLabel treeLable = null;
		treeLable = new JLabel(tree);
		treeLable.setBounds(12+52*x, 35+50*y, 50, 50);
		this.add(treeLable);
	}

	//设置人物
	private void setWolf() {
		Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
		wolf_Lable = new JLabel(i);
		wolf_Lable.setBounds(100, 100, 50, 50);
		this.add(wolf_Lable);
	}

	//设置窗口的背景
	private void BackGroundInit() {
		Icon icon = new ImageIcon("./src/pic/bg.png");
		JLabel bg_icon = new JLabel(icon);
		bg_icon.setBounds(10, 31, 800, 600);
		this.add(bg_icon);
	}

	//主窗口的设置
	private void setMainFrameUI() {
		//設置布局方式为自由(自己指定)
		this.setLayout(null);
		//设置窗口的位置
		this.setLocation(300, 90);
		//设置窗口的标题
		this.setTitle("推箱子");
		//设置窗口大小
		this.setSize(800, 600);
		//设置窗口可见
		this.setVisible(true);
		//设置窗口关闭
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		//键盘按下后的操作
		//上 38  左37 下40  右39
		int x = (int)wolf_Lable.getLocation().getX();
		int y= (int)wolf_Lable.getLocation().getY();
		
		int index = 20;
		
		//向上
		if(e.getKeyCode() == 38){
			Icon i = new ImageIcon("./src/pic/shang.png");
			
			if(y>=90){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y-index);
			}
		}
		
		//向下
		if(e.getKeyCode() == 40){
			Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
			if(y <= 470){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y+index);
			}
		}
		
		//向左
		if(e.getKeyCode() == 37){
			Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
			
			if(x >= 60){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x-index, y);
			}
		}
		
		//向右
		if(e.getKeyCode() == 39){
			Icon i = new ImageIcon("./src/pic/wolf_you.png");
			if(x < 700){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x+index, y);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
