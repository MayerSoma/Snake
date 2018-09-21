
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * @author Jaryt Bustard
 */
public class Snake implements ActionListener, KeyListener
{

	public static Snake snake;

	public JFrame jframe;

	public RenderPanel renderPanel;

	public Timer timer = new Timer(1, this);

	public static ArrayList<Point> snakeParts = new ArrayList<Point>();
	public static ArrayList<String> snakePartss = new ArrayList<String>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;

	public static int ticks = 0, direction = DOWN, score, tailLength = 0, time, lastDirection;

	public static Point head, cherry;

	public Random random;

	public boolean over = false, paused;

	public static boolean update = false;

	public Dimension dim;

	public Snake()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		jframe.setLocationRelativeTo(null);
		startGame();
		
		

	}

	public void startGame()
	{
		over = false;
		paused = false;
		time = 0;
		score = 0;
		tailLength = 1;
		ticks = 0;
		direction = DOWN;
		head = new Point(1, 1);
		random = new Random();
		snakeParts.clear();
		snakePartss.clear();
		cherry = new Point(random.nextInt(77)+1, random.nextInt(65)+1);
		timer.start();
		
		Computer.createMap();
	}
	public static void start() {
		
		Stage primaryStage = new Stage();
		File f = new File("src/game/introFirst.mp4");
		Media m = new Media(f.toURI().toString());
		MediaPlayer mp = new MediaPlayer(m);
		MediaView mv = new MediaView(mp);
		StackPane root = new StackPane();
		root.getChildren().add(mv);
		
		primaryStage.setScene(new Scene(root,960,540));
		primaryStage.setTitle("Video Playy");
		primaryStage.sizeToScene();
		primaryStage.show();
		mp.play();
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		renderPanel.repaint();
		ticks++;

		if (ticks % 2 == 0 && head != null && !over && !paused)
		{
			time++;
			Computer.createMap();
			
			
			snakeParts.add(new Point(head.x, head.y));
			snakePartss.add(Integer.toString(head.x) +";"+ (Integer.toString(head.y)));
			Computer.shallNotPass();
			Computer.goingAround();
			Computer.goForCherry();
//			if(update=true)
//			{
//				Computer.doNotCrash();
//			}
			
		System.out.println(Snake.head.y+";"+Snake.head.x);
		//System.out.println(Snake.head.y+ ";" +Snake.head.x);
		
									
		
			
			
			if (direction == UP)
			{
				if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1))
				{
					head = new Point(head.x, head.y - 1);
				}
				else
				{
					//over = true;
					Computer.doNotCrash();

				}
			}

			if (direction == DOWN)
			{
				if (head.y + 1 < 67 && noTailAt(head.x, head.y + 1))
				{
					head = new Point(head.x, head.y + 1);
				}
				else
				{
					//over = true;
					Computer.doNotCrash();
				}
			}

			if (direction == LEFT)
			{
				if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y))
				{
					head = new Point(head.x - 1, head.y);
				}
				else
				{
					//over = true;
					Computer.doNotCrash();
				}
			}

			if (direction == RIGHT)
			{
				if (head.x + 1 < 80 && noTailAt(head.x + 1, head.y))
				{
					head = new Point(head.x + 1, head.y);
				}
				else
				{
					//over = true;
					Computer.doNotCrash();
				}
			}

			if (snakeParts.size() > tailLength)
			{
				snakeParts.remove(0);
				

			}
			if (snakePartss.size() > tailLength)
			{
				snakePartss.remove(0);

			}
			

			if (cherry != null)
			{
				if (head.equals(cherry))
				{
					score += 10;
					tailLength++;
					cherry.setLocation(random.nextInt(77)+1, random.nextInt(65)+1);
				//System.out.println(snakePartss);
				//Computer.shallNotPass();
				//Computer.printMap();
					

				}
			}
		}
		
		lastDirection=direction;
	}

	public boolean noTailAt(int x, int y)
	{
		for (Point point : snakeParts)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		Intro.intro();
		
		snake = new Snake();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT)
		{
			direction = LEFT;
		}

		if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT)
		{
			direction = RIGHT;
		}

		if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN)
		{
			direction = UP;
		}

		if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP)
		{
			direction = DOWN;
		}

		if (i == KeyEvent.VK_SPACE)
		{
//			if (over)
//			{
//				
//				over = false;
//			}
//			else
			{
				paused = !paused;
				//Computer.printMap();
			}
		}
		System.out.println(over);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	public static ArrayList<String> snakePartss(int i) {
		// TODO Auto-generated method stub
		return snakePartss;
	}

}
