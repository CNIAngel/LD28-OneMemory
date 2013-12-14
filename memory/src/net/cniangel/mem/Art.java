package net.cniangel.mem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * This Art class is something I reuse a lot. It has everything I need at this moment.
 * I can load single textures or whole spritesheets using the loadTexture method
 * I can load animations using my loadAnimation method
 * I can draw a font using my own designed font using the drawFont method
 * @author Grant
 *
 */
public class Art {
	
	public static TextureRegion[][] glyph, cards, message;
	public static Texture bg, gameover, bullet, enemy0, enemy1, enemy2, panel;
	public static String alpha = "ABCDEFGH"+"IJKLMNOP"+"QRSTUVWX"+"YZ.: 123"+"4567890-";
	
	public static void loadAll() {

		// TextureRegions
		glyph = loadTexture("alpha.png", 16, 16);
		cards = loadTexture("card.png", 64, 128);
		message = loadTexture("name.png", 128, 32);
		
		// Texture
		
	}
	
	/**
	 * Method loadTexture
	 * Loads a full texture like a background screen or a single sprite by
	 * providing a path in the art folder.
	 * Example: testTex = loadTexture("test.png");
	 * @param path
	 * @return texS
	 */
	public static Texture loadTexture(String path){
		return new Texture(Gdx.files.internal("data/art/"+path));
	}
	
	/**
	 * Method loadTexture
	 * Loads a full spritesheet for use of tile map rendering and animation.
	 * Prove a path in the art folder, the width of the singular tile, and the 
	 * height of the singular tile.
	 * Example: testTex[][] = loadTexture("test.png", 32, 32);
	 * @param path
	 * @param w
	 * @param h
	 * @return
	 */
	public static TextureRegion[][] loadTexture(String path, int w, int h) {
		Texture tex = new Texture(Gdx.files.internal("data/art/"+path));
		
		int xSlice = tex.getWidth() / w;
		int ySlice = tex.getHeight() / h;
		
		TextureRegion[][] result = new TextureRegion[xSlice][ySlice];
		
		for (int x = 0; x < xSlice; x++) {
			for (int y = 0; y <ySlice; y++) {
				result[x][y] = new TextureRegion(tex, x*w, y*h, w, h);
				result[x][y].flip(false, false);
			}
		}
		return result;
	}
	
	/**
	 * I have to have a loaded set of TextureRegions under the name of glyph for this to work.
	 * @param msg
	 * @param b
	 * @param x
	 * @param y
	 */
	public static void drawFont(String msg, SpriteBatch b, float x, float y) {
		msg=msg.toUpperCase();	
		for(int i=0;i<msg.length();i++){
		int letter=alpha.indexOf(msg.charAt(i));
		int xx=letter%8;
		int yy=letter/8;
		b.draw(glyph[xx][yy], x+i*glyph[xx][yy].getRegionWidth(), y);
		}
	}
	
	/**
	 * I have to have a loaded set of TextureRegions under the name of glyph for this to work.
	 * NOTE: I don't remember if I re-coded this method to support scaling properly
	 * UPDATE: I didn't. Lazy tosser.
	 * @param msg
	 * @param b
	 * @param x
	 * @param y
	 */
	public static void drawFont(String msg, SpriteBatch b, float x, float y, float scale) {
		msg=msg.toUpperCase();	
		for(int i=0;i<msg.length();i++){
		int letter=alpha.indexOf(msg.charAt(i));
		int xx=letter%8;
		int yy=letter/8;
		// What in the fuck does this do? (x+i*glyph[xx][yy].getRegionWidth()) + (glyph[xx][yy].getRegionWidth() * scale)
		// idk but i hope it works
		// fuck it. 16px text is fine in this project okay?
		b.draw(glyph[xx][yy], (x+i*glyph[xx][yy].getRegionWidth()) + (glyph[xx][yy].getRegionWidth() * scale), y, 0, 0, glyph[xx][yy].getRegionWidth(), glyph[xx][yy].getRegionHeight(), scale, scale, 0);
		}
	}
	
	/**
	 * 
	 * @param sheet
	 * @param columns
	 * @param rows
	 * @param animationSpeed
	 * @param flip
	 * @param startRow
	 * @return
	 */
	public static Animation loadAnimation(TextureRegion[][] sheet, int columns, int rows, float animationSpeed, boolean flip, int startRow) {
		
		Animation newAni;
		float tmpSpeed;
		int col = columns, row = rows;
		TextureRegion[] tmp = new TextureRegion[col * row];
		int index = 0;
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				tmp[index++] = sheet[i][j + startRow];
			}
		}
		
		for (int k = 0; k < tmp.length; k++) tmp[k].flip(flip, false);
		
		tmpSpeed = animationSpeed;
		
		newAni = new Animation(tmpSpeed, tmp);
		
		return newAni;
	}
	
}
