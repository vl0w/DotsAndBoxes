package ch.hslu.prg2.dotsandboxes.game;

import ch.hslu.prg2.dotsandboxes.Dot;
import ch.hslu.prg2.dotsandboxes.PlayerColor;

public interface GameBoard {
	PlayerColor getLineColor(Dot dot1, Dot dot2);
}
