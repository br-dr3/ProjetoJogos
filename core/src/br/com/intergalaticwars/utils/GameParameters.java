package br.com.intergalaticwars.utils;

import com.badlogic.gdx.Gdx;

public class GameParameters
{
    public static final float GAME_WIDTH = 1024;
    public static final float GAME_HEIGHT = 840;
    public static final float RADIUS = 0.5f;
    
    public static float MIN_X = 55f;
    public static float MAX_X = GameParameters.GAME_WIDTH-55f;
    public static float MIN_Y = 55f;
    public static float MAX_Y = GameParameters.GAME_HEIGHT-110f;
   
    public static int BALL_VELOCITY = 8;
    public static int USER_VELOCITY = 7;
    public static int COMPUTER_VELOCITY = 5;
    
    public static void setBallVelocity(int v) {
        BALL_VELOCITY = v;
    }
    
    public static void setUserVelocity(int v) {
        USER_VELOCITY = v;
    }
    
    public static void setComputerVelocity(int v) {
        COMPUTER_VELOCITY = v;   
    }
}