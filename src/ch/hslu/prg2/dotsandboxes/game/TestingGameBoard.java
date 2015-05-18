package ch.hslu.prg2.dotsandboxes.game;

public class TestingGameBoard {
	
	public static void main(String[] args) {
		int z=13;
		GameBoardArray test=new GameBoardArray();
		test.createBoard(4);
		test.createSquares();
		
		System.out.println(test.getBoard().length);
		for(int i=0;i<test.getBoard().length;i++){
			System.out.print(test.getBoard()[i].getDot1().getY());
			System.out.print(test.getBoard()[i].getDot1().getX());
			System.out.print(test.getBoard()[i].getDot2().getY());
			System.out.println(test.getBoard()[i].getDot2().getX());
		}
		System.out.println("Linien des Squares " + z);
		
		System.out.print(test.getSquare(z).getLeft().getDot1());
		System.out.println(test.getSquare(z).getLeft().getDot2());
		
		System.out.print(test.getSquare(z).getTop().getDot1());
		System.out.println(test.getSquare(z).getTop().getDot2());
		
		System.out.print(test.getSquare(z).getRight().getDot1());
		System.out.println(test.getSquare(z).getRight().getDot2());
		
		System.out.print(test.getSquare(z).getBottom().getDot1());
		System.out.println(test.getSquare(z).getBottom().getDot2());
		
		
		//Folgende Position abfrage gibt 0??
		//System.out.println(test.getLinePosition(test.getBoard()[8]));
		//System.out.println(test.checkSquare(test.getBoard()[1]));
		//System.out.println(test.checkSquare(test.getBoard()[9]));
		//System.out.println(test.checkSquare(test.getBoard()[8]));
		//System.out.println(test.checkSquare(test.getBoard()[36]));
		//System.out.println(test.checkSquare(test.getBoard()[21]));
	}
	
}
