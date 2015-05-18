package ch.hslu.prg2.dotsandboxes.model;

public class MoveResult {
	private boolean gameFinished;
	private boolean squareCompleted;
	private Move move;

	public MoveResult(Move move, boolean gameFinished, boolean squareCompleted) {
		this.move = move;
		this.gameFinished = gameFinished;
		this.squareCompleted = squareCompleted;
	}

	public PlayerColor getPlayerColor() {
		return move.getPlayerColor();
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public boolean isSquareCompleted() {
		return squareCompleted;
	}
}
