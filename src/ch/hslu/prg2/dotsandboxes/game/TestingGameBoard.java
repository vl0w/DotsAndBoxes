package ch.hslu.prg2.dotsandboxes.game;

public class TestingGameBoard {
	
	public static void main(String[] args) {
		GameBoardArray test=new GameBoardArray();
		test.createBoard(4);
		
		System.out.println(test.getBoard().length);
		for(int i=0;i<test.getBoard().length;i++){
			System.out.print(test.getBoard()[i].getDot1().getY());
			System.out.print(test.getBoard()[i].getDot1().getX());
			System.out.print(test.getBoard()[i].getDot2().getY());
			System.out.println(test.getBoard()[i].getDot2().getX());
		}
	}
	
}
