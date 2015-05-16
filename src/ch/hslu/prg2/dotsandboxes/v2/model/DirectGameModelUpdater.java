package ch.hslu.prg2.dotsandboxes.v2.model;

import ch.hslu.prg2.dotsandboxes.game.Move;

public class DirectGameModelUpdater implements GameModelUpdater {

	private GameModel model;

	public DirectGameModelUpdater(GameModel model) {
		this.model = model;
	}

	@Override
	public void update(Move move) {
		model.handleMove(move);
	}

}
