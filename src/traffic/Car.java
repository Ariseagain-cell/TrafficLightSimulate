package traffic;
//车随红绿灯的方向变化
import java.awt.Image;
import java.util.Date;
import java.util.Random;

public class Car
{
	private int x;   //坐标
	private int y;
	private int width=20;
	private int heigth=30;

	private int type;// 小车的行驶方向
	private double v;//速度
	private Image image;

	private int colour;   //汽车颜色 0:黄色 1：黑色

	private boolean turnRight=false;
	public Car()
	{ // 构造函数
		colour=new Random().nextInt(2);
		type = (int) (((Math.random()) * (new Date().getTime()) * 10) % 4);
		if(new Random().nextInt(4)==0)
		{
			turnRight=true;
		}
		if (type == 0)   //为西-东方向
		{
			x = 0;
			if(turnRight)
			{
				y = 255+2;
			}
			else
			{
				y=230+2;
			}
			width=30;
			heigth=20;
			image=CarImage.getCar_RightImage(colour);
		}
		else if (type == 1)   //为东-西方向；
		{
			x = 1500;
			if(turnRight)
			{
				y = 180+2;
			}
			else
			{
				y=205+2;
			}
			width=30;
			heigth=20;
			image=CarImage.getCar_LeftImage(colour);
		}
		else if (type == 2)   //为北-南方向；
		{
			if(turnRight)
			{
				x = 220+2;
			}
			else
			{
				x = 245+2;
			}
			y = 0;
			width=20;
			heigth=30;
			image=CarImage.getCar_DownImage(colour);
		}
		else if (type == 3)   //为南-北方向
		{
			if(turnRight)
			{
				x = 295+2;
			}
			else
			{
				x = 270+2;
			}
			y = 1500;
			width=20;
			heigth=30;
			image=CarImage.getCar_UpImage(colour);
		}
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;

		if (type == 0)   //为西-东方向
		{
			width=30;
			heigth=20;
			image=CarImage.getCar_RightImage(colour);
		}
		else if (type == 1)   //为东-西方向；
		{
			width=30;
			heigth=20;
			image=CarImage.getCar_LeftImage(colour);
		}
		else if (type == 2)   //为北-南方向；
		{
			width=20;
			heigth=30;
			image=CarImage.getCar_DownImage(colour);
		}
		else if (type == 3)   //为南-北方向
		{
			width=20;
			heigth=30;
			image=CarImage.getCar_UpImage(colour);
		}

	}

	public double getV()
	{
		return v;
	}

	public void setV(double v)
	{
		this.v = v;
	}

	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeigth()
	{
		return heigth;
	}

	public void setHeigth(int heigth)
	{
		this.heigth = heigth;
	}

	public boolean isTurnRight()
	{
		return turnRight;
	}

	public void setTurnRight(boolean turnRight)
	{
		this.turnRight = turnRight;
	}


}
