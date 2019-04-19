package br.com.intergalaticwars.utils;

import com.badlogic.gdx.Gdx;

public class GameParameters
{
    public static final int GAME_WIDTH = 1366;
    public static final int GAME_HEIGHT = 768;
    public static final float RADIUS = 0.5f;
    
    public static Coord2D convertPosition(float x, float y)
    {
        float xx = x / ((float) Gdx.graphics.getWidth() / GAME_WIDTH);
        float yy = GAME_HEIGHT - y / ((float) Gdx.graphics.getHeight() / GAME_HEIGHT);
        
        return new Coord2D(xx, yy);
    }
}
