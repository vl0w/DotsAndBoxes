package ch.hslu.prg2.dotsandboxes.v2.network;

import ch.hslu.prg2.dotsandboxes.game.Move;
import ch.hslu.prg2.dotsandboxes.v2.model.GameModelUpdater;

public class LocalNetworkListener implements NetworkListener {

	private GameModelUpdater modelUpdaterDelegate;

	public LocalNetworkListener(GameModelUpdater modelUpdater) {
		this.modelUpdaterDelegate = modelUpdater;
	}

	@Override
	public void received(Object obj) {
		if (obj instanceof Move) {
			modelUpdaterDelegate.update((Move) obj);
		} else {
			// TODO handle error
		}
	}

}
