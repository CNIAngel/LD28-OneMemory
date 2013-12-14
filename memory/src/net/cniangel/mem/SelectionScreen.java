package net.cniangel.mem;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class SelectionScreen implements Screen {

	MemGame game;
	SpriteBatch batch;
	Rectangle mouseBox;
	Sprite messageImg;
	
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public SelectionScreen(MemGame game) {
		this.game = game;
		this.batch = game.batch;
		
		mouseBox = new Rectangle();
		mouseBox.setPosition(game.w / 2, game.h / 2);
		mouseBox.setWidth(1); mouseBox.setHeight(1);
		
		messageImg = new Sprite(Art.message[0][0]);
		messageImg.setPosition(64, 200);
		
		// I can't type at all tonight
		System.out.println("SELECTION SCREEN LOADED");
		for (int i = 0; i < 7; i++) {
			Card c = new Card(i * 48, 0, i);
			cards.add(c);
		}
		
		// On this screen I'll have the five cards that represent a memory. The player can only select one.
		
	}

	@Override
	public void render(float delta) {
		
		// TODO: Cards need to be objects later so the fancy sliding thing works right.
		
		// Update the mouse's bounding rectangle
		int touchX = Gdx.input.getX();
		int touchY = Gdx.input.getY();
		
		// I don't remember how this works. Check: SHMUP -- It was in the Pet project
		float dotX=(touchX*480)/game.w;
		float dotY=320-(touchY*320/game.h);
		
		mouseBox.setPosition(dotX, dotY);
		
		
		batch.begin();
		
		for (Card c: cards) {
			c.update(delta);
			c.render(batch);
		}
		
		
		for (Card c: cards) {
			if (c.bounds.overlaps(mouseBox)) {
				c.selected = true;
				System.out.println("CARD NUMBER "+c.type+" SELECTED");
				setMessage(c.type);
				messageImg.draw(batch);
				
			} else {
				c.selected = false;
			}
		}
		
		Art.drawFont("I REMEMBER...", batch, 0, game.h - 16);
		
		batch.end();
	}

	
	public void inputCheck() {
		
		
		
		
	}
	
	void setMessage(int type) {
		System.out.println("MESSAGE SELECT VIA TYPE #"+type);
		
		switch(type) {
		case 0: messageImg.set(new Sprite(Art.message[0][0])); messageImg.setPosition(64, 200);  break;
		case 1: messageImg.set(new Sprite(Art.message[0][1])); messageImg.setPosition(64, 200); break;
		case 2: messageImg.set(new Sprite(Art.message[0][2])); messageImg.setPosition(64, 200); break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 6: break;
		}
	}
	
	
	// This is probably important to someone
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
