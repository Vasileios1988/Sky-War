package skyWar;



public interface Observable {

		public void registerObserver(EnemyShip enemy);
		
		public void removeObserver(EnemyShip enemy);
		
		public void notifyObservers();
	
}
