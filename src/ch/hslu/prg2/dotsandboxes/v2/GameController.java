package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.model.MoveResult;
import ch.hslu.prg2.dotsandboxes.model.PlayerColor;
import ch.hslu.prg2.dotsandboxes.v2.view.GameView;
import ch.hslu.prg2.dotsandboxes.v2.view.GameViewListener;

public class GameController implements GameViewListener, GameModelListener {

	private GameModel model;
	private GameView view;
	private Player currentPlayer;
	private Player waitingPlayer;

	public GameController(GameView localView, GameModel model,
			Player localPlayer, Player opponentPlayer) {
		this.view = localView;
		this.model = model;
		this.currentPlayer = localPlayer;
		this.waitingPlayer = opponentPlayer;

		// Register as observer
		localView.addViewListener(this);
		model.addModelListener(this);
	}

	@Override
	public void moveDone(GameBoard gameBoard, MoveResult result) {
		view.update(gameBoard);

		if (result.isGameFinished()) {
			currentPlayer.gameEnded();
			waitingPlayer.gameEnded();
		}

		if (result.isSquareCompleted()) {
			currentPlayer.yourTurn(gameBoard);
			waitingPlayer.opponentTurn();
		} else {
			switchPlayers();
			currentPlayer.yourTurn(gameBoard);
			waitingPlayer.opponentTurn();
		}
		// TODO
	}

	private void switchPlayers() {
		Player currentPlayer = this.currentPlayer;
		this.currentPlayer = waitingPlayer;
		this.waitingPlayer = currentPlayer;
	}

	@Override
	public void moveFailed(Move move) {
		// TODO check gamestate, notify players
	}

	@Override
	public void onLineSelected(Dot dotOne, Dot dotTwo) {
		PlayerColor playerColor = currentPlayer.getColor();
		Move move = new Move(dotOne, dotTwo, playerColor);
		model.handleMove(move);
	}

	public void start() {
		currentPlayer.yourTurn(model.getCurrentGameBoard());
		waitingPlayer.opponentTurn();
	}

}
