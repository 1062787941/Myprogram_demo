package cn.Solor;

import java.awt.Graphics;
import java.awt.Image;

import com.util.GameImage;

public class Star {
	Image image;
	double x,y;
	double height;	//ͼƬ�ĸ߶�
	double width;	//ͼƬ�Ŀ��
	
	public void draw(Graphics g){
		g.drawImage(image, (int)x, (int)y,null);
	}
	
	public Star(Image image, double x,double y){
		this(image);//
		this.x = x;
		this.y = y;
	}
	
	public Star(String imagepath, double x,double y){
		this(GameImage.getImage(imagepath), x, y);//ͨ��this������һ�����췽��
	}
	
	public Star(Image image){
		this.image = image;
		this.height = image.getHeight(null);
		this.width = image.getWidth(null);
	}

}
