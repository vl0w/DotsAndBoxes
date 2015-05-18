package ch.hslu.prg2.dotsandboxes.model;

import java.util.ArrayList;
import java.util.List;

public class GameModelImpl implements GameModel {

	private List<GameModelListener> listeners;
	private GameBoardArray gameboard;

	public GameModelImpl(int size) {
		listeners = new ArrayList<>();
		gameboard = new GameBoardArray();
		gameboard.createBoard(size);
		gameboard.createSquares();
	}

	@Override
	public void handleMove(Move move) {
		if (gameboard.setLine(move.getDot1(), move.getDot2(),
				move.getPlayerColor())) {

			boolean squareCompleted = gameboard.setLineinSquare(move.getDot1(),
					move.getDot2());
			boolean gamefinished = gameboard.isGameFinished();

			MoveResult result = new MoveResult(move, gamefinished,
					squareCompleted);
			notifyListenersMoveSucceeded(result);
		} else {
			notifyListenersMoveFailed(move);
		}
	}

	@Override
	public GameBoard getCurrentGameBoard() {
		return gameboard;
	}

	@Override
	public void addModelListener(GameModelListener listener) {
		listeners.add(listener);
	}

	private void notifyListenersMoveSucceeded(MoveResult result) {
		for (GameModelListener listener : listeners) {
			listener.moveDone(gameboard, result);
		}
	}

	private void notifyListenersMoveFailed(Move move) {
		for (GameModelListener listener : listeners) {
			listener.moveFailed(move);
		}
	}

}
