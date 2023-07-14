package traffic;
//算法部分
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class RoadPanel extends JPanel
{
	private boolean redStatus = false, greenStatus = false,
			yellowStatus = false;
	int j = 0; // 全局变量，用来记录交通灯已经亮过的时间
	private int redTimes = 8;
	private int greenTimes = 10;
	private int yellowTimes = 3;
	private List<Car> cars = Collections.synchronizedList(new ArrayList<Car>());// 创建一个数组

	// car

	// 因为头上已经引入了指定的包，只要使用类名来创建就可以了， synchronizedList得到的是同步容器
	RoadPanel()
	{ // 构造函数
		setBackground(Color.GREEN);
	}

	public void paint(Graphics g1)
	{
		Image image = createImage(2000, 2000);
		Graphics g = image.getGraphics();// 创建供绘制闭屏图像使用的图形上下文
		Color c = g.getColor();
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, 2000, 2000);// 整一个灰色区域
		g.setColor(new Color(76, 74, 70));
		g.fillRect(0, 180, 2000, 100);// 东西方向
		g.fillRect(220, 0, 100, 1000);// 南北方向

		int[] x_u = { 320, 320, 500, 420 };
		int[] y_u = { 320, 380, 280, 280 };

		int[] x_d = { 60, 120, 220, 220 };
		int[] y_d = { 180, 180, 140, 80 };

		int[] x_r = { 60, 120, 220, 220 };
		int[] y_r = { 280, 280, 320, 380 };

		int[] x_l = { 420, 480, 320, 320 };
		int[] y_l = { 180, 180, 80, 140 };

		Polygon p_u = new Polygon(x_u, y_u, 4);
		Polygon p_d = new Polygon(x_d, y_d, 4);
		Polygon p_r = new Polygon(x_r, y_r, 4);
		Polygon p_l = new Polygon(x_l, y_l, 4);
		// g.drawPolygon(x,y,4);
		g.fillPolygon(p_u);
		g.fillPolygon(p_d);
		g.fillPolygon(p_r);
		g.fillPolygon(p_l);

		g.setColor(Color.yellow);
		g.drawLine(0, 230, 2000, 230);// 东西方向的分隔线
		g.setColor(Color.yellow);
		g.drawLine(270, 0, 270, 1000);// 南北方向的分隔线

		DrawImage.drawDashed(g, 0, 255, 220, 255); // 双车道虚线
		DrawImage.drawDashed(g, 320, 255, 2000, 255);

		DrawImage.drawDashed(g, 0, 205, 220, 205); // 双车道虚线
		DrawImage.drawDashed(g, 320, 205, 2000, 205);

		DrawImage.drawDashed(g, 245, 0, 245, 180); // 双车道虚线
		DrawImage.drawDashed(g, 245, 280, 245, 2000);

		DrawImage.drawDashed(g, 295, 0, 295, 180); // 双车道虚线
		DrawImage.drawDashed(g, 295, 280, 295, 2000);

		g.setColor(Color.lightGray);
		for (int i = 0; i < cars.size(); i++)
		{
			Car car = (Car) cars.get(i);// 获取列表中的车赋给Car类
			g.drawImage(car.getImage(), car.getX(), car.getY(), car.getWidth(),
					car.getHeigth(), null);
			// g.fillOval(car.getX(), car.getY(), 10, 10);
		}
		if (redStatus)
		{// 南北方向红灯亮
			g.setColor(Color.RED);
			g.fillOval(270, 165, 15, 15);// 画圆（交通灯），北面的红灯
			g.fillOval(255, 280, 15, 15);// 南面的红灯
			g.drawString(redTimes - j + "", 250, 178);// 北面的时间
			g.drawString(redTimes - j + "", 270, 293);// 南面的时间

			g.setColor(Color.GREEN);
			g.fillOval(320, 260, 15, 15);// 东面的绿灯
			g.fillOval(205, 185, 15, 15);// 西面绿灯
			g.drawString(redTimes - j + "", 320, 225);// 东面的时间
			g.drawString(redTimes - j + "", 200, 245);// 西面的时间
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillOval(270, 165, 15, 15);
			g.fillOval(255, 280, 15, 15);
			g.fillOval(320, 260, 15, 15);
			g.fillOval(205, 185, 15, 15);
		}
		if (yellowStatus)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(285, 165, 15, 15);// 北面的黄灯
			g.fillOval(240, 280, 15, 15);// 南面的黄灯
			g.drawString(yellowTimes - j + "", 250, 178);
			g.drawString(yellowTimes - j + "", 270, 293);

			g.fillOval(320, 245, 15, 15);// 东面的黄灯
			g.fillOval(205, 200, 15, 15);// 西面的黄灯
			g.drawString(yellowTimes - j + "", 320, 225);
			g.drawString(yellowTimes - j + "", 200, 245);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillOval(285, 165, 15, 15);
			g.fillOval(240, 280, 15, 15);
			g.fillOval(320, 245, 15, 15);
			g.fillOval(205, 200, 15, 15);
		}
		if (greenStatus)
		{
			g.setColor(Color.GREEN);
			g.fillOval(300, 165, 15, 15);
			g.fillOval(225, 280, 15, 15);
			g.drawString(greenTimes - j + "", 250, 178);
			g.drawString(greenTimes - j + "", 270, 293);
			g.setColor(Color.RED);
			g.fillOval(320, 230, 15, 15);
			g.fillOval(205, 215, 15, 15);
			g.drawString(greenTimes - j + "", 320, 225);
			g.drawString(greenTimes - j + "", 200, 245);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillOval(300, 165, 15, 15);
			g.fillOval(225, 280, 15, 15);
			g.fillOval(320, 230, 15, 15);
			g.fillOval(205, 215, 15, 15);
		}
		g.setColor(c);
		g1.drawImage(image, 0, 0, null);
		try
		{
			Thread.sleep(10);
		}
		catch (InterruptedException e)
		{
		}
		repaint();
	}

	public boolean isRedStatus()
	{
		return redStatus;
	}

	public void setRedStatus(boolean redStatus)
	{
		this.redStatus = redStatus;
	}

	public boolean isGreenStatus()
	{
		return greenStatus;
	}

	public void setGreenStatus(boolean greenStatus)
	{
		this.greenStatus = greenStatus;
	}

	public boolean isYellowStatus()
	{
		return yellowStatus;
	}

	public void setYellowStatus(boolean yellowStatus)
	{
		this.yellowStatus = yellowStatus;
	}

	public int getRedTimes()
	{
		return redTimes;
	}

	public void setRedTimes(int redTimes)
	{
		this.redTimes = redTimes;
	}

	public int getGreenTimes()
	{
		return greenTimes;
	}

	public void setGreenTimes(int greenTimes)
	{
		this.greenTimes = greenTimes;
	}

	public int getYellowTimes()
	{
		return yellowTimes;
	}

	public void setYellowTimes(int yellowTimes)
	{
		this.yellowTimes = yellowTimes;
	}

	public List<Car> getCars()
	{
		return cars;
	}

	public void setCars(List<Car> cars)
	{
		this.cars = cars;
	}

	public void lauch()
	{ // 启动线程
		new Thread(new LightThread()).start();
		new Thread(new CarThread()).start();
		new Thread(new CarRunThread()).start();
		setVisible(true);
	}

	class CarThread implements Runnable
	{// 随机产生小车
		public void run()
		{
			while (true)
			{
				cars.add(CarFactory.getCar());
				try
				{
					Thread.sleep((long) (Math.random() * 2000));// random()产生的随机数大于0小于1.0
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	class CarRunThread implements Runnable
	{// 控制小车的行驶
		public void run()
		{
			while (true)
			{
				for (int i = 0; i < cars.size(); i++)
				{
					Car car = (Car) cars.get(i);
					if (car.getType() == 0)
					{
						if (car.getX() > 2000)
						{
							cars.remove(car);
							i--;
							continue;
						}
						if (!car.isTurnRight())
						{
							if (((RoadPanel.this.isGreenStatus() || RoadPanel.this
									.isYellowStatus()) && Math
									.abs(car.getX() - 190) < 5)
									|| hasObstructor(car, cars))
							{
								continue;
							}
							else
							{
								car.setX(car.getX() + 5);
							}
						}
						else
						{
							if (car.getX() >= 50)
							{
								car.setX(car.getX() + 2);
								car.setY(car.getY() + 1);
							}
							else
							{
								car.setX(car.getX() + 5);
							}
							if (car.getX() > 220)
							{
								car.setTurnRight(false);
								car.setType(2);
							}

						}
					}
					else if (car.getType() == 1)
					{
						if (car.getX() < 0)
						{
							cars.remove(car);
							i--;
							continue;
						}
						if (!car.isTurnRight())
						{
							if (((RoadPanel.this.isGreenStatus() || RoadPanel.this
									.isYellowStatus()) && Math
									.abs(car.getX() - 320) < 5)
									|| hasObstructor(car, cars))
							{
								continue;
							}
							else
							{
								car.setX(car.getX() - 5);
							}
						}
						else
						{
							if (car.getX() <= 480)
							{
								car.setX(car.getX() - 2);
								car.setY(car.getY() - 1);
							}
							else
							{
								car.setX(car.getX() - 5);
							}
							if (car.getX() < 300)
							{
								car.setTurnRight(false);
								car.setType(3);
							}

						}
					}
					else if (car.getType() == 2)
					{
						if (car.getY() > 2000)
						{
							cars.remove(car);
							i--;
							continue;
						}
						if (!car.isTurnRight())
						{
							if (((RoadPanel.this.isRedStatus() || RoadPanel.this
									.isYellowStatus()) && Math
									.abs(car.getY() - 150) < 5)
									|| hasObstructor(car, cars))
							{
								continue;
							}
							else
							{
								car.setY(car.getY() + 5);
							}
						}
						else
						{

							if (car.getY() >= 85)
							{
								car.setX(car.getX() - 2);
								car.setY(car.getY() + 1);
							}
							else
							{
								car.setY(car.getY()+5);
							}
							if (car.getY() >= 180)
							{
								car.setTurnRight(false);
								car.setType(1);
							}

						}
					}
					else if (car.getType() == 3)
					{
						if (car.getY() < 0)
						{
							cars.remove(car);
							i--;
							continue;
						}
						if(!car.isTurnRight())
						{
							if (((RoadPanel.this.isRedStatus() || RoadPanel.this
									.isYellowStatus()) && Math
									.abs(car.getY() - 280) < 5)
									|| hasObstructor(car, cars))
							{
								continue;
							}
							else
							{
								car.setY(car.getY() - 5);
							}
						}
						else
						{

							if (car.getY()<360)
							{
								car.setX(car.getX() +2);
								car.setY(car.getY() - 1);
							}
							else
							{
								car.setY(car.getY()-5);
							}
							if (car.getY() <= 260)
							{
								car.setTurnRight(false);
								car.setType(0);
							}

						}
					}
				}
				try
				{
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

		private boolean hasObstructor(Car car, List<Car> cars)
		{// 判断是否有障碍物
			if (car.getType() == 0)
			{// 西->东方向
				for (int i = 0; i < cars.size(); i++)
				{
					Car car2 = (Car) cars.get(i);
					if (car.getY() == car2.getY()) // 是否同车道
					{
						int distance = (car2.getX() - car.getX());
						if (car2.getType() == 0 && distance < 40
								&& distance > 0)
							return true;
					}
				}
			}
			if (car.getType() == 1)
			{// 东->西方向
				for (int i = 0; i < cars.size(); i++)
				{
					Car car2 = (Car) cars.get(i);
					if (car.getY() == car2.getY())
					{
						int distance = (car.getX() - car2.getX());
						if (car2.getType() == 1 && distance < 40
								&& distance > 0)
							return true;
					}
				}
			}
			if (car.getType() == 2)
			{// 北到南方向
				for (int i = 0; i < cars.size(); i++)
				{
					Car car2 = (Car) cars.get(i);
					if (car.getX() == car2.getX())
					{
						int distance = (car2.getY() - car.getY());
						if (car2.getType() == 2 && distance < 40
								&& distance > 0)
							return true;
					}
				}
			}
			if (car.getType() == 3)
			{// 南到北方向
				for (int i = 0; i < cars.size(); i++)
				{
					Car car2 = (Car) cars.get(i);
					if (car.getX() == car2.getX())
					{
						int distance = (car.getY() - car2.getY());
						if (car2.getType() == 3 && distance < 40
								&& distance > 0)
							return true;
					}
				}
			}
			return false;
		}
	}

	public class LightThread implements Runnable
	{// 时间倒计时
		public void run()
		{
			for (int i = 0; i < redTimes + greenTimes + yellowTimes
					+ yellowTimes; i++)
			{
				if (i == 0)
				{
					j = 0;
					redStatus = true;
					greenStatus = false;
					yellowStatus = false;
				}
				else if (i == redTimes)
				{
					j = 0;
					redStatus = false;
					greenStatus = false;
					yellowStatus = true;
				}
				else if (i == redTimes + yellowTimes)
				{
					j = 0;
					redStatus = false;
					greenStatus = true;
					yellowStatus = false;
				}
				else if (i == redTimes + greenTimes + yellowTimes)
				{
					j = 0;
					redStatus = false;
					greenStatus = false;
					yellowStatus = true;
				}
				repaint();
				j++;
				if (i == redTimes + greenTimes + yellowTimes + yellowTimes - 1)
					i = -1;
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
