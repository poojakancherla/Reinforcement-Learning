import java.util.Random;

public class BasementGrid 
{
	int Base_Height = 10;
	int Base_Width = 10;
	
	char basement[][] = new char[Base_Height][Base_Width];
	
	boolean Donut_on_Map = false;
	
	// We have the top view of basement, where we can see the tiles and the top view of walls. 
	// Tiny Tim cannot run into walls, which will be denoted by 'X'. He can move around in the rest of the spaces.
	
	public void Basement()
	{
		// Creating the outer walls 
		
		for (int i = 0; i < basement[0].length; i++) 
		{
			basement[0][i] = 'X';
		}
		
		for (int i = 0; i < basement[0].length; i++) 
		{
			basement[9][i] = 'X';			
		}
		
		for (int i = 0; i < basement[0].length; i++) 
		{
			basement[i][0] = 'X';			
		}
		
		for (int i = 0; i < basement[0].length; i++) 
		{
			basement[i][9] = 'X';			
		}
		
		
		
		// Creating the inner Walls
		
		basement[6][4] = 'X';
		basement[7][4] = 'X';
		basement[8][4] = 'X';
		basement[4][6] = 'X';
		basement[5][6] = 'X';
		basement[6][6] = 'X';
		basement[2][4] = 'X';
		basement[2][5] = 'X';
		basement[2][6] = 'X';
		basement[2][2] = 'X';
		basement[3][2] = 'X';
		basement[4][2] = 'X';
		
	}
	
	// Method to keep track of the donut drop
	public void drop_donut()
	{
		if (!Donut_on_Map)
		{
			Random r = new Random();
			int Donut_probability = r.nextInt(100);
			
			// Dropping the donut in one of 4 corners
			
			if(Donut_probability < 25) 
			{				
				int corner = r.nextInt(4); // generates prob to select the corner
				
				switch (corner) 
				{
					case 0:
						basement[1][1] = 'D';  // Top left
						break;
						
					case 1:
						basement[1][8] = 'D';  // Top right
						break;
						
					case 2:
						basement[8][1] = 'D';  // Bottom left
						break;
						
					case 3:
						basement[8][8] = 'D';  // Bottom right
						break;
			
					default:
						break;
				}
				
				Donut_on_Map = true; // Donut has been dropped in the basement!
			}
		}		
	}
	
	public void render()  // Deprecated function, initially was used to show the movement of Tim in the base
	{		
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{				
				if(basement[i][j] == '\0')
				{
					System.out.print(" ");
				}
				
				System.out.print(basement[i][j] + "   ");				
			}			
			System.out.println();
		}
	}	
	
}
