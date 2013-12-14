package net.cniangel.mem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Sfx {

	public static Music game, title, gameover;
	public static Sound flip;
	static long ID = 0;
	
	public static void load(int track) {
		// TODO Auto-generated constructor stub
		switch (track) {
		case 0: title = loadMusic("spacesass.ogg"); break;
		}
	}
	
	public static void play(int track, boolean looping) {
		
		switch (track) {
		case 0: title.play(); title.setLooping(looping); break;
		}
	}
	
	public static void end(int track) {
		switch (track) {
		case 0: title.stop(); title.setLooping(false); break;
		}
	}
	
	public static void setVolume(int track, float volume) {
		switch (track) {
		case 0: game.setVolume(volume); break;
		}
	}
	
	public static void setPitch(float volume, float pitch) {
	ID = flip.play(volume);
	flip.setPitch(ID, pitch);
	}
	
	
	public static Music loadMusic(String name) {
		
		Music music = Gdx.audio.newMusic(Gdx.files.internal("data/sfx/"+name));
		
		return music;
	}
	
	public static Sound loadSound(String name) {
		
		return Gdx.audio.newSound(Gdx.files.internal(name));
	}
	
	public static void dispose() {
		game.dispose();
	}
	
	public static void endAll() {
		game.stop(); game.setLooping(false); 
	}

	public static void play() {
		// TODO Auto-generated method stub
		flip = Gdx.audio.newSound(Gdx.files.internal("data/sfx/flip.ogg"));
		flip.play(1);
	}

}
