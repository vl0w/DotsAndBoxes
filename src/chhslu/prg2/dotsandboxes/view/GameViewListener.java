package ch.hslu.prg2.dotsandboxes.view;

import ch.hslu.prg2.dotsandboxes.model.Dot;

public interface GameViewListener {
	void onLineSelected(Dot dotOne, Dot dotTwo);
}
