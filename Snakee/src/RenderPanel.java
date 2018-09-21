

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * @author Jaryt Bustard
 */
public class RenderPanel extends JPanel
{

	public static final Color GREEN = new Color(1666073);
	public static final Color WHITE = new Color(16777215);
	public static final Color BLACK = new Color(000000);

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Snake snake = Snake.snake;

		g.setColor(BLACK);
		
		g.fillRect(0, 0, 800, 700);
//		for(int i = 0; i< 67;i++)
//		{
//			for(int j = 0; j< 79;j++)
//			{
//				g.setColor(WHITE);
//				g.fillRect(i, j, 300, 300);
//				g.setColor(BLACK);
//				g.fillRect(i, j+1, 300, 300);
//				j++;
//			}
//		}

		g.setColor(Color.RED);

		for (Point point : Snake.snakeParts)
		{
			g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		}
		
		g.fillRect(Snake.head.x * Snake.SCALE, Snake.head.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		g.setColor(Color.BLUE);
		
		g.fillRect(Snake.cherry.x * Snake.SCALE, Snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		String string = "Score: " + Snake.score + ", Length: " + Snake.tailLength + ", Time: " + Snake.time / 20;
		
		g.setColor(Color.white);
		
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

		string = "Game Over!";

		if (snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}

		string = "Paused!";

		if (snake.paused && !snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}
	}
}
