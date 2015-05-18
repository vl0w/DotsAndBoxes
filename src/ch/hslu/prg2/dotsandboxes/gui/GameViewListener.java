package ch.hslu.prg2.dotsandboxes.gui;

import ch.hslu.prg2.dotsandboxes.model.Dot;

public interface GameViewListener {
	void onLineSelected(Dot dotOne, Dot dotTwo);
}
