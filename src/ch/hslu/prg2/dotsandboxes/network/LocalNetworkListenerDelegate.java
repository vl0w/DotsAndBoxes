package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.model.GameModel;
import ch.hslu.prg2.dotsandboxes.model.Move;

/**
 * Delegate incoming objects to GameModel
 */
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
