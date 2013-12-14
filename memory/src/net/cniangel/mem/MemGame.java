package net.cniangel.mem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MemGame extends Game {

	public SpriteBatch batch;
	public OrthographicCamera cam;
	public float w, h;
	public boolean debug = false, memSelected;
	
	
	// Screens
	SelectionScreen select;
	
	
	@Override
	public void create() {
		// Disable the power of 2 rule
		Texture.setEnforcePotImages(false);

		// Initialize, load, and set shit
		batch = new SpriteBatch();
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		Art.loadAll();
		
		// Set that screen man
		if (select == null) select = new SelectionScreen(this);
		
		setScreen(select);
		
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
