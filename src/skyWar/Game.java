package skyWar;

public class Game {

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Properties  //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	private GameRules skyWar;
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Constructor //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Game() {
		skyWar = new GameRules();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////  Methods ////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		 String output = "Class: Game";
		 return output;
	}
	
//...........................................................................................
	
	public void startButton() {
		skyWar.MasterShipEntrance();	
	}
	
//...........................................................................................
	
	public boolean moveButton() {
		skyWar.moveMaster();
		skyWar.moveEnemyIterator();
		skyWar.setAllHasMovedToFalse();
		boolean gameOver = skyWar.conflict();
		skyWar.EnemyShipEntrance();	
		
		return gameOver;
	}
	
//..........................................................................................
	
	public void saveButton(Game game) {
		skyWar.saveGame(game.skyWar);
	}
	
//..........................................................................................
	
	public GameRules resumeButton() {
		return skyWar.resumeGame();
	}
	
//..........................................................................................
	
	public void defensiveMode() {
		skyWar.gameMode = new DefensiveMode();
	}
	
//..........................................................................................
	
	public void OffensiveMode() {
		skyWar.gameMode = new OffensiveMode();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////  Getters and Setters //////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public GameRules getSkyWar() {
		return this.skyWar;
	}

	public void setSkyWar(GameRules skyWar) {
		this.skyWar = skyWar;
	}
	
}// end of class