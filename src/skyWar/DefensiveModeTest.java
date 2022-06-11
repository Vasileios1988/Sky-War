package skyWar;

import junit.framework.TestCase;

public class DefensiveModeTest extends TestCase {

	public void testMode() {
		GameRules game = new GameRules();
		game.setGameMode(new DefensiveMode());
		
		EnemyShip one = game.generateEnemyShip();
	
		
		
		int rowconflict = 2;
		int colConflict = 2;
		
		game.getGrid().getARow(rowconflict).getASquare(colConflict).setMastershipOn(true);
		game.getGrid().getARow(rowconflict).getASquare(colConflict).addEnemyShip(one);
		
		
		game.conflict();
		
		boolean masterOn = game.getGrid().getARow(rowconflict).getASquare(colConflict).isMastershipOn();
		int enemiesOn = game.getGrid().getARow(rowconflict).getASquare(colConflict).getNumberOfEnemyShips();
		
		boolean actual = (masterOn && (enemiesOn == 0));
		boolean expected = true;
		
		assertTrue(actual = expected);
		
		
		
		
	}

}
