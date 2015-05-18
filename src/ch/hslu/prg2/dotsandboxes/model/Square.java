package ch.hslu.prg2.dotsandboxes.model;

public class Square {
	private Line left;
	private Line top;
	private Line bottom;
	private Line right;
	private boolean squarefull;
	private int fulllines;
	private PlayerColor owner;

	public Square(Line lineleft, Line linetop, Line lineright, Line linebottom) {
		this.left=lineleft;
		this.top=linetop;
		this.right=lineright;
		this.bottom=linebottom;
		
		squarefull=false;
		fulllines=0;
		owner=PlayerColor.NONE;
	}

	public Line getLeft() {
		return left;
	}
	
	public void setLeftColor(PlayerColor lineleftcolor) {
		this.left.setColor(lineleftcolor);
		fulllines++;
		if(fulllines==4){
			squarefull=true;
			owner=lineleftcolor;
		}		
	}
	
	public Line getTop() {
		return top;
	}
	
	public void setTopColor(PlayerColor linetopcolor) {
		this.top.setColor(linetopcolor);
		fulllines++;
		if(fulllines==4){
			squarefull=true;
			owner=linetopcolor;
		}	
	}
	
	public Line getRight() {
		return right;
	}
	
	public void setRightColor(PlayerColor linerightcolor) {
		this.right.setColor(linerightcolor);
		fulllines++;
		if(fulllines==4){
			squarefull=true;
			owner=linerightcolor;
		}	
	}
	
	public Line getBottom() {
		return bottom;
	}
	
	public void setBottomColor(PlayerColor linebottomcolor) {
		this.bottom.setColor(linebottomcolor);
		fulllines++;
		if(fulllines==4){
			squarefull=true;
			owner=linebottomcolor;
		}	
	}
	
	public boolean isSquareFull(){
		return squarefull;
	}
	
	public PlayerColor getowner(){
		return owner;
	}
}
