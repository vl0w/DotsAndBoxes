package ch.hslu.prg2.dotsandboxes.game;

public class GameBoardArray implements GameBoard {
		
	private int size;
	private int numberoflines;
	private Line[] board;
	int blueSquares=0;
	int redSquares=0;
	int totalSquares;
	
	public GameBoardArray(){
		
	}
	
	public boolean createBoard(int size){
		//Anhand der Grösse Line Objekte erstellen
		this.size=size;
		this.totalSquares=size*size;
		int column=size;
		int row=size;
		int numberoflines=size*(size+1)*2;
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
	
	
	public void checkSquare(Line a){
		PlayerColor color=a.getColor();
		int dot1X=a.getDot1().getX();
		int dot1Y=a.getDot1().getY();
		int dot2X=a.getDot2().getX();
		int dot2Y=a.getDot2().getY();
		
		if((dot1X==0)&&(dot2X==0)){
			
		}
		
		if((dot1X==this.size)&&(dot2X==this.size)){
			
		}
		
		if((dot1Y==0)&&(dot2Y==0)){
			
		}
		
		if((dot1Y==this.size)&&(dot2Y==this.size)){
			
		}
				
	}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
