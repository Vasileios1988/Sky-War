package skyWar;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Random;


public class GameRules implements Serializable {
	/**
	 * 
	 * 
	 * 
	 */
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Properties  //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	private Grid grid; 
	protected GameBehaviour gameMode; 
	boolean move; //observer pattern
	

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Constructor //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public GameRules() {
		grid = new Grid();
		gameMode = new DefensiveMode();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////  Methods ////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * 
	 * 
	 * 
	 * 			MasterShip methods
	 * 
	 * 
	 * 
	 */
	

public void MasterShipEntrance() {	 // enter the master ship in the sky
	
		Random random = new Random();			// generating randome numbers for row and square position
		int numRow = random.nextInt(4) + 1;
		int numSq = random.nextInt(4) + 1;

		//we need to make sure that the numbers wont be 1 for row and 1 for square

		while(numRow == 1 && numSq == 1) {
			random = new Random();
			numRow = random.nextInt(4) + 1;
			numSq = random.nextInt(4) + 1;
		}
		
		this.grid.getARow(numRow).getASquare(numSq).setMastershipOn(true);  //place the mastership on the square
		
		
	}// end of placeMasterShip


//...........................................................................................................................................................................

	public int getMastersRowPosition() { // getting the row position of the mastership
										// we are looping through the grid till we find the boolean mastership on
		int rowPosition = 0;			// return the integer row number

		for(Row tempRow : this.grid.getTheGrid()) {
			for(Square tempS :  tempRow.getTheRow()){
				if(this.grid.getARow(tempRow.getIndex()).getASquare(tempS.getIndex()).isMastershipOn()) {
					rowPosition = tempRow.getIndex();
				}
			}
		}
		
		return rowPosition;
	}// end of getMastersRowPosition
	
//.......................................................................................................................................................
	public int getMastersSquarePosition() { // getting the square position of the mastership
											// we are looping through the grid till we find the boolean mastership on
		int squarePosition = 0;				// return the integer square number
		
		for(Row tempRow : this.grid.getTheGrid()) {
			for(Square tempS :  tempRow.getTheRow()){
				if(this.grid.getARow(tempRow.getIndex()).getASquare(tempS.getIndex()).isMastershipOn()) {
					squarePosition = tempS.getIndex();
				}
			}
		}

		return squarePosition;

	}//end of getMastersSquarePosition
//..........................................................................................................................................................................
	
	
public void moveMaster() {
		
		int row = getMastersRowPosition();			// is storing the row index of the current master ship
		int square = getMastersSquarePosition();	// is storing the square index of the current master ship
		
		int [] positions = validatingPosition(row, square); //is validating the new positions to make sure that the ship won't go out of the sky
															// and return an integer array with 2 numbers - the first representing the row  and the second the column
		
		int newRow = positions[0];
		int newColumn = positions[1];
			
	//after validating the position now we place the mastership on the square - set boolean to true
	this.grid.getARow(newRow).getASquare(newColumn).setMastershipOn(true);
	this.grid.getARow(row).getASquare(square).setMastershipOn(false);

	
	}//end of moveMaster

//...................................................................................................................................................................

/*
 * 
 * 
 * 
 * 
 * 						Enemy ships methods
 * 
 * 
 * 
 * 
 * 
 */

//........................................................................................................................................................

	public EnemyShip generateEnemyShip() { //we are generating an enemy ship - polymorphism
		
		EnemyShip enemy = null;

		Random random = new Random();
		int numRow = random.nextInt(3);

		switch(numRow) {
		case 0:
			enemy = new BattleStar();
			break;
		case 1:
			enemy =  new BattleShooter();
			break;
		case 2:
			enemy =  new BattleCruiser();
			break;
		}

		return enemy;
	} // end of generateEnemyShip

//..........................................................................................................................................................................	
	
	public void EnemyShipEntrance() {
		// one on three chances to enter the sky
		Random random = new Random();
		int chance = random.nextInt(3);

		if(chance == 1) {
			EnemyShip enemyShip = generateEnemyShip();
		
			//every enemy ship enters the sky from the top left corner 
			// aka square = 1 & row = 1
			final int NUM_OF_SQ = 1;
			final int NUM_OF_ROW = 1;

			
			//this.grid.getARow(NUM_OF_ROW).getASquare(NUM_OF_SQ).setEnemyShipOn(true);
			this.grid.getARow(NUM_OF_ROW).getASquare(NUM_OF_SQ).addEnemyShip(enemyShip);
			this.grid.getARow(NUM_OF_ROW).getASquare(NUM_OF_SQ).getAnEnemyShipFromList(enemyShip).setHasMoved(false);
			//this.registerObserver(enemyShip); // observer pattern
		}

	}//end of EnemyShipEntrance
	
//...........................................................................................................................................................................

	public int getEnemySquarePositions(EnemyShip enemy) { 	// getting the square position of an enemyship
															// we are looping through the grid till we find the arraylist that contains that object
															// return the integer square number
		
		int position = 0;
		
		for (Row oneRow : this.grid.getTheGrid()) {
			for (Square oneS : oneRow.getTheRow()) {
				if(oneS.getEnemyShips().contains(enemy)) {
					position =  oneS.getIndex();
				}
				
			}
		}
		return position;
	}//end of getEnemySquarePosition
	
//...........................................................................................................................................................................

	public int getEnemyRowPositions(EnemyShip enemy) {		// getting the square position of an enemyship
															// we are looping through the grid till we find the arraylist that contains that object
															// return the integer row number
		int position = 0;
		
		for (Row oneRow : this.grid.getTheGrid()) {
			for (Square oneS : oneRow.getTheRow()) {
				if(oneS.getEnemyShips().contains(enemy)) {
					position =  oneRow.getIndex();
				}
				
			}
		}
		return position;
	
	}//end of getEnemyRowPosition
	

//..............................................................................................................................................................
	
	public void moveEnemyIterator() {      //we need to find a square that the arraylist of enemy ships is greater than 0
											// we then need to check if the hasMoved boolean of each enemy ship is false
											// if it is false then move it, set the boolean to true and remove it from the list
		for (Row tempCurrentRow : this.grid.getTheGrid()) {

			for (Square tempCurrentSq : tempCurrentRow.getTheRow()) {
				
				if(tempCurrentSq.getNumberOfEnemyShips() > 0) {
					
					for (Iterator <EnemyShip> itr =  tempCurrentSq.getEnemyShips().iterator(); itr.hasNext();) {
						EnemyShip enemy = itr.next();
						if(!enemy.isHasMoved()) {
						int [] positions = validatingPosition(tempCurrentRow.getIndex(), tempCurrentSq.getIndex());
						this.grid.getARow(positions[0]).getASquare(positions[1]).addEnemyShip(enemy);
						this.grid.getARow(positions[0]).getASquare(positions[1]).getAnEnemyShipFromList(enemy).setHasMoved(true);
						itr.remove();
						}
					}	
				}
			}
		}

	}// end of method

//.............................................................................................................................................................
	
/*
 * 
 * 
 * 
 * 					Empty theGrid and tempGrid
 * 
 * 
 * 
 */

	public void setAllHasMovedToFalse() {
		
		
		for (Row tempCurrentRow : this.grid.getTheGrid()) {

			for (Square tempCurrentSq : tempCurrentRow.getTheRow()) {
				
			
					for (EnemyShip enemy : tempCurrentSq.getEnemyShips()) {
						enemy.setHasMoved(false);
						
					}	
				}
			}
		}	
	
//............................................................................................................................................................
/*
 * 
 * 
 * 
 * 
 * 		Validating row and square positions
 * 		make sure the ships won't move out of the sky
 * 
 * 
 * 
 */
//............................................................................................................................................................
public int[] validatingPosition(int row, int column) {
	
	Random random = new Random();
	int currentRow = row;			// is storing the row index of the current master ship
	int currentColumn = column;	// is storing the square index of the current master ship
	
	int newRow = 0;								// is going to store the new row index
	int newColumn = 0;							//is going to store the new square index
	
	// a combination of the number below along with the current row number and square number
	//will make our master ship to move up, down, right, left, up left, down left, down right, up right
	int down = (currentRow + 1);
	int up = (currentRow -1);
	int right = (currentColumn + 1);
	int left = (currentColumn - 1);
	
	
	// we are using a do while loop in order to make the ship to move. We ask the code to generate a random number and that number
	// takes us to an if statement that will assign a value to the newRow and newColumn variables
	do {  
	
		int position = random.nextInt(8) + 1;
		
		if(position == 1) { //moving on row up
			newRow = up;
			newColumn = column;
		}
		if(position == 2) { // moving up and right -diagonal
			newRow = up;
			newColumn = right;
		}
		if(position == 3) { //moving to the right
			newRow = row;
			newColumn = right;	
		}
		if(position == 4) { // moving down and right - diagonal
			newRow = down;
			newColumn = right;
		}
		if(position == 5) { //moving down
			newRow = down;
			newColumn = column;			
		}
		if(position == 6) {// moving down and left - diagonal
			newRow = down;
			newColumn = left;
		}
		if(position == 7) {// moving left
			newRow = row;
			newColumn = left;	
		}
		if(position == 8) {// moving up and left - diagonal
			newRow = up;
			newColumn = left;
		}
		
		//we are now have a value to out newRow and newColumn variables and we need to validate them. Check them 
		// if they give values = 0 or > 4. in that case, because the ship will move out of the sky we will run the code again till
		//we get a position that suits us
		
	}while((newRow < 1 || newRow > 4) || (newColumn < 1 || newColumn > 4));
	
	int [] positions = {newRow,newColumn};
		
	return positions;	
}


//...............................................................................................................................................................
/*
 * 
 * 
 * 
 * 			!! CONFLICT - Strategy Pattern !!
 * 			Setting Defensive - Offensive Mode
 * 
 * 
 * 
 */
//......................................................................................................................................................................
	
	public boolean conflict() {
		return gameMode.mode(this.grid);
	}
	
//.......................................................................................................................................................................
/*
 * 
 * 
 * 					Save / Resume Game
 * 			Serialiazation - Desrealization 
 * 
 * 
 */
//........................................................................................................................................................
	
	public void saveGame(GameRules game) { // we are writing the  game object in a file
		//serialization
		 File theFile = new File("SkyWar.ser");
		 FileOutputStream fos;
		ObjectOutputStream oos;
		
		try {
			
			fos = new FileOutputStream(theFile);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(game);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}// end of saveGame
	
//........................................................................................................................................................
	
	public GameRules resumeGame() { // we write out the game object
		//deserialization
		FileInputStream fis;
		ObjectInputStream ois;
		GameRules theGame = null;
		
		try {
			
			fis = new FileInputStream("SkyWar.ser");
			ois = new ObjectInputStream(fis);
			theGame =  (GameRules) ois.readObject();
			ois.close();
			
			System.out.println("Resume Game");
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return theGame;
	}// end of resumeGame
	
//........................................................................................................................................................
	
	//////////////////////////////////////////////////
	//												//
	//		getters and setters						//
	// 												//
	//////////////////////////////////////////////////

	public Grid getGrid() {
		return this.grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	

	public GameBehaviour getGameMode() {
		return this.gameMode;
	}

	public void setGameMode(GameBehaviour gameMode) {
		this.gameMode = gameMode;
	}

	public boolean isMove() {
		return this.move;
	}

	
}//end of GameRules class
