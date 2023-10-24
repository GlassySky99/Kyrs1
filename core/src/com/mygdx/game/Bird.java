package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    int i = 0;
    Texture img;
    Vector2 position;
    float vy;
    float gravity;
    Texture[] imgs;

    /**
     * отрисовка птицы по заданной кардинате
     */
    public Bird() {
        img = new Texture("bird0.png");
        position = new Vector2(100, 300);
        vy = 0;
        gravity = -0.7f;
    }

    /**
     * метод вывода на экран
     * @param batch текстура и кордината потицы
     */
    public void render(SpriteBatch batch) {
        batch.draw(img, position.x, position.y);
    }

    /**
     * создание объекта
     */
    public void create() {
        imgs = new Texture[4];
        imgs[0] = new Texture("bird1.png");
        imgs[1] = new Texture("bird2.png");
        imgs[2] = new Texture("bird3.png");
        imgs[3] = new Texture("bird0.png");
    }

    public void update() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            vy = 8;
            i++;
            img = imgs[i%4];
        }
        vy += gravity;
        position.y += vy;
    }
    public void recreate(){
        position = new Vector2(100, 300);
        vy = 0;
    }
}