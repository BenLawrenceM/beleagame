package com.benlawrencem.game.beleagame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Beleagame extends StateBasedGame {
	public static final int LOADING_STATE = 0;
	public static final int GAMEPLAY_STATE = 1;
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Beleagame());
		app.setAlwaysRender(true);
		app.setDisplayMode(800, 600, false);
		app.setMaximumLogicUpdateInterval(40);
		app.start();
	}

	public Beleagame() {
		super("Beleagame");
		addState(new LoadingState(Beleagame.LOADING_STATE));
		addState(new GameplayState(Beleagame.GAMEPLAY_STATE));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		getState(Beleagame.LOADING_STATE).init(container, this);
		getState(Beleagame.GAMEPLAY_STATE).init(container, this);
	}
}