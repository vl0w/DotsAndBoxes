package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.game.Move;
import ch.hslu.prg2.dotsandboxes.v2.model.GameModel;

public class LocalNetworkListenerDelegate implements NetworkListenerDelegate {

	private GameModel modelDelegate;

	public LocalNetworkListenerDelegate(GameModel modelDelegate) {
		this.modelDelegate = modelDelegate;
	}

	@Override
	public void received(Object obj) {
		if (obj instanceof Move) {
			modelDelegate.handleMove((Move) obj);
		} else {
			// TODO handle error
		}
	}

}
