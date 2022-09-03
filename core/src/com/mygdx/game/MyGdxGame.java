package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.GameObjects.Ball;
import com.mygdx.game.GameObjects.Paddle;

import java.util.ArrayList;
import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	ArrayList<Ball> balls = new ArrayList<>();
	Paddle paddle;
	Random r = new Random();
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		paddle = new Paddle(5, 5, 10, 20);
		for (int i = 0; i < 5; i++) {
			balls.add(new Ball(r.nextInt(Gdx.graphics.getWidth()), r.nextInt(Gdx.graphics.getHeight()),
					           r.nextInt(100), r.nextInt(15), r.nextInt(15)));
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Ball ball : balls) {
			ball.update();
			ball.draw(shapeRenderer);
		}
		paddle.draw(shapeRenderer);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
	}
}
