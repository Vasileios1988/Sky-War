package skyWar;



import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {
	/**
	 * 
	 */
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Properties  //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final long serialVersionUID = 1L;
	private int index;
	private ArrayList <Square> theRow = new ArrayList <Square> ();
	
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////  Constructor //////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Row(int index) {
		setIndex(index);
		final int NUMBER_OF_SQ = 4;
		
		for(int loop = 1; loop <= NUMBER_OF_SQ; loop++) {
			Square sq = new Square(loop);
			theRow.add(sq);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////  Methods ////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	public String toString() {
		String output = "";
		
		output = "Row number: " + this.index;
		
		return output;
	}
	
	public Square getASquare(int num) { // getting a specific square from a row
		Square sq = new Square(num);
		for(Square tempSquare : this.theRow) {
			if(tempSquare.getIndex() == num) {
				sq = tempSquare;
			}
		}
		return sq;
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

	public ArrayList<Square> getTheRow() {
		return theRow;
	}

	public void setTheRow(ArrayList<Square> theRow) {
		this.theRow = theRow;
	}
	
	
}// end of Row Class
