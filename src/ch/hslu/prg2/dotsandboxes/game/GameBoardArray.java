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
	
	
	public boolean checkSquare(Line a){
		PlayerColor color=a.getColor();
		int position=this.getLinePosition(a);
		int offset=2+size*2;
		int dot1X=a.getDot1().getX();
		int dot1Y=a.getDot1().getY();
		int dot2X=a.getDot2().getX();
		int dot2Y=a.getDot2().getY();
		boolean ret=false;
		
		//Linker Rand
		if((dot1X==0)&&(dot2X==0)){
			if(board[position+1].getColor()!=PlayerColor.NONE){
				if(board[position+2].getColor()!=PlayerColor.NONE){
					if(board[position+offset].getColor()!=PlayerColor.NONE){
						
						if(color==PlayerColor.BLUE){
							this.blueSquares++;
							return ret=true;
						}
						else{
							this.redSquares++;
							return ret=true;
						}		
						
					}
				}	
			}
			return ret;
		}
		
		//Rechter Rand
		if((dot1X==this.size)&&(dot2X==this.size)){
			if(board[position-1].getColor()!=PlayerColor.NONE){
				if(board[position-2].getColor()!=PlayerColor.NONE){
					if(board[position+offset-2].getColor()!=PlayerColor.NONE){
						
						if(color==PlayerColor.BLUE){
							this.blueSquares++;
							return ret=true;
						}
						else{
							this.redSquares++;
							return ret=true;
						}		
						
					}
				}	
			}
			return ret;
		}
		
		//Oberer Rand
		if((dot1Y==0)&&(dot2Y==0)){
			if(board[position+1].getColor()!=PlayerColor.NONE){
				if(board[position-1].getColor()!=PlayerColor.NONE){
					if(board[position+offset-1].getColor()!=PlayerColor.NONE){
						
						if(color==PlayerColor.BLUE){
							this.blueSquares++;
							return ret=true;
						}
						else{
							this.redSquares++;
							return ret=true;
						}		
						
					}
				}	
			}
			return ret;
		}
		
		//Unterer Rand
		if((dot1Y==this.size)&&(dot2Y==this.size)){
			 int n=position-(offset-1)-dot1X;
			 
			 if(board[n].getColor()!=PlayerColor.NONE){
					if(board[n+1].getColor()!=PlayerColor.NONE){
						if(board[n+2].getColor()!=PlayerColor.NONE){
							
							if(color==PlayerColor.BLUE){
								this.blueSquares++;
								return ret=true;
							}
							else{
								this.redSquares++;
								return ret=true;
							}		
							
						}
					}	
			 }
			 return ret;
		}
		
		//Für alle Linien die nicht am Rand liegen
		//Falls es eine Waagrechte Linie ist
			if(dot1Y==dot2Y){
				
				//Oberes Kästchen
				if(board[position-offset].getColor()!=PlayerColor.NONE){
					if(board[position-offset+1].getColor()!=PlayerColor.NONE){
						if(board[position-offset+2].getColor()!=PlayerColor.NONE){
							
							if(color==PlayerColor.BLUE){
								this.blueSquares++;
								ret=true;
							}
							else{
								this.redSquares++;
								ret=true;
							}		
							
						}
					}	
				}
				
				//Unteres Kästchen
				if(board[position-1].getColor()!=PlayerColor.NONE){
					if(board[position+1].getColor()!=PlayerColor.NONE){
						if(board[position+offset-1].getColor()!=PlayerColor.NONE){
							
							if(color==PlayerColor.BLUE){
								this.blueSquares++;
								ret=true;
							}
							else{
								this.redSquares++;
								ret=true;
							}		
							
						}
					}	
				}
				
			return ret;	
				
			}
			
			//Falls es eine senkrechte Linie ist
			if(dot1X==dot2X){
				//anderer Fall da letzte Linie auch miteinbezogen werden muss
				if(dot2Y==size){
					int n=offset-1*dot1X;
					//Linkes Kästchen
					if(board[position-1].getColor()!=PlayerColor.NONE){
						if(board[position-2].getColor()!=PlayerColor.NONE){
							if(board[position+n-2].getColor()!=PlayerColor.NONE){
								
								if(color==PlayerColor.BLUE){
									this.blueSquares++;
									ret=true;
								}
								else{
									this.redSquares++;
									ret=true;
								}		
								
							}
						}	
					}
					
					//Rechtes Kästchen
					if(board[position+1].getColor()!=PlayerColor.NONE){
						if(board[position+2].getColor()!=PlayerColor.NONE){
							if(board[position+n-1].getColor()!=PlayerColor.NONE){
								
								if(color==PlayerColor.BLUE){
									this.blueSquares++;
									ret=true;
								}
								else{
									this.redSquares++;
									ret=true;
								}		
								
							}
						}	
					}
				return ret;
				}
				else{
					//Linkes Kästchen
					if(board[position-1].getColor()!=PlayerColor.NONE){
						if(board[position-2].getColor()!=PlayerColor.NONE){
							if(board[position+offset-2].getColor()!=PlayerColor.NONE){
								
								if(color==PlayerColor.BLUE){
									this.blueSquares++;
									ret=true;
								}
								else{
									this.redSquares++;
									ret=true;
								}		
								
							}
						}	
					}
					
					//Rechtes Kästchen
					if(board[position+1].getColor()!=PlayerColor.NONE){
						if(board[position+2].getColor()!=PlayerColor.NONE){
							if(board[position+offset].getColor()!=PlayerColor.NONE){
								
								if(color==PlayerColor.BLUE){
									this.blueSquares++;
									ret=true;
								}
								else{
									this.redSquares++;
									ret=true;
								}		
								
							}
						}	
					}
					return ret;	
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
