package cn.Solor;


import java.awt.Graphics;
import java.awt.Image;

import com.util.Conner;
import com.util.GameImage;
import com.util.Myframe;
/**
 * 太阳类的主窗口
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Solor extends Myframe{
	Image bg =  GameImage.getImage("images/bg.png");
	Star sun = new Star("images/sun.png", (Conner.FRAME_WEIDTH-10)/2, (Conner.FRAME_HEIGHT-10)/2);
	Paint water = new Paint("images/water.png", 70, 50, 0.25, sun);
	Paint jin = new Paint("images/jin.png", 95, 70, 0.21, sun);
	Paint earth = new Paint("images/earth.png", 150, 100, 0.18, sun);
	Paint fair = new Paint("images/faire.png", 170, 120, 0.15, sun);
	Paint stone = new Paint("images/stone.png", 220, 140, 0.12, sun);
	Paint sea = new Paint("images/sea.png", 250, 155, 0.1, sun);
	Paint ming = new Paint("images/ming.png", 280, 170, 0.08, sun);
	Paint moon = new Paint("images/moon.png", 30, 20, 0.3, earth,true);
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		water.draw(g);
		jin.draw(g);
		earth.draw(g);
		fair.draw(g);
		stone.draw(g);
		sea.draw(g);
		ming.draw(g);
		moon.draw(g);
		
	}
	
	public static void main(String[] args) {
		new Solor().launghFrame();
	}

}
