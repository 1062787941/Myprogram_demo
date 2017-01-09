package ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/*
 * ��ʾ����
 */
public class MyFrame extends Frame implements KeyListener {

	// �����ƽ����ӵĸ���
	 int num = 0;
	// �ܹ���������Ŀ
	 int total = 3;
	// �������ݵ�ģ�⣬ʹ�ö�ά����ģ��
	// 1�����ϰ���0����յ�
	int[][] arr = { 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 8, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 8, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } 
			};
	// ����һ��JLabel�����洢��
	// �����ʼ����ʱ�������
	JLabel sheeps[][] = new JLabel[12][16];
	int wx;
	int wy;
	JLabel wolf_Lable;

	// ���캯��
	public MyFrame() {

		// ��������
		setLong();
		// ��������
		setWolf();
		// ��ľ��ʼ��
		treeInit();
		// С����
		sheepInit();
		// ���ô��ڵı���
		BackGroundInit();
		// ����������
		setMainFrameUI();
		// ���ü����¼�
		this.addKeyListener(this);
	}

	// ���ӵ�����
	private void setLong() {
		Icon i = new ImageIcon("./src/pic/long.png");
		JLabel sheepLable1 = new JLabel(i);
		sheepLable1.setBounds(12 + 700, 36 + 150, 50, 50);
		this.add(sheepLable1);

		JLabel sheepLable2 = new JLabel(i);
		sheepLable2.setBounds(12 + 700, 36 + 200, 50, 50);
		this.add(sheepLable2);

		JLabel sheepLable3 = new JLabel(i);
		sheepLable3.setBounds(12 + 700, 36 + 250, 50, 50);
		this.add(sheepLable3);
	}

	// ���� �ϰ�
	private void sheepInit() {
		Icon i = new ImageIcon("./src/pic/sheep.png");
		JLabel sheepLable1 = new JLabel(i);
		sheepLable1.setBounds(12 + 300, 36 + 100, 50, 50);
		this.add(sheepLable1);
		// ��Ĵ���(��¼���λ��)
		arr[2][6] = 4;
		sheeps[2][6] = sheepLable1;

		JLabel sheepLable2 = new JLabel(i);
		sheepLable2.setBounds(12 + 300, 36 + 200, 50, 50);
		this.add(sheepLable2);
		arr[4][6] = 4;
		sheeps[4][6] = sheepLable2;

		JLabel sheepLable3 = new JLabel(i);
		sheepLable3.setBounds(12 + 300, 36 + 300, 50, 50);
		this.add(sheepLable3);
		arr[6][6] = 4;
		sheeps[6][6] = sheepLable3;
	}

	// ��ľ�ĳ�ʼ��
	private void treeInit() {
		Icon tree = new ImageIcon("./src/pic/tree.png");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (1 == arr[i][j]) {
					JLabel treeLable = new JLabel(tree);
					treeLable.setBounds(12 + 50 * j, 36 + 50 * i, 50, 50);
					this.add(treeLable);
				}
			}
		}
	}

	// ��������
	private void setWolf() {
		Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
		wolf_Lable = new JLabel(i);
		wx = 2;
		wy = 2;
		wolf_Lable.setBounds(12 + 50 * wx, 36 + 50 * wy, 50, 50);
		this.add(wolf_Lable);
	}

	// ���ô��ڵı���
	private void BackGroundInit() {
		Icon icon = new ImageIcon("./src/pic/bg.png");
		JLabel bg_icon = new JLabel(icon);
		bg_icon.setBounds(12, 32, 800, 600);
		this.add(bg_icon);
	}

	// �����ڵ�����
	private void setMainFrameUI() {
		// �O�ò��ַ�ʽΪ����(�Լ�ָ��)
		this.setLayout(null);
		// ���ô��ڵ�λ��
		this.setLocation(300, 90);
		// ���ô��ڵı���
		this.setTitle("������");
		// ���ô��ڴ�С
		this.setSize(800, 650);
		// ���ô��ڿɼ�
		this.setVisible(true);
		// ���ô��ڲ������
		// this.setResizable(false);
	}
	
	// ʤ�����ж�����
	private void victory() {
		if (num == total) {
			// �Ƴ���������¼��������û��������
			this.removeKeyListener(this);
			JDialog victory = new JDialog(this, "��ϲ��ȡ����ʤ��!", true);
			victory.setSize(400, 300);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);
			JLabel info = new JLabel(new ImageIcon("./src/pic/gg.jpg"));
			info.setBounds(2, 2, 380, 180);
			victory.add(info);
			victory.setVisible(true);
			System.out.println("ʤ��");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// ���̰��º�Ĳ���
		// �� 38 ��37 ��40 ��39
		int x = (int) wolf_Lable.getLocation().getX();
		int y = (int) wolf_Lable.getLocation().getY();
		int index = 50;

		// ����
		if (e.getKeyCode() == 39) {
			if (1 == arr[wy][wx + 1]) {// ������
				return;
			}
			if (4 == arr[wy][wx + 1] && 1 == arr[wy][wx + 2]) {// �������� ��ľ
				return;
			}
			if (4 == arr[wy][wx + 1] && 4 == arr[wy][wx + 2]) {// �������� ����
				return;
			}
			if (4 == arr[wy][wx + 1] && 12 == arr[wy][wx + 2]) {// �������� Ŀ������
				return;
			}
			if (12 == arr[wy][wx + 1] && 1 == arr[wy][wx + 2]) {// ����Ŀ������ ��ľ
				return;
			}
			if (12 == arr[wy][wx + 1] && 4 == arr[wy][wx + 2]) {// ����Ŀ������ ����
				return;
			}
			if (12 == arr[wy][wx + 1] && 12 == arr[wy][wx + 2]) {// ����Ŀ������ Ŀ������
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy][wx + 1]) {// �����յ�
				wx++;
				Icon i = new ImageIcon("./src/pic/wolf_you.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x + index, y);
				return;
			}
			if (8 == arr[wy][wx + 1]) {// ������Ŀ��
				wx++;
				Icon i = new ImageIcon("./src/pic/wolf_you.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x + index, y);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy][wx + 1] && 0 == arr[wy][wx + 2]) {// ���� ���� �յ�
				arr[wy][wx + 1] = 0;// ʹ��4����Ƿ�����
				arr[wy][wx + 2] = 4;
			}
			if (4 == arr[wy][wx + 1] && 8 == arr[wy][wx + 2]) {// ���� ���� ��Ŀ��
				arr[wy][wx + 1] = 0;// ʹ��4����Ƿ�����
				arr[wy][wx + 2] = 12;
				num++;
			}
			if (12 == arr[wy][wx + 1] && 0 == arr[wy][wx + 2]) {// ���� Ŀ������ �յ�
				arr[wy][wx + 1] = 8;// ʹ��4����Ƿ�����
				arr[wy][wx + 2] = 4;
				num--;
			}
			if (12 == arr[wy][wx + 1] && 8 == arr[wy][wx + 2]) {// ���� Ŀ������ �յ�
				arr[wy][wx + 1] = 8;// ʹ��4����Ƿ�����
				arr[wy][wx + 2] = 12;
			}
			sheeps[wy][wx + 2] = sheeps[wy][wx + 1];// �������λ��
			sheeps[wy][wx + 2].setLocation(12 + 50 * (wx + 2), 36 + 50 * wy);// �����ƶ�
			sheeps[wy][wx + 1] = null;
			wx++;
			Icon i = new ImageIcon("./src/pic/wolf_you.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x + index, y);
			
			//�������ж�
			victory();

		}

		// ����
		if (e.getKeyCode() == 37) {

			if (1 == arr[wy][wx - 1]) {// ������
				return;
			}
			if (4 == arr[wy][wx - 1] && 1 == arr[wy][wx - 2]) {// �������� ��ľ
				return;
			}
			if (4 == arr[wy][wx - 1] && 4 == arr[wy][wx - 2]) {// �������� ����
				return;
			}
			if (4 == arr[wy][wx - 1] && 12 == arr[wy][wx - 2]) {// �������� Ŀ������
				return;
			}
			if (12 == arr[wy][wx - 1] && 1 == arr[wy][wx - 2]) {// ����Ŀ������ ��ľ
				return;
			}
			if (12 == arr[wy][wx - 1] && 4 == arr[wy][wx - 2]) {// ����Ŀ������ ����
				return;
			}
			if (12 == arr[wy][wx - 1] && 12 == arr[wy][wx - 2]) {// ����Ŀ������ Ŀ������
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy][wx - 1]) {// �����յ�
				wx--;
				Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x - index, y);
				return;
			}
			if (8 == arr[wy][wx - 1]) {// ������Ŀ��
				wx--;
				Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x - index, y);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy][wx - 1] && 0 == arr[wy][wx - 2]) {// ���� ���� �յ�
				arr[wy][wx - 1] = 0;// ʹ��4����Ƿ�����
				arr[wy][wx - 2] = 4;
			}
			if (4 == arr[wy][wx - 1] && 8 == arr[wy][wx - 2]) {// ���� ���� ��Ŀ��
				arr[wy][wx - 1] = 0;// ʹ��4����Ƿ�����
				arr[wy][wx - 2] = 12;
				num++;
			}
			if (12 == arr[wy][wx - 1] && 0 == arr[wy][wx - 2]) {// ���� Ŀ������ �յ�
				arr[wy][wx - 1] = 8;// ʹ��4����Ƿ�����
				arr[wy][wx - 2] = 4;
				num--;
			}
			if (12 == arr[wy][wx - 1] && 8 == arr[wy][wx - 2]) {// ���� Ŀ������ �յ�
				arr[wy][wx - 1] = 8;// ʹ��4����Ƿ�����
				arr[wy][wx - 2] = 12;
			}
			sheeps[wy][wx - 2] = sheeps[wy][wx - 1];// �������λ��
			sheeps[wy][wx - 2].setLocation(12 + 50 * (wx - 2), 36 + 50 * wy);// �����ƶ�
			sheeps[wy][wx - 1] = null;
			wx--;
			Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x - index, y);
			victory();
			return;
		}

		// ����
		if (e.getKeyCode() == 40) {

			if (1 == arr[wy + 1][wx]) {// ������
				return;
			}
			if (4 == arr[wy + 1][wx] && 1 == arr[wy + 2][wx]) {// �������� ��ľ
				return;
			}
			if (4 == arr[wy + 1][wx] && 4 == arr[wy + 2][wx]) {// �������� ����
				return;
			}
			if (4 == arr[wy + 1][wx] && 12 == arr[wy + 2][wx]) {// �������� Ŀ������
				return;
			}
			if (12 == arr[wy + 1][wx] && 1 == arr[wy + 2][wx]) {// ����Ŀ������ ��ľ
				return;
			}
			if (12 == arr[wy + 1][wx] && 4 == arr[wy + 2][wx]) {// ����Ŀ������ ����
				return;
			}
			if (12 == arr[wy + 1][wx] && 12 == arr[wy + 2][wx]) {// ����Ŀ������ Ŀ������
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy + 1][wx]) {// �����յ�
				wy++;
				Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y + index);
				return;
			}
			if (8 == arr[wy + 1][wx]) {// ������Ŀ��
				wy++;
				Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y + index);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy + 1][wx] && 0 == arr[wy + 2][wx]) {// ���� ���� �յ�
				arr[wy + 1][wx] = 0;// ʹ��4����Ƿ�����
				arr[wy + 2][wx] = 4;
			}
			if (4 == arr[wy + 1][wx] && 8 == arr[wy + 2][wx]) {// ���� ���� ��Ŀ��
				arr[wy + 1][wx] = 0;// ʹ��4����Ƿ�����
				arr[wy + 2][wx] = 12;
				num++;
			}
			if (12 == arr[wy + 1][wx] && 0 == arr[wy + 2][wx]) {// ���� Ŀ������ �յ�
				arr[wy + 1][wx] = 8;// ʹ��4����Ƿ�����
				arr[wy + 2][wx] = 4;
				num--;
			}
			if (12 == arr[wy + 1][wx] && 8 == arr[wy + 2][wx]) {// ���� Ŀ������ �յ�
				arr[wy + 1][wx] = 8;// ʹ��4����Ƿ�����
				arr[wy + 2][wx] = 12;
			}
			sheeps[wy + 2][wx] = sheeps[wy + 1][wx];
			sheeps[wy + 1][wx] = null;
			sheeps[wy + 2][wx].setLocation(12 + 50 * wx, 36 + 50 * (wy + 2));
			wy++;
			Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x, y + index);
			victory();
			return;

		}

		// ����
		if (e.getKeyCode() == 38) {

			if (1 == arr[wy - 1][wx]) {// ������
				return;
			}
			if (4 == arr[wy - 1][wx] && 1 == arr[wy - 2][wx]) {// �������� ��ľ
				return;
			}
			if (4 == arr[wy - 1][wx] && 4 == arr[wy - 2][wx]) {// �������� ����
				return;
			}
			if (4 == arr[wy - 1][wx] && 12 == arr[wy - 2][wx]) {// �������� Ŀ������
				return;
			}
			if (12 == arr[wy - 1][wx] && 1 == arr[wy - 2][wx]) {// ����Ŀ������ ��ľ
				return;
			}
			if (12 == arr[wy - 1][wx] && 4 == arr[wy - 2][wx]) {// ����Ŀ������ ����
				return;
			}
			if (12 == arr[wy - 1][wx] && 12 == arr[wy - 2][wx]) {// ����Ŀ������ Ŀ������
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy - 1][wx]) {// �����յ�
				wy--;
				Icon i = new ImageIcon("./src/pic/shang.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y - index);
				return;
			}
			if (8 == arr[wy - 1][wx]) {// ������Ŀ��
				wy--;
				Icon i = new ImageIcon("./src/pic/shang.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y - index);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy - 1][wx] && 0 == arr[wy - 2][wx]) {// ���� ���� �յ�
				arr[wy - 1][wx] = 0;// ʹ��4����Ƿ�����
				arr[wy - 2][wx] = 4;
			}
			if (4 == arr[wy - 1][wx] && 8 == arr[wy - 2][wx]) {// ���� ���� ��Ŀ��
				arr[wy - 1][wx] = 0;// ʹ��4����Ƿ�����
				arr[wy - 2][wx] = 12;
				num++;
			}
			if (12 == arr[wy - 1][wx] && 0 == arr[wy - 2][wx]) {// ���� Ŀ������ �յ�
				arr[wy - 1][wx] = 8;// ʹ��4����Ƿ�����
				arr[wy - 2][wx] = 4;
				num--;
			}
			if (12 == arr[wy - 1][wx] && 8 == arr[wy - 2][wx]) {// ���� Ŀ������ �յ�
				arr[wy - 1][wx] = 8;// ʹ��4����Ƿ�����
				arr[wy - 2][wx] = 12;
			}
			sheeps[wy - 2][wx] = sheeps[wy - 1][wx];
			sheeps[wy - 1][wx] = null;
			sheeps[wy - 2][wx].setLocation(12 + 50 * wx, 36 + 50 * (wy - 2));
			wy--;
			Icon i = new ImageIcon("./src/pic/shang.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x, y - index);
			victory();
			return;

		}
	}

	

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
