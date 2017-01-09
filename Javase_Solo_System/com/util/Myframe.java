package com.util;

import java.awt.Frame;

@SuppressWarnings("serial")
public class Myframe extends Frame{
	/**
	 * 加载窗口
	 */
	public void launghFrame(){
		setSize(Conner.FRAME_WEIDTH,Conner.FRAME_HEIGHT);
		setLocation(100,100);
		setUndecorated(true);//去除窗体边缘
		setVisible(true);
		//启动线程
		new printThread().start();
		//关闭窗口时退出
		/*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
	}
	
	//动画的实现
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
