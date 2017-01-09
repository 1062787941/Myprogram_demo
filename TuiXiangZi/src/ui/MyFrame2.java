package ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImagingOpException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * ��ʾ����
 */
public class MyFrame2 extends Frame implements KeyListener{
	//����
	JLabel wolf_Lable;
	
	//���캯��
	public MyFrame2(){

		//��������
		setWolf();
		
		//������ľ  
		for(int i = 0;i<11;i++){//��һ�����ŵ�
			treeInit(0,i);
		}
		for(int i=0;i<15;i++){//��һ�к���
			treeInit(i,0);
		}
		for(int i=0;i<11;i++){//�ұ�����
			treeInit(14,i);
		}
		for(int i=0;i<15;i++){//�����һ��
			treeInit(i,10);
		}
		//���ô��ڵı���
		BackGroundInit();
		//����������
		setMainFrameUI();
		//���ü����¼�
		this.addKeyListener(this);
	}

	
	//��ľ�ĳ�ʼ��
	private void treeInit(int x,int y) {
		Icon tree = new ImageIcon("./src/pic/tree.png");
		JLabel treeLable = null;
		treeLable = new JLabel(tree);
		treeLable.setBounds(12+52*x, 35+50*y, 50, 50);
		this.add(treeLable);
	}

	//��������
	private void setWolf() {
		Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
		wolf_Lable = new JLabel(i);
		wolf_Lable.setBounds(100, 100, 50, 50);
		this.add(wolf_Lable);
	}

	//���ô��ڵı���
	private void BackGroundInit() {
		Icon icon = new ImageIcon("./src/pic/bg.png");
		JLabel bg_icon = new JLabel(icon);
		bg_icon.setBounds(10, 31, 800, 600);
		this.add(bg_icon);
	}

	//�����ڵ�����
	private void setMainFrameUI() {
		//�O�ò��ַ�ʽΪ����(�Լ�ָ��)
		this.setLayout(null);
		//���ô��ڵ�λ��
		this.setLocation(300, 90);
		//���ô��ڵı���
		this.setTitle("������");
		//���ô��ڴ�С
		this.setSize(800, 600);
		//���ô��ڿɼ�
		this.setVisible(true);
		//���ô��ڹر�
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		//���̰��º�Ĳ���
		//�� 38  ��37 ��40  ��39
		int x = (int)wolf_Lable.getLocation().getX();
		int y= (int)wolf_Lable.getLocation().getY();
		
		int index = 20;
		
		//����
		if(e.getKeyCode() == 38){
			Icon i = new ImageIcon("./src/pic/shang.png");
			
			if(y>=90){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y-index);
			}
		}
		
		//����
		if(e.getKeyCode() == 40){
			Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
			if(y <= 470){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y+index);
			}
		}
		
		//����
		if(e.getKeyCode() == 37){
			Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
			
			if(x >= 60){
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x-index, y);
			}
		}
		
		//����
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
