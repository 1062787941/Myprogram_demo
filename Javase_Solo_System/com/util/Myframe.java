package com.util;

import java.awt.Frame;

@SuppressWarnings("serial")
public class Myframe extends Frame{
	/**
	 * ���ش���
	 */
	public void launghFrame(){
		setSize(Conner.FRAME_WEIDTH,Conner.FRAME_HEIGHT);
		setLocation(100,100);
		setUndecorated(true);//ȥ�������Ե
		setVisible(true);
		//�����߳�
		new printThread().start();
		//�رմ���ʱ�˳�
		/*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
	}
	
	//������ʵ��
	class printThread extends Thread{
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
