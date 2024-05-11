import java.util.Scanner;


//May the odds be in your favor
public class Battleship {
	public static void main(String[] args) {
		System.out.println("Welcome to Battleship!\n");
		try (Scanner input = new Scanner(System.in)){
			char[][] bs_board1 = new char[5][5];
			char[][] bs_board2 = new char[5][5];
			int shipCount1 = 5;
			int shipCount2 = 5;
			int hitLoca[] = new int[2];
			int[][] location1 = new int[5][2];
			int[][] location2 = new int[5][2];
			char[][] bs_board1ref = new char[5][5];
			char[][] bs_board2ref = new char[5][5];


			//Initializes boards to "-"
			initBoard(bs_board1);
			initBoard(bs_board2);


			//Players select the location of their battleships
			for (int player = 1; player < 3; player++){
				System.out.println("PLAYER " + player + ", ENTER YOUR SHIPS'COORDINATES.");
				for(int i = 0; i < 5; i++){
					System.out.println("Enter ship " + (i+1) + " location:");


					//Player 1
					if (player == 1){
						location1 [i][0] = input.nextInt();
						location1 [i][1] = input.nextInt();


						//Checks for invalid coordinates
						if (location1[i][0]>4 || location1[i][0]<0 || location1[i][1]>4 || location1[i][1]<0){
						System.out.println("Invalid coordinates. Choose different coordinates.");
						i--;
						}


						//Checks for duplicate coordinates
						for(int j = 0; j < i; j++){
							if (location1[i][0] == location1[j][0] && location1[i][1] == location1[j][1]){
							System.out.println("You already have a ship there. Choose different coordinates.");
							i--;
							}
							else{
								continue;
							}
						}


						//Ship location to board
						bs_board1[location1[i][0]][location1[i][1]] = '@';
					} 


					//Player 2
					else{
						location2 [i][0] = input.nextInt();
						location2 [i][1] = input.nextInt();


						//Checks for invalid coordinates
						if (location2[i][0]>4 || location2[i][0]<0 || location2[i][1]>4 || location2[i][1]<0){
						System.out.println("Invalid coordinates. Choose different coordinates.");
						i--;
						}


						//Checks for duplicate coordinates
						for(int j = 0; j < i; j++){
							if (location2[i][0] == location2[j][0] && location2[i][1] == location2[j][1]){
							System.out.println("You already have a ship there. Choose different coordinates.");
							i--;
							}
							else{
								continue;
							}
						}


						//Ship location to board
						bs_board2[location2[i][0]][location2[i][1]] = '@';
					}
				}


				//Printing board with selected locations and 100 empty lines...
				if (player == 1){
					printBattleShip(bs_board1);
					print100Lines();
				} else{
					printBattleShip(bs_board2);
					print100Lines();
				}
			}


			//Initializes reference board
			initBoard(bs_board1ref);
			initBoard(bs_board2ref);


			//Players fire at each other
			boolean play = true;
			int playerTurn = 1;
			do{
				System.out.println("Player " + playerTurn + ", enter hit row/column:");
				hitLoca [0] = input.nextInt();
				hitLoca [1] = input.nextInt();


				//Checks for invalid coordinates
				if (hitLoca[0]>4 || hitLoca[0]<0 || hitLoca[1]>4 || hitLoca[1]<0){
					System.out.println("Invalid coordinates. Choose different coordinates.");
					continue;
				}


				//Checks if coordinates meet have already been fired upon
				if (playerTurn == 1){
					if (repeatChar(bs_board1ref, hitLoca)){
						System.out.println("You already fired on this spot. Choose different coordinates.");
						continue;
					}
				} else {
					if (repeatChar(bs_board2ref, hitLoca)){
						System.out.println("You already fired on this spot. Choose different coordinates.");
						continue;
					}
				}
				

				//cycles between players
				if (playerTurn == 1){
					shipCount2 = fireMissle(bs_board2, shipCount2, hitLoca, location2, playerTurn, bs_board1ref);
					playerTurn++;
				} else if (playerTurn == 2) {
					shipCount1 =fireMissle(bs_board1, shipCount1, hitLoca, location1, playerTurn, bs_board2ref);
					playerTurn--;
				} 


				//Declares winner
				if (shipCount1 == 0){
					System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
					System.out.println("Final boards:");
					System.out.println("\n");
					printBattleShip(bs_board2);
					System.out.println("\n");
					printBattleShip(bs_board2ref);
					play = false;
				} 
				else if (shipCount2 == 0){
					System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
					System.out.println("Final boards:");
					System.out.println("\n");
					printBattleShip(bs_board1);
					System.out.println("\n");
					printBattleShip(bs_board1ref);
					play = false;
				}
			} while (play);
		}
	}

	//Initializes board
	private static char[][] initBoard(char [][] bs_board){
		for (int i = 0; i < 5 ; i++){
			for (int x = 0; x < 5; x++){
				bs_board[i][x]='-';
			}
		}
		return bs_board;
	}

	//Changes state of ships on the board after play makes a move
	private static int fireMissle(char [][] bs_board, int shipCount, int [] hitLoca, int [][] location, int player, char [][] bs_boardref){	
		if (isShip(hitLoca, location)){
			bs_board[hitLoca[0]][hitLoca[1]] = 'X';
			bs_boardref[hitLoca[0]][hitLoca[1]] = 'X';
			String printOut = (player == 1) ? "PLAYER 1 HIT PLAYER 2's SHIP!" : "PLAYER 2 HIT PLAYER 1's SHIP!";
			System.out.println(printOut);
			printBattleShip(bs_boardref);
			System.out.println("\n");
			shipCount--;
		} else{
			bs_board[hitLoca[0]][hitLoca[1]] = 'O';
			bs_boardref[hitLoca[0]][hitLoca[1]] = 'O';
			System.out.println("PLAYER " + player + " MISSED!");
			printBattleShip(bs_boardref);
			System.out.println("\n");
		}
		return shipCount;
	} 


	//Checks if coordinates have already been selected
	private static boolean repeatChar(char[][] board, int[] hitLoca){
		boolean isValid = false;
		if (board[hitLoca[0]][hitLoca[1]] == 'X' || board[hitLoca[0]][hitLoca[1]] == 'O'){
			isValid = true;
		}
		return isValid;
	} 
	

	//Determines if there is a ship at the hit location
	private static boolean isShip(int[] hitLoca, int [][] location){
		for(int i = 0; i<5; i++){
			if (hitLoca[0] == location[i][0] && hitLoca[1] == location[i][1]){
				return true;
			}
		}
		return false;
	}


	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}


	//Prints 100 empty lines
	private static void print100Lines(){
		for (int k = 0; k < 100; k++){
			System.out.println("\n");				
		}
	}
}