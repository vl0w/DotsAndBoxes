package ch.hslu.prg2.dotsandboxes.ai;

import java.util.Random;

import ch.hslu.prg2.dotsandboxes.game.Dot;
import ch.hslu.prg2.dotsandboxes.game.GameBoard;
import ch.hslu.prg2.dotsandboxes.game.Move;
import ch.hslu.prg2.dotsandboxes.game.PlayerColor;
import ch.hslu.prg2.dotsandboxes.v2.Player;

public class RandomArtificialIntelligence implements Player {

	@Override
	public Move makeMove(GameBoard board) {
		Move move = null;

		while (move == null) {
			Dot dotOne = chooseRandomDot(board.size());

			if (lineIsValid(dotOne, dotAbove(dotOne), board)) {
				move = new Move(dotOne, dotAbove(dotOne));
			} else if (lineIsValid(dotOne, dotBelow(dotOne), board)) {
				move = new Move(dotOne, dotBelow(dotOne));
			} else if (lineIsValid(dotOne, dotLeft(dotOne), board)) {
				move = new Move(dotOne, dotLeft(dotOne));
			} else if (lineIsValid(dotOne, dotRight(dotOne), board)) {
				move = new Move(dotOne, dotRight(dotOne));
			}
		}

		return move;
	}

	@Override
	public void notifyMoved(GameBoard board) {
		// This logic doesn't care :)
	}

	@Override
	public void notifyMoveFailed(GameBoard board) {
		// This logic doesn't care :)
	}

	@Override
	public void notifyGameEnd(GameBoard board) {
		// This logic doesn't care :)
	}

	private boolean lineIsValid(Dot dotOne, Dot dotTwo, GameBoard board) {
		boolean dotOneValid = isInGameBoard(dotOne, board.size());
		boolean dotTwoValid = isInGameBoard(dotTwo, board.size());
		boolean lineNotUsed = board.getLineColor(dotOne, dotTwo) == PlayerColor.NONE;

		return dotOneValid && dotTwoValid && lineNotUsed;
	}

	private boolean isInGameBoard(Dot dot, int gameBoardSize) {
		int x = dot.getX();
		int y = dot.getY();
		return x >= 0 && y >= 0 && x <= gameBoardSize && y <= gameBoardSize
				&& x != y;
	}

	private Dot dotAbove(Dot dot) {
		return new Dot(dot.getX(), dot.getY() - 1);
	}

	private Dot dotBelow(Dot dot) {
		return new Dot(dot.getX(), dot.getY() + 1);
	}

	private Dot dotLeft(Dot dot) {
		return new Dot(dot.getX() - 1, dot.getY());
	}

	private Dot dotRight(Dot dot) {
		return new Dot(dot.getX() + 1, dot.getY());
	}

	private Dot chooseRandomDot(int gameBoardSize) {
		int x = randomNumber(gameBoardSize);
		int y = randomNumber(gameBoardSize);
		return new Dot(x, y);
	}

	private int randomNumber(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}
}
