package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.model.Dot;
import ch.hslu.prg2.dotsandboxes.model.GameBoard;
import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.model.Move;
import ch.hslu.prg2.dotsandboxes.view.GameViewListener;

/**
 * @author Hyunkyo Suh, Jonas Hansen
 */
public class RemoteNetworkGate implements GameModel, GameViewListener {

	@Override
	public void onLineSelected(Dot dotOne, Dot dotTwo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMove(Move move) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addModelListener(GameModelListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public GameBoard getCurrentGameBoard() {
		// TODO Auto-generated method stub
		return null;
	}
}
