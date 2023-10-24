package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
    public int score;
    private String yourScoreName;
    BitmapFont yourBitmapFontName;

    /**
     * создание объекта "Score"
     */
    public void create(){
        score = 0;
        yourScoreName = "score: "+ score;
        yourBitmapFontName = new BitmapFont();
    }

    /**
     * метод вывода на экран
     * @param batch отрисовка объекта "Score"
     */
    public void render(SpriteBatch batch){
        yourScoreName = "score: "+ score;
        yourBitmapFontName.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        yourBitmapFontName.draw(batch, yourScoreName, 25, 100);
    }
}
