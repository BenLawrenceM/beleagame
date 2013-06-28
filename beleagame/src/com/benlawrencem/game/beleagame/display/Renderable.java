package com.benlawrencem.game.beleagame.display;

import org.newdawn.slick.Graphics;

public interface Renderable {
	void render(Graphics g, Visibility visibility, float x, float y, float scale);
}