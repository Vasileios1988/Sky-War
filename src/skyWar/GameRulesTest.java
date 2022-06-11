package skyWar;

import junit.framework.TestCase;

public class GameRulesTest extends TestCase {

	public void testMasterShipEntrance() {
		GameRules game = new GameRules();
		
		game.MasterShipEntrance();
		
		int row = game.getMastersRowPosition();
		int square = game.getMastersSquarePosition();
		
		boolean actual = game.getGrid().getARow(row).getASquare(square).isMastershipOn();
		boolean expected = true;
		
		assertTrue(actual == expected);
	}

	public void testGetMastersRowPosition() {
		GameRules game = new GameRules();
		
		int row = 3;
		int square = 4;
		
		game.getGrid().getARow(row).getASquare(square).setMastershipOn(true);
		
		int rowPosition = game.getMastersRowPosition();
		
		int actual = row;
		int expected = rowPosition;
		
		assertTrue(actual == expected);
	}

	public void testGetMastersSquarePosition() {
		GameRules game = new GameRules();
		
		int row = 3;
		int square = 4;
		
		game.getGrid().getARow(row).getASquare(square).setMastershipOn(true);
		
		int sqPosition = game.getMastersSquarePosition();
		
		int actual = square;
		int expected = sqPosition;
		
		assertTrue(actual == expected);
	}

	public void testMoveMaster() {
		GameRules game = new GameRules();
		
		game.MasterShipEntrance();
		
		int entryRow = game.getMastersRowPosition();
		int entrySquare = game.getMastersSquarePosition();
		
		game.moveMaster();
		
		int rowAfter = game.getMastersRowPosition();
		int squareAfter = game.getMastersSquarePosition();
		
		boolean rowActual = (rowAfter >=1 && rowAfter <= 4) && (rowAfter != entryRow || squareAfter != entrySquare);
		boolean rowExpected = true;
		
		boolean squareActual = (squareAfter >=1 && squareAfter <= 4) && (squareAfter != entrySquare || rowAfter != entryRow);
		boolean squareExpected = true;
		
		assertTrue(rowActual == rowExpected && squareActual == squareExpected);
	}


	public void testEnemyShipEntrance() {
		GameRules game = new GameRules();
		
		
		int row = 1;
		int square = 1;
		boolean enemyOn = false;
	
		game.EnemyShipEntrance();
		
		while(game.getGrid().getARow(row).getASquare(square).getNumberOfEnemyShips() < 1) {
		
			game.EnemyShipEntrance();
		
			if(game.getGrid().getARow(row).getASquare(square).getNumberOfEnemyShips() >=  1) {
				 enemyOn = true;
			}
		}
		
		boolean actual = enemyOn;
		boolean expected = true;
		
		assertTrue(actual == expected);
	}


	public void testGetEnemySquarePositions() {
		GameRules game = new GameRules();
		EnemyShip enemy = new BattleStar();
		
		int row = 2;
		int square = 2;
		
		game.getGrid().getARow(row).getASquare(square).addEnemyShip(enemy);
		
		int sqPosition = game.getEnemySquarePositions(enemy);
		
		int actual = square;
		int expected = sqPosition;
		
		assertTrue(actual == expected);
	}

	public void testGetEnemyRowPositions() {
		GameRules game = new GameRules();
		EnemyShip enemy = new BattleStar();
		
		int row = 2;
		int square = 2;
		
		game.getGrid().getARow(row).getASquare(square).addEnemyShip(enemy);
		
		int rowPosition = game.getEnemyRowPositions(enemy);
		
		int actual = row;
		int expected = rowPosition;
		
		assertTrue(actual == expected);
	}

	public void testMoveEnemyIterator() {
		GameRules game = new GameRules();
		
		EnemyShip enemy = new BattleStar();
		
		
		 game.getGrid().getARow(2).getASquare(4).addEnemyShip(enemy);
		
		int entryRow = game.getEnemyRowPositions(enemy);
		int entrySquare = game.getEnemySquarePositions(enemy);
		
		game.moveEnemyIterator();
		
		int rowAfter = game.getEnemyRowPositions(enemy);
		int squareAfter = game.getEnemySquarePositions(enemy);
		
		boolean rowActual = (rowAfter >=1 && rowAfter <= 4) && (rowAfter != entryRow || squareAfter != entrySquare);
		boolean rowExpected = true;
		
		boolean squareActual = (squareAfter >=1 && squareAfter <= 4) && (squareAfter != entrySquare || rowAfter != entryRow);
		boolean squareExpected = true;
		
		assertTrue(rowActual == rowExpected);
		assertTrue(squareActual == squareExpected);
	}

	public void testValidatingPosition() {
		GameRules game = new GameRules();
		
		int row = 2;
		int square = 3;
		
		int positions [] = game.validatingPosition(row, square);
		
		int newRow = positions[0];
		int newSquare = positions[1];
		
		boolean rowActual = (newRow >=1 && newRow <=4) && (newRow != row || newSquare != square) ;
		boolean rowExpected = true;
		
		boolean squareActual = (newSquare >= 1 && newSquare <= 4) && (newSquare != square || newRow != row);
		boolean squareExpected = true;
		
		assertTrue(rowActual == rowExpected && squareActual == squareExpected);
	}

}
