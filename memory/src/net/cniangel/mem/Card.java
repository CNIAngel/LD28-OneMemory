package net.cniangel.mem;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Card {

	Vector2 pos = new Vector2(), nextPos = new Vector2();
	Rectangle bounds = new Rectangle();
	Sprite s = new Sprite();
	int type;
	boolean selected;
	
	// Just made a boolean for when the mouse is over the damn thing instead of calling on the selection screen
	// Forgot the set the bounds for the cards dummy
	public Card( float x, float y, int type) {
		this.pos.x = x;
		this.pos.y = y;
		this.nextPos.set(nextPos);
		this.type = type;
		setCard(type);
		s.setPosition(pos.x, pos.y);
		bounds.set(pos.x, pos.y, s.getWidth(), s.getHeight());
	}
	
	public void update(float delta) {
		if (selected) {
			nextPos.set(pos.x, 48);
		} else {
			nextPos.set(pos.x, 0);
		}
		
		pos.x += (nextPos.x - pos.x) / 30;
		pos.y += (nextPos.y - pos.y) / 30;
		bounds.setPosition(pos);
		s.setPosition(pos.x, pos.y);
	}
	
	public void render(SpriteBatch batch) {
		s.draw(batch);
	}
	
	void setCard(int type) {
		switch (type) {
		case 0: s.set(new Sprite(Art.cards[0][0])); break;
		case 1: s.set(new Sprite(Art.cards[1][0])); break;
		case 2: s.set(new Sprite(Art.cards[2][0])); break;
		case 3: s.set(new Sprite(Art.cards[3][0])); break;
		case 4: s.set(new Sprite(Art.cards[4][0])); break;
		case 5: s.set(new Sprite(Art.cards[5][0])); break;
		case 6: s.set(new Sprite(Art.cards[6][0])); break;
		}
		
		
	}

}
