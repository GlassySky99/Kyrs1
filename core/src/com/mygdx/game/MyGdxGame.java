package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Bird bird;
	Obstacles obstacles;
	Score score;
	boolean gameOver;
	Texture restarTexture;
	private static Obstacles.WallPair currentWallpair;
	private static int pairCounter;
	/**
	 * объявление и создание объектов
	 */
	@Override
	public void create() {
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		bird.create();
		obstacles = new Obstacles();
		score = new Score();
		score.create();
		gameOver = false;
		restarTexture = new Texture("RestartBtn.png");
		pairCounter = 0;
		currentWallpair = Obstacles.obs[pairCounter];
	}

	/**
	 * рендер игрового поля
	 */
	@Override
	public void render() {
		update();
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		bg.render(batch);
		obstacles.render(batch);
		score.render(batch);
		if (!gameOver) {
			bird.render(batch);
		} else {
			batch.draw(restarTexture, 200, 200);
		}
		batch.end();
	}

	/**
	 * обработка остановки приложения
	 */
		@Override
		public void dispose () {
			batch.dispose();
		}
		public void update () {
			bg.update();
			bird.update();
			obstacles.update();

			for(Obstacles.WallPair wallPair:obstacles.obs) {
				if (wallPair.position.x == bird.position.x){
					score.score++;
				}
			}
			if(bird.position.x > currentWallpair.position.x && bird.position.x < currentWallpair.position.x + 50){
				if(currentWallpair.emtySpace.y >= bird.position.y || currentWallpair.emtySpace.y + currentWallpair.emtySpace.height <= bird.position.y)
					gameOver = true;
			}
			if(bird.position.y < 0 || bird.position.y > 600){
				gameOver = true;
			}
			if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && gameOver){
				recreate();
			}
			if(bird.position.x > currentWallpair.position.x + 50){
				pairCounter++;
				if(pairCounter == 4){
					pairCounter = 0;
				}
				currentWallpair = Obstacles.obs[pairCounter];
			}
		}

	/**
	 * перезапуск уровня при проигрыше
	 */
	public void recreate(){
		bird.recreate();
		obstacles.recreate();
		gameOver = false;
		create();
		}
	}
