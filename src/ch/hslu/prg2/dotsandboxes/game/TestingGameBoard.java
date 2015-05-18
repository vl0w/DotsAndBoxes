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
		//Folgende Position abfrage gibt 0??
		System.out.println(test.getLinePosition(test.getBoard()[8]));
		System.out.println(test.checkSquare(test.getBoard()[1]));
		System.out.println(test.checkSquare(test.getBoard()[9]));
		//System.out.println(test.checkSquare(test.getBoard()[8]));
		//System.out.println(test.checkSquare(test.getBoard()[36]));
		//System.out.println(test.checkSquare(test.getBoard()[21]));
	}
	
}
