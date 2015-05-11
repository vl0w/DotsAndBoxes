package ch.hslu.prg2.dotsandboxes.game;

public class TestingGameBoard {
	
	public static void main(String[] args) {
		GameBoardArray test=new GameBoardArray();
		test.createBoard(4);
		Line[] board=test.getBoard();
		System.out.println(board.length);
		for(int i=0;i<board.length;i++){
			System.out.print(board[i].getDot1().getY());
			System.out.print(board[i].getDot1().getX());
			System.out.print(board[i].getDot2().getY());
			System.out.println(board[i].getDot2().getX());
		}
	}
	
}
