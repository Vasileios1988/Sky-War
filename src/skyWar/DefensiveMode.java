
package skyWar;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class DefensiveMode implements GameBehaviour, Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean  mode(Grid grid) {
		
		System.out.println("Defensive Mode");
		
		boolean over = false;
		// we are going to scan through the grid and find where the master ship is. Then we will check if there is
		// if array > 1 == game over
		// if array < 1 remove enemyship
		int numOfenemies = 0;

		for(Row tempRow : grid.getTheGrid()) {
			for(Square tempsq : tempRow.getTheRow()) {
				numOfenemies = tempsq.getNumberOfEnemyShips();
				if(tempsq.isMastershipOn()) {
					if(numOfenemies == 1) {
							tempsq.getEnemyShips().clear();
							System.out.println("MasterShip wins");
							over = false;
						
					}
					if(numOfenemies > 1) {
						tempsq.setMastershipOn(false);
						System.out.println("Game Over");
						JOptionPane.showMessageDialog(null,"GAME OVER");
						over = true;
					}// end of if statement number of enemies >1
				}// end of is mastership on if statement
			}// end of square loop
		}// end of row loop
		return over;
		
	}// end of mode



}// end of class
