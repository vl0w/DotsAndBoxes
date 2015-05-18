package ch.hslu.prg2.dotsandboxes.ai;

import java.util.Random;

import ch.hslu.prg2.dotsandboxes.Player;
import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.model.MoveResult;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;

public class RandomArtificialIntelligence implements Player, GameModelListener {

	private GameModel model;
	private PlayerColor playerColor;

	public RandomArtificialIntelligence(PlayerColor playerColor, GameModel model) {
		this.playerColor = playerColor;
		this.model = model;
		model.addModelListener(this);
	}

	@Override
	public void moveDone(GameBoard gameBoard, MoveResult result) {
		// This logic doesn't care
	}

	@Override
	public void moveFailed(Move move) {
		// This logic doesn't care
	}

	@Override
	public void gameEnded() {
		// This logic doesn't care
	}

	@Override
	public void opponentTurn() {
		// This logic doesn't care
	}

	@Override
	public void yourTurn(GameBoard gameBoard) {
		Move move = null;

		while (move == null) {
			Dot dotOne = chooseRandomDot(gameBoard.size() - 1);

			if (lineIsValid(dotOne, dotBelow(dotOne), gameBoard)) {
				move = new Move(dotOne, dotBelow(dotOne), getColor());
			} else if (lineIsValid(dotOne, dotRight(dotOne), gameBoard)) {
				move = new Move(dotOne, dotRight(dotOne), getColor());
			}
		}

		model.handleMove(move);
	}

	@Override
	public PlayerColor getColor() {
		return playerColor;
	}

	private boolean lineIsValid(Dot dotOne, Dot dotTwo, GameBoard gameBoard) {
		boolean dotOneValid = isInGamelatestGameboard(dotOne, gameBoard);
		boolean dotTwoValid = isInGamelatestGameboard(dotTwo, gameBoard);
		boolean lineNotUsed = gameBoard.getLineColor(dotOne, dotTwo) == PlayerColor.NONE;

		return dotOneValid && dotTwoValid && lineNotUsed;
	}

	private boolean isInGamelatestGameboard(Dot dot, GameBoard gameBoard) {
		int x = dot.getX();
		int y = dot.getY();
		int gameBoardSize = gameBoard.size();
		return x >= 0 && y >= 0 && x <= gameBoardSize && y <= gameBoardSize;
	}

	private Dot dotBelow(Dot dot) {
		return new Dot(dot.getX(), dot.getY() + 1);
	}

	private Dot dotRight(Dot dot) {
		return new Dot(dot.getX() + 1, dot.getY());
	}

	private Dot chooseRandomDot(int gameboardSize) {
		int x = randomNumber(gameboardSize);
		int y = randomNumber(gameboardSize);
		return new Dot(x, y);
	}

	private int randomNumber(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}
}
