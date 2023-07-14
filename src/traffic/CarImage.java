package traffic;
//设定车的外观，导入车图片
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class CarImage
{
	public  static Image[]  S2N={Toolkit.getDefaultToolkit().getImage("S2N.jpg"),Toolkit.getDefaultToolkit().getImage("S2N2.jpg")};
	public  static Image[]	N2S={Toolkit.getDefaultToolkit().getImage("N2S.jpg"),Toolkit.getDefaultToolkit().getImage("N2S2.jpg")};
	public  static Image[]  W2E={Toolkit.getDefaultToolkit().getImage("W2E.jpg"),Toolkit.getDefaultToolkit().getImage("W2E2.jpg")};
	public  static Image[]  E2W={Toolkit.getDefaultToolkit().getImage("E2W.jpg"),Toolkit.getDefaultToolkit().getImage("E2W2.jpg")};

	public static Image getCar_UpImage(int colour)
	{
		return S2N[colour];
	}
	public static Image getCar_DownImage(int colour)
	{
		return N2S[colour];
	}

	public  static Image getCar_LeftImage(int colour)
	{
		return W2E[colour];
	}

	public static Image getCar_RightImage(int colour)
	{
		return E2W[colour];
	}


}

