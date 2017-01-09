package cn.Solor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.util.GameImage;

public class Paint extends Star {

	// ͼƬ ���ꡣ��������ĳ����Բ���� ���� ���� �ٶ� �Ƕ� ����ĳ��Star����
	double longAsic; // ��Բ�ĳ���
	double shortAsic; // ��Բ�Ķ���
	double speed; // ���е��ٶ�
	double degree; // �Ƕ�
	Star center; // ���ŵ�����
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
		// ������Բ�켣����
		x = (center.x + center.width / 2) + longAsic * Math.cos(degree);
		y = (center.y + center.height / 2) + shortAsic * Math.sin(degree);
		degree += speed;
	}

	public Paint(String imagepath, double longAsic, double shortAsic,
			double speed, Star center) {
		super(GameImage.getImage(imagepath));
		this.center = center;
		this.x = center.x + longAsic;// ��֤��ʼʱ��ͬһˮƽλ��
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
