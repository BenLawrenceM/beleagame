package com.benlawrencem.game.beleagame.display;

import org.newdawn.slick.Graphics;

import com.benlawrencem.game.beleagame.entity.Entity;
import com.benlawrencem.game.beleagame.level.Tile;

public interface Perspective {
	void render(Graphics g, Entity entity);
	void render(Graphics g, Tile tile);
}