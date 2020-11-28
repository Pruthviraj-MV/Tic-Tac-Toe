
import java.util.*;


class Main
{
	 static ArrayList<Integer> playerPositions = new  ArrayList<Integer>();
	 static ArrayList<Integer> cpuPositions = new  ArrayList<Integer>();

	 System.out.println("\nWelcome to Tic-Tac-Toe Game\n");

     public static void main(String []args)
     {
		char[] [] demoBoard = 
        { 
            {'1', '|','2', '|','3'},
            {'-', '+','-', '+','-'},
            {'4', '|','5', '|','6'},
            {'-', '+','-', '+','-'},
            {'7', '|','8', '|','9'}
            
        };
        char[] [] gameBoard = 
        { 
            {' ', '|',' ', '|',' '},
            {'-', '+','-', '+','-'},
            {' ', '|',' ', '|',' '},
            {'-', '+','-', '+','-'},
            {' ', '|',' ', '|',' '}
            
        };

		printDemoBoard(demoBoard);        
		
		while (true)
		{
		
		Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter your placement:");
        int playerPos = scan.nextInt();
		while ( playerPositions.contains(playerPos) || cpuPositions.contains(playerPos) )
			{
			 System.out.println("Positon is already taken, enter new position");
			 playerPos = scan.nextInt();
			}
		playerInput(gameBoard, playerPos, "player");

		String result = checkWinner();
		if (result.length() > 0)
			{
				System.out.println(result);
				break;
			}
			

		Random r = new Random();
		System.out.println("\nCPU turn");
        int cpuPos = r.nextInt(9)+1;
		while ( cpuPositions.contains(cpuPos) || playerPositions.contains(cpuPos))
			{
			  cpuPos = r.nextInt(9)+1;
			}
		playerInput(gameBoard, cpuPos, "cpu");

		result = checkWinner();
		if (result.length() > 0)
			{
				System.out.println(result);
				break;
			}
			
        }
     }

	public static void printDemoBoard(char [][] demoBoard)
		{
			System.out.println("Below is the Board Placements");
			for(char[] demoRow : demoBoard)
			{
				for( char demoColumn : demoRow)
				{
					System.out.print(demoColumn);
				}
				System.out.println();
			}
			
		}
	 
    public static void printGameBoard(char [] [] gameBoard )
     {
         for (char[] row : gameBoard)
        {
            for (char column : row)
            {
                System.out.print(column);
            }
            System.out.println("");
        }
     }

	public static void playerInput(char[] [] gameBoard, int pos, String user)
	{
		char place = ' ';
		if (user == "player")
		{
			playerPositions.add(pos);
			place = 'X';
		}
		else if (user == "cpu")
		{
			cpuPositions.add(pos);
			place = 'O';
		}

		switch(pos)
		 {
			case 1 : gameBoard [0] [0] = place;
					break;
			case 2 : gameBoard [0] [2] = place;
					break;
			case 3 : gameBoard [0] [4] = place;
					break;
			case 4 : gameBoard [2] [0] = place;
					break;
			case 5 : gameBoard [2] [2] = place;
					break;
			case 6 : gameBoard [2] [4] = place;
					break;
			case 7 : gameBoard [4] [0] = place;
					break;
			case 8 : gameBoard [4] [2] = place;
					break;
			case 9 : gameBoard [4] [4] = place;
					break;
		 }

		 printGameBoard(gameBoard);
	}

	public static String checkWinner()
	{
	    List toprow = Arrays.asList(1, 2, 3);
		List midrow = Arrays.asList(4, 5, 6);
		List botrow = Arrays.asList(7, 8, 9);
		List rtcol = Arrays.asList(1, 4, 7);
		List midcol = Arrays.asList(2, 5, 8);
		List ltcol = Arrays.asList(3, 6, 9);
		List dia1 = Arrays.asList(1, 5, 9);
		List dia2 = Arrays.asList(3, 5, 7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(toprow);
		winning.add(midrow);
		winning.add(botrow);
		winning.add(rtcol);
		winning.add(midcol);
		winning.add(ltcol);
		winning.add(dia1);
		winning.add(dia2);

		for (List l : winning)
		{
			if(playerPositions.containsAll(l))
			{
				return "Congratulation You Won";
				
			}
			else if(cpuPositions.containsAll(l))
			{
				return "CPU won";
				
			}
			else if (playerPositions.size()+cpuPositions.size() == 9)
			{
				return "Draw";
				
			} 
		}
		return "";

	}

}
