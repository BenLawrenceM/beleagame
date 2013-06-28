package com.benlawrencem.game.beleagame.level;

import com.benlawrencem.game.beleagame.Direction;

public interface TileLevel extends Level {
	Tile getTile(Tile source, Direction dir);
	int getTileWidth();
	int getTileHeight();
}