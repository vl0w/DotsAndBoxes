package ch.hslu.prg2.dotsandboxes.v2;

import ch.hslu.prg2.dotsandboxes.v2.model.GameModelUpdater;

public abstract class LocalPlayer implements Player {
	private GameModelUpdater modelUpdater;

	public LocalPlayer(GameModelUpdater updater) {
		this.modelUpdater = modelUpdater;
	}

	public GameModelUpdater getModelUpdater() {
		return modelUpdater;
	}
}
