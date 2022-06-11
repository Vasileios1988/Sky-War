package skyWar;

import java.io.Serializable;



public class BattleShooter extends EnemyShip implements Serializable{
	
	
	/**
	 * 
	 */
////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Properties  //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Constructor //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

	public BattleShooter() {
		super.setShipKind(3);
	}

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////  Methods ////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		String output = " ";
		
		output = super.toString();
		output = output + "Battle Shooter ";
		
		return output;
	}
}