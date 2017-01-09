package ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/*
 * 显示窗口
 */
public class MyFrame extends Frame implements KeyListener {

	// 箱子推进笼子的个数
	 int num = 0;
	// 总共的箱子数目
	 int total = 3;
	// 场景数据的模拟，使用二维数组模拟
	// 1代表障碍，0代表空地
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
	// 创建一个JLabel用来存储羊
	// 在羊初始化的时候放入羊
	JLabel sheeps[][] = new JLabel[12][16];
	int wx;
	int wy;
	JLabel wolf_Lable;

	// 构造函数
	public MyFrame() {

		// 设置笼子
		setLong();
		// 设置人物
		setWolf();
		// 树木初始化
		treeInit();
		// 小绵羊
		sheepInit();
		// 设置窗口的背景
		BackGroundInit();
		// 设置主窗口
		setMainFrameUI();
		// 设置监听事件
		this.addKeyListener(this);
	}

	// 笼子的制作
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

	// 物体 障碍
	private void sheepInit() {
		Icon i = new ImageIcon("./src/pic/sheep.png");
		JLabel sheepLable1 = new JLabel(i);
		sheepLable1.setBounds(12 + 300, 36 + 100, 50, 50);
		this.add(sheepLable1);
		// 羊的处理(记录羊的位置)
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

	// 树木的初始化
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

	// 设置人物
	private void setWolf() {
		Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
		wolf_Lable = new JLabel(i);
		wx = 2;
		wy = 2;
		wolf_Lable.setBounds(12 + 50 * wx, 36 + 50 * wy, 50, 50);
		this.add(wolf_Lable);
	}

	// 设置窗口的背景
	private void BackGroundInit() {
		Icon icon = new ImageIcon("./src/pic/bg.png");
		JLabel bg_icon = new JLabel(icon);
		bg_icon.setBounds(12, 32, 800, 600);
		this.add(bg_icon);
	}

	// 主窗口的设置
	private void setMainFrameUI() {
		// 設置布局方式为自由(自己指定)
		this.setLayout(null);
		// 设置窗口的位置
		this.setLocation(300, 90);
		// 设置窗口的标题
		this.setTitle("推箱子");
		// 设置窗口大小
		this.setSize(800, 650);
		// 设置窗口可见
		this.setVisible(true);
		// 设置窗口不能最大化
		// this.setResizable(false);
	}
	
	// 胜利的判定函数
	private void victory() {
		if (num == total) {
			// 移除窗体键盘事件，避免用户多余操作
			this.removeKeyListener(this);
			JDialog victory = new JDialog(this, "恭喜你取得了胜利!", true);
			victory.setSize(400, 300);
			victory.setLocationRelativeTo(null);
			victory.setLayout(null);
			JLabel info = new JLabel(new ImageIcon("./src/pic/gg.jpg"));
			info.setBounds(2, 2, 380, 180);
			victory.add(info);
			victory.setVisible(true);
			System.out.println("胜利");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 键盘按下后的操作
		// 上 38 左37 下40 右39
		int x = (int) wolf_Lable.getLocation().getX();
		int y = (int) wolf_Lable.getLocation().getY();
		int index = 50;

		// 向右
		if (e.getKeyCode() == 39) {
			if (1 == arr[wy][wx + 1]) {// 遇到树
				return;
			}
			if (4 == arr[wy][wx + 1] && 1 == arr[wy][wx + 2]) {// 遇到箱子 树木
				return;
			}
			if (4 == arr[wy][wx + 1] && 4 == arr[wy][wx + 2]) {// 遇到箱子 箱子
				return;
			}
			if (4 == arr[wy][wx + 1] && 12 == arr[wy][wx + 2]) {// 遇到箱子 目标箱子
				return;
			}
			if (12 == arr[wy][wx + 1] && 1 == arr[wy][wx + 2]) {// 遇到目标箱子 树木
				return;
			}
			if (12 == arr[wy][wx + 1] && 4 == arr[wy][wx + 2]) {// 遇到目标箱子 箱子
				return;
			}
			if (12 == arr[wy][wx + 1] && 12 == arr[wy][wx + 2]) {// 遇到目标箱子 目标箱子
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy][wx + 1]) {// 遇到空地
				wx++;
				Icon i = new ImageIcon("./src/pic/wolf_you.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x + index, y);
				return;
			}
			if (8 == arr[wy][wx + 1]) {// 遇到空目标
				wx++;
				Icon i = new ImageIcon("./src/pic/wolf_you.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x + index, y);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy][wx + 1] && 0 == arr[wy][wx + 2]) {// 人物 箱子 空地
				arr[wy][wx + 1] = 0;// 使用4标记是否有羊
				arr[wy][wx + 2] = 4;
			}
			if (4 == arr[wy][wx + 1] && 8 == arr[wy][wx + 2]) {// 人物 箱子 空目标
				arr[wy][wx + 1] = 0;// 使用4标记是否有羊
				arr[wy][wx + 2] = 12;
				num++;
			}
			if (12 == arr[wy][wx + 1] && 0 == arr[wy][wx + 2]) {// 人物 目标箱子 空地
				arr[wy][wx + 1] = 8;// 使用4标记是否有羊
				arr[wy][wx + 2] = 4;
				num--;
			}
			if (12 == arr[wy][wx + 1] && 8 == arr[wy][wx + 2]) {// 人物 目标箱子 空地
				arr[wy][wx + 1] = 8;// 使用4标记是否有羊
				arr[wy][wx + 2] = 12;
			}
			sheeps[wy][wx + 2] = sheeps[wy][wx + 1];// 更改羊的位置
			sheeps[wy][wx + 2].setLocation(12 + 50 * (wx + 2), 36 + 50 * wy);// 箱子移动
			sheeps[wy][wx + 1] = null;
			wx++;
			Icon i = new ImageIcon("./src/pic/wolf_you.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x + index, y);
			
			//勝利的判定
			victory();

		}

		// 向左
		if (e.getKeyCode() == 37) {

			if (1 == arr[wy][wx - 1]) {// 遇到树
				return;
			}
			if (4 == arr[wy][wx - 1] && 1 == arr[wy][wx - 2]) {// 遇到箱子 树木
				return;
			}
			if (4 == arr[wy][wx - 1] && 4 == arr[wy][wx - 2]) {// 遇到箱子 箱子
				return;
			}
			if (4 == arr[wy][wx - 1] && 12 == arr[wy][wx - 2]) {// 遇到箱子 目标箱子
				return;
			}
			if (12 == arr[wy][wx - 1] && 1 == arr[wy][wx - 2]) {// 遇到目标箱子 树木
				return;
			}
			if (12 == arr[wy][wx - 1] && 4 == arr[wy][wx - 2]) {// 遇到目标箱子 箱子
				return;
			}
			if (12 == arr[wy][wx - 1] && 12 == arr[wy][wx - 2]) {// 遇到目标箱子 目标箱子
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy][wx - 1]) {// 遇到空地
				wx--;
				Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x - index, y);
				return;
			}
			if (8 == arr[wy][wx - 1]) {// 遇到空目标
				wx--;
				Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x - index, y);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy][wx - 1] && 0 == arr[wy][wx - 2]) {// 人物 箱子 空地
				arr[wy][wx - 1] = 0;// 使用4标记是否有羊
				arr[wy][wx - 2] = 4;
			}
			if (4 == arr[wy][wx - 1] && 8 == arr[wy][wx - 2]) {// 人物 箱子 空目标
				arr[wy][wx - 1] = 0;// 使用4标记是否有羊
				arr[wy][wx - 2] = 12;
				num++;
			}
			if (12 == arr[wy][wx - 1] && 0 == arr[wy][wx - 2]) {// 人物 目标箱子 空地
				arr[wy][wx - 1] = 8;// 使用4标记是否有羊
				arr[wy][wx - 2] = 4;
				num--;
			}
			if (12 == arr[wy][wx - 1] && 8 == arr[wy][wx - 2]) {// 人物 目标箱子 空地
				arr[wy][wx - 1] = 8;// 使用4标记是否有羊
				arr[wy][wx - 2] = 12;
			}
			sheeps[wy][wx - 2] = sheeps[wy][wx - 1];// 更改羊的位置
			sheeps[wy][wx - 2].setLocation(12 + 50 * (wx - 2), 36 + 50 * wy);// 箱子移动
			sheeps[wy][wx - 1] = null;
			wx--;
			Icon i = new ImageIcon("./src/pic/wolf_zuo.png");
			wolf_Lable.setIcon(i);
			wolf_Lable.setLocation(x - index, y);
			victory();
			return;
		}

		// 向下
		if (e.getKeyCode() == 40) {

			if (1 == arr[wy + 1][wx]) {// 遇到树
				return;
			}
			if (4 == arr[wy + 1][wx] && 1 == arr[wy + 2][wx]) {// 遇到箱子 树木
				return;
			}
			if (4 == arr[wy + 1][wx] && 4 == arr[wy + 2][wx]) {// 遇到箱子 箱子
				return;
			}
			if (4 == arr[wy + 1][wx] && 12 == arr[wy + 2][wx]) {// 遇到箱子 目标箱子
				return;
			}
			if (12 == arr[wy + 1][wx] && 1 == arr[wy + 2][wx]) {// 遇到目标箱子 树木
				return;
			}
			if (12 == arr[wy + 1][wx] && 4 == arr[wy + 2][wx]) {// 遇到目标箱子 箱子
				return;
			}
			if (12 == arr[wy + 1][wx] && 12 == arr[wy + 2][wx]) {// 遇到目标箱子 目标箱子
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy + 1][wx]) {// 遇到空地
				wy++;
				Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y + index);
				return;
			}
			if (8 == arr[wy + 1][wx]) {// 遇到空目标
				wy++;
				Icon i = new ImageIcon("./src/pic/wolf_zheng.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y + index);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy + 1][wx] && 0 == arr[wy + 2][wx]) {// 人物 箱子 空地
				arr[wy + 1][wx] = 0;// 使用4标记是否有羊
				arr[wy + 2][wx] = 4;
			}
			if (4 == arr[wy + 1][wx] && 8 == arr[wy + 2][wx]) {// 人物 箱子 空目标
				arr[wy + 1][wx] = 0;// 使用4标记是否有羊
				arr[wy + 2][wx] = 12;
				num++;
			}
			if (12 == arr[wy + 1][wx] && 0 == arr[wy + 2][wx]) {// 人物 目标箱子 空地
				arr[wy + 1][wx] = 8;// 使用4标记是否有羊
				arr[wy + 2][wx] = 4;
				num--;
			}
			if (12 == arr[wy + 1][wx] && 8 == arr[wy + 2][wx]) {// 人物 目标箱子 空地
				arr[wy + 1][wx] = 8;// 使用4标记是否有羊
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

		// 向上
		if (e.getKeyCode() == 38) {

			if (1 == arr[wy - 1][wx]) {// 遇到树
				return;
			}
			if (4 == arr[wy - 1][wx] && 1 == arr[wy - 2][wx]) {// 遇到箱子 树木
				return;
			}
			if (4 == arr[wy - 1][wx] && 4 == arr[wy - 2][wx]) {// 遇到箱子 箱子
				return;
			}
			if (4 == arr[wy - 1][wx] && 12 == arr[wy - 2][wx]) {// 遇到箱子 目标箱子
				return;
			}
			if (12 == arr[wy - 1][wx] && 1 == arr[wy - 2][wx]) {// 遇到目标箱子 树木
				return;
			}
			if (12 == arr[wy - 1][wx] && 4 == arr[wy - 2][wx]) {// 遇到目标箱子 箱子
				return;
			}
			if (12 == arr[wy - 1][wx] && 12 == arr[wy - 2][wx]) {// 遇到目标箱子 目标箱子
				return;
			}
			// -------------------------------------------
			if (0 == arr[wy - 1][wx]) {// 遇到空地
				wy--;
				Icon i = new ImageIcon("./src/pic/shang.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y - index);
				return;
			}
			if (8 == arr[wy - 1][wx]) {// 遇到空目标
				wy--;
				Icon i = new ImageIcon("./src/pic/shang.png");
				wolf_Lable.setIcon(i);
				wolf_Lable.setLocation(x, y - index);
				return;
			}
			// -------------------------------------
			if (4 == arr[wy - 1][wx] && 0 == arr[wy - 2][wx]) {// 人物 箱子 空地
				arr[wy - 1][wx] = 0;// 使用4标记是否有羊
				arr[wy - 2][wx] = 4;
			}
			if (4 == arr[wy - 1][wx] && 8 == arr[wy - 2][wx]) {// 人物 箱子 空目标
				arr[wy - 1][wx] = 0;// 使用4标记是否有羊
				arr[wy - 2][wx] = 12;
				num++;
			}
			if (12 == arr[wy - 1][wx] && 0 == arr[wy - 2][wx]) {// 人物 目标箱子 空地
				arr[wy - 1][wx] = 8;// 使用4标记是否有羊
				arr[wy - 2][wx] = 4;
				num--;
			}
			if (12 == arr[wy - 1][wx] && 8 == arr[wy - 2][wx]) {// 人物 目标箱子 空地
				arr[wy - 1][wx] = 8;// 使用4标记是否有羊
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
