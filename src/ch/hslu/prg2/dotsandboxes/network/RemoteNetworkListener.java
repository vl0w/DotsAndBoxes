package ch.hslu.prg2.dotsandboxes.network;

import ch.hslu.prg2.dotsandboxes.model.GameModelListener;
import ch.hslu.prg2.dotsandboxes.v2.Player;

public class RemoteNetworkListener implements NetworkListener {

	private Player localPlayerDelegate;
	private GameModelListener modelListenerDelegate;

	public RemoteNetworkListener(Player localPlayerDelegate,
			GameModelListener modelListenerDelegate) {
		this.localPlayerDelegate = localPlayerDelegate;
		this.modelListenerDelegate = modelListenerDelegate;
	}

	@Override
	public void received(Object obj) {
		// TODO Auto-generated method stub

	}

}
