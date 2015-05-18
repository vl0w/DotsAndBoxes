package ch.hslu.prg2.dotsandboxes.ai;

import java.util.Random;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.model.MoveResult;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;
import ch.hslu.prg2.dotsandboxes.v2.Player;

public class RandomArtificialIntelligence implements Player, GameModelListener {

	private GameModel model;
	private GameBoard latestGameboard;
	private PlayerColor playerColor;

	public RandomArtificialIntelligence(PlayerColor playerColor, GameModel model) {
		this.playerColor = playerColor;
		this.model = model;
	}

	@Override
	public void moveDone(GameBoard gameBoard, MoveResult result) {
		this.latestGameboard = gameBoard;
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
	public void yourTurn() {
		Move move = null;

		while (move == null) {
			Dot dotOne = chooseRandomDot(latestGameboard.size());

			if (lineIsValid(dotOne, dotAbove(dotOne), latestGameboard)) {
				move = new Move(dotOne, dotAbove(dotOne), getColor());
			} else if (lineIsValid(dotOne, dotBelow(dotOne), latestGameboard)) {
				move = new Move(dotOne, dotBelow(dotOne), getColor());
			} else if (lineIsValid(dotOne, dotLeft(dotOne), latestGameboard)) {
				move = new Move(dotOne, dotLeft(dotOne), getColor());
			} else if (lineIsValid(dotOne, dotRight(dotOne), latestGameboard)) {
				move = new Move(dotOne, dotRight(dotOne), getColor());
			}
		}

		model.handleMove(move);
	}

	@Override
	public PlayerColor getColor() {
		return playerColor;
	}

	private boolean lineIsValid(Dot dotOne, Dot dotTwo,
			GameBoard latestGameboard) {
		boolean dotOneValid = isInGamelatestGameboard(dotOne,
				latestGameboard.size());
		boolean dotTwoValid = isInGamelatestGameboard(dotTwo,
				latestGameboard.size());
		boolean lineNotUsed = latestGameboard.getLineColor(dotOne, dotTwo) == PlayerColor.NONE;

		return dotOneValid && dotTwoValid && lineNotUsed;
	}

	private boolean isInGamelatestGameboard(Dot dot, int gamelatestGameboardSize) {
		int x = dot.getX();
		int y = dot.getY();
		return x >= 0 && y >= 0 && x <= gamelatestGameboardSize
				&& y <= gamelatestGameboardSize && x != y;
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
