package traffic;
//虚实线描绘
import java.awt.Graphics;

public class DrawImage
{
    public static void drawDashed(Graphics g, int x1, int y1, int x2, int y2)
    {
        int x = x1,y=y1;
        int n = 4;  //实线段长度
        int m = 4;  //虚线段长度

        int tx = 0,ty = 0;

        int c = 0;
        boolean flag = true;  //标记 有没有画完（达到要求的长度）

        int mark_x = 0;  //标记 要画的是 水平线（值为1）
        int mark_y = 0;  //标记 要画的是 垂直线（值为1）
        //要么0，要么 1
        if(x2-x1 != 0)
            mark_x = 1;
        else
            mark_y = 1;

        do
        {
            tx = (int)((c*(n+m) - m)*mark_x + x1 );
            ty = (int)((c*(n+m) - m)*mark_y + y1 );

            if(Math.abs(tx-x1) > Math.abs(x2-x1))
            {
                tx = x2;
                flag = false;
            }
            if(Math.abs(ty - y1) > Math.abs(y2 - y1))
            {
                ty = y2;
                flag = false;
            }
            g.drawLine(x,y,tx,ty);
            x = (int)(c*(n+m)*mark_x + x1 );    //更新 实线段 + 虚线段
            y = (int)(c*(n+m)*mark_y + y1 );

            if(x > x2 || y > y2) break;
            c++;
        }
        while(flag);
    }
}