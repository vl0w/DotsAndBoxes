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
		//Anhand der Gr�sse Line Objekte erstellen
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
						this.setLineinSquare(board[i]);
						ret=true;
					}
					
				}
			}
		}		
		return ret;
	}
	
	public void setLineinSquare(Line linie){
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
		}
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
	
//	public void checkSquare(Line a){
//		PlayerColor color=a.getColor();
//		int position=this.getLinePosition(a);
//		int offset=2+size*2;
//		int dot1X=a.getDot1().getX();
//		int dot1Y=a.getDot1().getY();
//		int dot2X=a.getDot2().getX();
//		int dot2Y=a.getDot2().getY();
//		boolean ret=false;
//		
//		//Linker Rand
//		if((dot1X==0)&&(dot2X==0)){
//			if(board[position+1].getColor()!=PlayerColor.NONE){
//				if(board[position+2].getColor()!=PlayerColor.NONE){
//					if(board[position+offset].getColor()!=PlayerColor.NONE){
//						
//						if(color==PlayerColor.BLUE){
//							this.blueSquares++;
//							return ret=true;
//						}
//						else{
//							this.redSquares++;
//							return ret=true;
//						}		
//						
//					}
//				}	
//			}
//			return ret;
//		}
//		
//		//Rechter Rand
//		if((dot1X==this.size)&&(dot2X==this.size)){
//			if(board[position-1].getColor()!=PlayerColor.NONE){
//				if(board[position-2].getColor()!=PlayerColor.NONE){
//					if(board[position+offset-2].getColor()!=PlayerColor.NONE){
//						
//						if(color==PlayerColor.BLUE){
//							this.blueSquares++;
//							return ret=true;
//						}
//						else{
//							this.redSquares++;
//							return ret=true;
//						}		
//						
//					}
//				}	
//			}
//			return ret;
//		}
//		
//		//Oberer Rand
//		if((dot1Y==0)&&(dot2Y==0)){
//			if(board[position+1].getColor()!=PlayerColor.NONE){
//				if(board[position-1].getColor()!=PlayerColor.NONE){
//					if(board[position+offset-1].getColor()!=PlayerColor.NONE){
//						
//						if(color==PlayerColor.BLUE){
//							this.blueSquares++;
//							return ret=true;
//						}
//						else{
//							this.redSquares++;
//							return ret=true;
//						}		
//						
//					}
//				}	
//			}
//			return ret;
//		}
//		
//		//Unterer Rand
//		if((dot1Y==this.size)&&(dot2Y==this.size)){
//			 int n=position-(offset-1)-dot1X;
//			 
//			 if(board[n].getColor()!=PlayerColor.NONE){
//					if(board[n+1].getColor()!=PlayerColor.NONE){
//						if(board[n+2].getColor()!=PlayerColor.NONE){
//							
//							if(color==PlayerColor.BLUE){
//								this.blueSquares++;
//								return ret=true;
//							}
//							else{
//								this.redSquares++;
//								return ret=true;
//							}		
//							
//						}
//					}	
//			 }
//			 return ret;
//		}
//		
//		//F�r alle Linien die nicht am Rand liegen
//		//Falls es eine Waagrechte Linie ist
//			if(dot1Y==dot2Y){
//				
//				//Oberes K�stchen
//				if(board[position-offset].getColor()!=PlayerColor.NONE){
//					if(board[position-offset+1].getColor()!=PlayerColor.NONE){
//						if(board[position-offset+2].getColor()!=PlayerColor.NONE){
//							
//							if(color==PlayerColor.BLUE){
//								this.blueSquares++;
//								ret=true;
//							}
//							else{
//								this.redSquares++;
//								ret=true;
//							}		
//							
//						}
//					}	
//				}
//				
//				//Unteres K�stchen
//				if(board[position-1].getColor()!=PlayerColor.NONE){
//					if(board[position+1].getColor()!=PlayerColor.NONE){
//						if(board[position+offset-1].getColor()!=PlayerColor.NONE){
//							
//							if(color==PlayerColor.BLUE){
//								this.blueSquares++;
//								ret=true;
//							}
//							else{
//								this.redSquares++;
//								ret=true;
//							}		
//							
//						}
//					}	
//				}
//				
//			return ret;	
//				
//			}
//			
//			//Falls es eine senkrechte Linie ist
//			if(dot1X==dot2X){
//				//anderer Fall da letzte Linie auch miteinbezogen werden muss
//				if(dot2Y==size){
//					int n=offset-1*dot1X;
//					//Linkes K�stchen
//					if(board[position-1].getColor()!=PlayerColor.NONE){
//						if(board[position-2].getColor()!=PlayerColor.NONE){
//							if(board[position+n-2].getColor()!=PlayerColor.NONE){
//								
//								if(color==PlayerColor.BLUE){
//									this.blueSquares++;
//									ret=true;
//								}
//								else{
//									this.redSquares++;
//									ret=true;
//								}		
//								
//							}
//						}	
//					}
//					
//					//Rechtes K�stchen
//					if(board[position+1].getColor()!=PlayerColor.NONE){
//						if(board[position+2].getColor()!=PlayerColor.NONE){
//							if(board[position+n-1].getColor()!=PlayerColor.NONE){
//								
//								if(color==PlayerColor.BLUE){
//									this.blueSquares++;
//									ret=true;
//								}
//								else{
//									this.redSquares++;
//									ret=true;
//								}		
//								
//							}
//						}	
//					}
//				return ret;
//				}
//				else{
//					//Linkes K�stchen
//					if(board[position-1].getColor()!=PlayerColor.NONE){
//						if(board[position-2].getColor()!=PlayerColor.NONE){
//							if(board[position+offset-2].getColor()!=PlayerColor.NONE){
//								
//								if(color==PlayerColor.BLUE){
//									this.blueSquares++;
//									ret=true;
//								}
//								else{
//									this.redSquares++;
//									ret=true;
//								}		
//								
//							}
//						}	
//					}
//					
//					//Rechtes K�stchen
//					if(board[position+1].getColor()!=PlayerColor.NONE){
//						if(board[position+2].getColor()!=PlayerColor.NONE){
//							if(board[position+offset].getColor()!=PlayerColor.NONE){
//								
//								if(color==PlayerColor.BLUE){
//									this.blueSquares++;
//									ret=true;
//								}
//								else{
//									this.redSquares++;
//									ret=true;
//								}		
//								
//							}
//						}	
//					}
//					return ret;	
//				}
//			}
//			return ret;	
//		}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
