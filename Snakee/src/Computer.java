import java.awt.Point;
import java.util.ArrayList;

public class Computer {
	
	
	public static int[][] map = new int[67][79];
	public static int[][] map2 = new int[67][79];
	public ArrayList<String> snakeParts2 = new ArrayList<String>();
	static String snakeCoordinate;
	

	
	
	// Update the direction of the snake's head
	public static void goForCherry() {
		
		if(Snake.head.y == Snake.cherry.y || Snake.head.x == Snake.cherry.x)
		{
			if(Snake.head.y > Snake.cherry.y && Snake.direction!=Snake.DOWN && Snake.lastDirection!=Snake.DOWN && map2[Snake.head.y-1][Snake.head.x]!=4) 
			{
				Snake.direction = Snake.UP;
				System.out.println("Cherry UP");
			}
			
			if(Snake.head.y < Snake.cherry.y && Snake.direction!=Snake.UP && Snake.lastDirection!=Snake.UP && map2[Snake.head.y+1][Snake.head.x]!=4) 
			{
				Snake.direction = Snake.DOWN;
				System.out.println("Cherry DOWN");
			}
			
			if(Snake.head.x > Snake.cherry.x && Snake.direction!=Snake.RIGHT && Snake.direction!=Snake.DOWN &&
					Snake.lastDirection!=Snake.RIGHT && map2[Snake.head.y][Snake.head.x-1]!=4) 
			{
				Snake.direction = Snake.LEFT;
				System.out.println("Cherry LEFT");
			}
			
			
			
			if(Snake.head.x < Snake.cherry.x && Snake.direction!=Snake.LEFT  && Snake.direction!=Snake.UP &&
					Snake.lastDirection!=Snake.LEFT && map2[Snake.head.y][Snake.head.x+1]!=4)   
			{
				Snake.direction = Snake.RIGHT;
				System.out.println("Cherry RIGHT");
			}
			
			
			
		}
			
	}
	//Creating the maps with a boarder
	public static void createMap() 

	{
		for(int i = 0; i< 67;i++)
		{
			for(int j = 0; j< 79;j++)
			{
				map[i][j]=0;
				map[0][j] = 1;
				map[66][j] = 1;
				map[i][0] = 1;
				map[i][78] = 1;	
				
				map2[i][j]=0;
				map2[0][j] = 1;
				map2[66][j] = 1;
				map2[i][0] = 1;
				map2[i][78] = 1;	
			}
		}
	}
	//Printing the full map
	public static void printMap()
	{
		for(int i = 0; i< 67;i++)
		{
			
			for(int j = 0; j< 79;j++)
			{
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
	}
	//Updating the snake's position, implemented with "1"
	public static void shallNotPass()
	{
		for(int i = 0; i < Snake.snakePartss.size();i++)
		{
			snakeCoordinate=Snake.snakePartss.get(i);
			String[] slice1 = snakeCoordinate.split(";");
			if(map[Integer.parseInt(slice1[1])][Integer.parseInt(slice1[0])] != 1)
			{
			map2[Integer.parseInt(slice1[1])][Integer.parseInt(slice1[0])] = 4;
			}
		}
	}
	//Going around :)
	public static void goingAround()
	{
		//1;1
		if(map[Snake.head.y+1][Snake.head.x]==1 && map[Snake.head.y][Snake.head.x+1]==1 && 
		Snake.direction!=Snake.DOWN &&Snake.direction!=Snake.LEFT && Snake.lastDirection!=Snake.DOWN &&
		map2[Snake.head.y-1][Snake.head.x]!=4) 
		{
			Snake.direction = Snake.UP;
			System.out.println("Turned UP1");
		}
		//0;1
		if(map[Snake.head.y][Snake.head.x+1]==1 &&map[Snake.head.y][Snake.head.x-1]==0  && 
				Snake.direction!=Snake.DOWN && Snake.lastDirection!=Snake.DOWN && map2[Snake.head.y-1][Snake.head.x]!=4) 
		{
			Snake.direction = Snake.UP;
			System.out.println("Turned UP2");
		}
		
		//1;1
		if(map[Snake.head.y-1][Snake.head.x]==1 && map[Snake.head.y][Snake.head.x-1]==1  && 
				Snake.direction!=Snake.UP && Snake.lastDirection!=Snake.UP && map2[Snake.head.y+1][Snake.head.x]!=4) 
		{
			Snake.direction = Snake.DOWN;
			System.out.println("Turned DOWN1");
		}
		//0;1
		if(map[Snake.head.y][Snake.head.x-1]==1  && map[Snake.head.y][Snake.head.x+1]==0 &&
				Snake.direction!=Snake.UP && Snake.lastDirection!=Snake.UP && map2[Snake.head.y+1][Snake.head.x]!=4)  
		{
			Snake.direction = Snake.DOWN;
			System.out.println("Turned DOWN2");
		}
		//1;1
		if(map[Snake.head.y][Snake.head.x+1]==1 && map[Snake.head.y-1][Snake.head.x]==1 &&
				Snake.direction!=Snake.RIGHT && Snake.lastDirection!=Snake.RIGHT && map2[Snake.head.y][Snake.head.x-1]!=4)  
		{
			Snake.direction = Snake.LEFT;
			System.out.println("Turned LEFT1");
		}
		//1;0
		if(map[Snake.head.y-1][Snake.head.x]==1 && map[Snake.head.y][Snake.head.x-1]==0 &&
				Snake.direction!=Snake.RIGHT && Snake.lastDirection!=Snake.RIGHT && map2[Snake.head.y][Snake.head.x-1]!=4)  
		{
			Snake.direction = Snake.LEFT;
			System.out.println("Turned LEFT2");
		}
		
		//1;1
		if(map[Snake.head.y][Snake.head.x-1]==1 && map[Snake.head.y+1][Snake.head.x]==1&&
				Snake.direction!=Snake.LEFT && Snake.lastDirection!=Snake.LEFT && map2[Snake.head.y][Snake.head.x+1]!=4) 
		{
			Snake.direction = Snake.RIGHT;
			System.out.println("Turned RIGHT1");
			
		}
		//0;1
		if( map[Snake.head.y+1][Snake.head.x]==1 && map[Snake.head.y][Snake.head.x-1]==0 &&
				Snake.direction!=Snake.LEFT &&Snake.direction!=Snake.UP && Snake.lastDirection!=Snake.LEFT && map2[Snake.head.y][Snake.head.x+1]!=4) 
		{
			Snake.direction = Snake.RIGHT;
			System.out.println("Turned RIGHT2");
			
		}
	}
	//update for crash
	public static void doNotCrash()
	{

		if(map2[Snake.head.y][Snake.head.x-1]==4 && Snake.lastDirection!=Snake.DOWN  
		&& Snake.direction!=Snake.DOWN && Snake.lastDirection!=Snake.RIGHT && map[Snake.head.y-1][Snake.head.x]!=1)
		{
			Snake.direction = Snake.UP;
			System.out.println("CherryUpdate UP");
		}
		if(map2[Snake.head.y-1][Snake.head.x]==4 && Snake.lastDirection!=Snake.RIGHT &&
				Snake.direction!=Snake.RIGHT && Snake.lastDirection!=Snake.UP && map[Snake.head.y][Snake.head.x-1]!=1)
		{
			Snake.direction = Snake.LEFT;
			System.out.println("CherryUpdate LEFT");
		}
		if(map2[Snake.head.y][Snake.head.x+1]==4 && Snake.lastDirection!=Snake.UP &&
				Snake.direction!=Snake.UP  && Snake.lastDirection!=Snake.LEFT && map[Snake.head.y+1][Snake.head.x]!=1)
		{
			Snake.direction = Snake.DOWN;
			System.out.println("CherryUpdate DOWN");
		}
		if(map2[Snake.head.y-1][Snake.head.x]==4 && Snake.lastDirection!=Snake.LEFT && 
				Snake.direction!=Snake.LEFT && Snake.lastDirection!=Snake.DOWN && map[Snake.head.y][Snake.head.x+1]!=1) 
		{
			Snake.direction = Snake.RIGHT;
			System.out.println("CherryUpdate RIGHT");
		}
		Snake.update=false;
		
	}
}