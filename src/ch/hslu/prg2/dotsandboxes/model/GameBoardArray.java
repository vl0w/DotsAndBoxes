package ch.hslu.prg2.dotsandboxes.model;

public class GameBoardArray implements GameBoard {
		
	private int size;
	private int numberoflines;
	private Line[] board;
	private Square[] squares;
	int totalSquares;
	
	public GameBoardArray(){
		
	}
	
	public void createSquares(){
		int offset=2+size*2;
		squares=new Square[totalSquares];
		int j=0;
		int k=0;
		
		for(int z=0;z<size-1;z++){
			for(int i=0;i<size;i++){
				squares[k]=new Square(board[j], board[j+1], board[j+2], board[j+offset]);
				k++;
				j=j+2;
			}
			j++;
		}
		//Letzte Reihe Squares
		for(int l=0;l<size;l++){
			squares[k]=new Square(board[j], board[j+1], board[j+2], board[numberoflines-size+l]);
			k++;
			j=j+2;
		}
	}
	
	public Square getSquare(int i){
		return squares[i];
	}
	
	public boolean createBoard(int size){
		//Anhand der Groesse Line Objekte erstellen
		this.size=size;
		this.totalSquares=size*size;
		int column=size;
		int row=size;
		numberoflines=size*(size+1)*2;
		board=new Line[numberoflines];
		int position=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				board[position]=new Line(new Dot(j,i),new Dot(j,i+1));
				position++;
				board[position]=new Line(new Dot(j,i),new Dot(j+1,i));
				position++;
			}
			board[position]=new Line(new Dot(column,i),new Dot(column,i+1));
			position++;
			
		}
		for(int z=0;z<column;z++){
			board[position]=new Line(new Dot(z,row),new Dot(z+1,row));
			position++;
		}
		
		return true;
	}
	
	@Override
	public PlayerColor getLineColor(Dot dot1, Dot dot2) {
		PlayerColor ret=PlayerColor.NONE;
		for(int i=0;i<numberoflines;i++){
			if(board[i].getDot1().equals(dot1)){
				if(board[i].getDot2().equals(dot2)){
					ret=board[i].getColor();
					return ret;
				}
			}
		}
		return ret;
	}
	
	
	public int getLinePosition(Line a){
		int ret=0;
		for(int i=0;i<numberoflines;i++){
			if(board[i].equals(a)){
			ret=i;
			}
		}
		return ret;
	}
	
	public Line[] getBoard(){
		return board;
	}
	
	public boolean setLine(Dot dot1, Dot dot2, PlayerColor color){
		boolean ret=false;
		for(int i=0;i<numberoflines;i++){
			if(board[i].getDot1().equals(dot1)){
				if(board[i].getDot2().equals(dot2)){
					if(board[i].getColor().equals(PlayerColor.NONE)){
						board[i].setColor(color);
						return ret=true;
					}
					
				}
			}
		}		
		return ret;
	}
	
	public Line getLinefromDots(Dot dot1, Dot dot2){
		Line ret=null;
		for(int i=0;i<numberoflines;i++){
			if(board[i].getDot1().equals(dot1)){
				if(board[i].getDot2().equals(dot2)){
					ret=board[i];				
				}
			}
		}
		return ret;
	}
	
	public boolean setLineinSquare(Dot dot1, Dot dot2){
		Line linie=getLinefromDots(dot1,dot2);
		boolean ret=false;
	
		for( Square k: squares ){
			if(k.getLeft().equals(linie)){
				k.setLeftColor(linie.getColor());
			}
			else if(k.getTop().equals(linie)){
				k.setTopColor(linie.getColor());
			}
			else if(k.getRight().equals(linie)){
				k.setRightColor(linie.getColor());
			}
			else if(k.getBottom().equals(linie)){
				k.setBottomColor(linie.getColor());
			}
			if(k.isSquareFull()){
				ret=true;
			}
		}
		return ret;
	}
	
	public boolean isGameFinished(){
		int i=0;
		boolean ret=false;
		
		for( Square k: squares ){
			if(k.isSquareFull()){
				i++;
			}
		}
		
		if(i==totalSquares){
			return ret=true;
		}
		return ret;
	}	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
