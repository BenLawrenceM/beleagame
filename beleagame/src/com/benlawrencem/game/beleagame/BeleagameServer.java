package com.benlawrencem.game.beleagame;

import com.benlawrencem.game.beleagame.level.Level;
import com.benlawrencem.game.beleagame.level.PlayerMovementLevel;
import com.benlawrencem.game.beleagame.net.PlayerMovementServer;

public class BeleagameServer {
	public static void main(String[] args) {
		new BeleagameServer();
	}

	public BeleagameServer() {
		Level level = new PlayerMovementLevel();
		level.init(true);
		PlayerMovementServer.getInstance().startServer();
		(new LevelRunner(level)).start();
	}

	private class LevelRunner extends Thread {
		private Level level;
		private boolean isRunning;

		public LevelRunner(Level level) {
			this.level = level;
			isRunning = true;
		}

		@Override
		public void run() {
			long then = System.currentTimeMillis();
			while(isRunning) {
				try {
					sleep(20);
				} catch (InterruptedException e) {}
				long now = System.currentTimeMillis();
				level.update((int) (now - then));
				then = now;
			}
		}
	}
}