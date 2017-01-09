package cn.Solor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.util.GameImage;

public class Paint extends Star {

	// 图片 坐标。行星沿着某个椭圆飞行 长轴 短轴 速度 角度 绕着某个Star飞行
	double longAsic; // 椭圆的长轴
	double shortAsic; // 椭圆的短轴
	double speed; // 飞行的速度
	double degree; // 角度
	Star center; // 绕着的中心
	boolean type;

	public void draw(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
		if (!type) {
			drawtrace(g);
		}
		move();
	}

	public void drawtrace(final Graphics g) {
		 double _x;
		 double _y;
		 double _width;
		 double _height;

		_width = longAsic * 2;
		_height = shortAsic * 2;
		_x = (center.x + center.width / 2) - longAsic;
		_y = (center.y + center.height / 2) - shortAsic;
		Color c = g.getColor();
		g.setColor(Color.red);
		g.drawOval((int) _x, (int) _y, (int) _width, (int) _height);

		g.setColor(c);
	}

	public void move() {
		// 沿着椭圆轨迹飞行
		x = (center.x + center.width / 2) + longAsic * Math.cos(degree);
		y = (center.y + center.height / 2) + shortAsic * Math.sin(degree);
		degree += speed;
	}

	public Paint(String imagepath, double longAsic, double shortAsic,
			double speed, Star center) {
		super(GameImage.getImage(imagepath));
		this.center = center;
		this.x = center.x + longAsic;// 保证开始时在同一水平位置
		this.y = center.y;
		this.image = GameImage.getImage(imagepath);

		this.longAsic = longAsic;
		this.shortAsic = shortAsic;
		this.speed = speed;

		this.height = image.getHeight(null);
		this.width = image.getWidth(null);

	}

	public Paint(String imagepath, double longAsic, double shortAsic,
			double speed, Star center, boolean type) {
		this(imagepath, longAsic, shortAsic, speed, center);
		this.type = type;

	}

	public Paint(Image image, double x, double y) {
		super(image, x, y);
	}

	public Paint(String imagepath, double x, double y) {
		super(imagepath, x, y);
	}

}
