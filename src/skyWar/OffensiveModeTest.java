package skyWar;

import junit.framework.TestCase;

public class OffensiveModeTest extends TestCase {

	public void testMode() {
		GameRules game = new GameRules();
		game.setGameMode(new OffensiveMode());
		
		EnemyShip one = game.generateEnemyShip();
		EnemyShip two = game.generateEnemyShip();
		
		
		
		int rowconflict = 2;
		int colConflict = 2;
		
		game.getGrid().getARow(rowconflict).getASquare(colConflict).setMastershipOn(true);
		game.getGrid().getARow(rowconflict).getASquare(colConflict).addEnemyShip(one);
		game.getGrid().getARow(rowconflict).getASquare(colConflict).addEnemyShip(two);
		
		
		
		game.conflict();
		
		boolean masterOn = game.getGrid().getARow(rowconflict).getASquare(colConflict).isMastershipOn();
		int enemiesOn = 0;
		
		
		
		boolean actual = (masterOn && enemiesOn == game.getGrid().getARow(rowconflict).getASquare(colConflict).getNumberOfEnemyShips() );
		boolean expected = (true && enemiesOn ==0) ;
	
		
		
		assertTrue(actual = expected);
	}

}
