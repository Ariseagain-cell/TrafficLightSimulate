package traffic;
//画主界面
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame
{
	private JLabel redlight_label = new JLabel("红灯时间:                  秒");
	private JLabel greenlight_label = new JLabel("绿灯时间:                 秒");
	private JLabel yellowlight_label = new JLabel("黄灯时间:                 秒");
	private JTextField redlight_field = new JTextField();
	private JTextField greenlight_field = new JTextField();
	private JTextField yellowlight_field = new JTextField();
	private JButton btn_set = new JButton("设置");
	private RoadPanel road = new RoadPanel();

	public MainFrame()
	{
		setTitle("十字路口交通模拟程序");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 当点击关闭按钮时，退出
		setSize(600, 600);// 窗口大小
		setLayout(null);
		redlight_label.setBounds(10, 10, 200, 25);// 设置窗口位置和大小，初始位置(10,10)，宽度为200像素，高度为25像素
		redlight_field.setBounds(70, 10, 40, 25);
		greenlight_label.setBounds(150, 10, 200, 25);
		greenlight_field.setBounds(210, 10, 40, 25);
		yellowlight_label.setBounds(280, 10, 200, 25);
		yellowlight_field.setBounds(340, 10, 40, 25);
		add(yellowlight_field);// 往面板中添加各元素
		add(greenlight_field);
		add(redlight_field);
		add(greenlight_label);
		add(yellowlight_label);
		add(redlight_label);
		btn_set.setBounds(400, 10, 80, 25);// 设置按钮的大小，初始位置为（400，10）参数单位为像素
		road.setBounds(0, 50, 2000, 2000);// 整个十字路口的大小
		add(road);
		road.lauch();// 启动路口（包括红绿灯倒计时，往路中随机添加小车和控制小车的行驶方向）
		add(btn_set);
		btn_set.addActionListener(new ActionListener()
		{ // 为按钮注册监听
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int redTimes = Integer.parseInt(redlight_field
							.getText());
					int greenTimes = Integer.parseInt(greenlight_field
							.getText());
					int yellowTimes = Integer
							.parseInt(yellowlight_field.getText());
					road.setRedTimes(redTimes);
					road.setGreenTimes(greenTimes);
					road.setYellowTimes(yellowTimes);
				}
				catch (NumberFormatException e)
				{
					e.printStackTrace();// 用来在屏幕上输出当前异常对象使用的堆栈的轨迹
				}
			}
		});
		setVisible(true);
	}

}



