package ch.hslu.prg2.dotsandboxes.v2.view;

import ch.hslu.prg2.dotsandboxes.game.Dot;

public interface GameViewListener {
	void onLineSelected(Dot dotOne, Dot dotTwo);
}
