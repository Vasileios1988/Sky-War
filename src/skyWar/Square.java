package skyWar;

import java.io.Serializable;
import java.util.ArrayList;

public class Square implements Serializable{

		/**
	 * 
	 */
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Properties  //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
		private static final long serialVersionUID = 1L;
		private int index;
		private boolean mastershipOn;
		private ArrayList <EnemyShip> enemyShips = new ArrayList <EnemyShip> ();
		private boolean enemyshipOn;
		private MasterShip master;
		
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Constructor //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
		
		public Square(int index) {
			setIndex(index);
		}
		
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////  Methods ////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
		
		public String toString() {
			String output = "";
			
			output = "Square number: " + this.index;
			
			return output;
		}//END OF TO STRING 
		
//..........................................................................................................................................
		
		public void addEnemyShip(EnemyShip enemyShip) {  // adding enemy ships to the arrayList
			this.enemyShips.add(enemyShip);
		}//end of add enemy ship

//..........................................................................................................................................
		
		public void removeEnemyShip(EnemyShip enemyShip) { // removing enemy ships from the arrayList
			this.enemyShips.remove(enemyShip);
		}// end of remove enemy ship
		
//..........................................................................................................................................		
		
		public int getNumberOfEnemyShips() { // getting the number of the enemy ships in an arrayList
			return this.enemyShips.size();
		}
		
//........................................................................................................................................
	
		public EnemyShip getAnEnemyShipFromList(EnemyShip enemy) {	// returning a specific enemyShip from the list
			
			
			for(EnemyShip e : this.enemyShips) {
				if(enemy == e) {
					return e;
				}
			}
			return null;
		}
		
//.........................................................................................................................				
			 
		public EnemyShip getenemywithIndex(int num) {// returning aa enemy ship from the position num(index)
			
			return this.enemyShips.get(num);
		}

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////  Getters and Setters //////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
		
		public int getIndex() {
			return this.index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
		

		public boolean isMastershipOn() {
			return this.mastershipOn;
		}

		public void setMastershipOn(boolean mastershipOn) {
			this.mastershipOn = mastershipOn;
		}

		public ArrayList<EnemyShip> getEnemyShips() {
			return this.enemyShips;
		}

		public void setEnemyShips(ArrayList<EnemyShip> enemyShips) {
			this.enemyShips = enemyShips;
		}
		
	
		public boolean isEnemyshipOn() {
			return this.enemyshipOn;
		}

		public void setEnemyshipOn(boolean enemyshipOn) {
			this.enemyshipOn = enemyshipOn;
		}

		public MasterShip getMaster() {
			return this.master;
		}

		public void setMaster(MasterShip master) {
			this.master = master;
		}
	
		
		
}// end of Square Class
