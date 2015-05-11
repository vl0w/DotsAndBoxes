package ch.hslu.prg2.dotsandboxes.game;

public class GameBoardArray implements GameBoard {
		
	private int size;
	private int numberoflines;
	private Line[] board;
	
	public GameBoardArray(){
		
	}
	
	public boolean createBoard(int size){
		//Anhand der Grösse Line Objekte erstellen
		this.size=size;
		int column=size;
		int row=size;
		int numberoflines=size*(size+1)*2;
		board=new Line[numberoflines];
		int position=0;
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				board[position]=new Line(new Dot(i,j),new Dot(i,j+1));
				position++;
				board[position]=new Line(new Dot(i,j),new Dot(i+1,j));
				position++;
			}
			board[position]=new Line(new Dot(i,column),new Dot(i+1,column));
			position++;
			
		}
		for(int z=0;z<column;z++){
			board[position]=new Line(new Dot(row,z),new Dot(row,z+1));
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
