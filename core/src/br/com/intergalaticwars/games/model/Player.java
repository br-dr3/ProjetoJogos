package br.com.intergalaticwars.games.model;

import br.com.intergalaticwars.utils.GameParameters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public ShapeRenderer shapeRenderer;
    Vector2 initialPoint;
    Vector2 finalPoint;
    
    public Player(Vector2 p, ShapeRenderer sr) {
        this.initialPoint = p;
        this.finalPoint = new Vector2 (p.x, p.y+200);
        this.shapeRenderer = sr;
    }
    
    public Player(Vector2 initialPoint) {
        this(initialPoint, new ShapeRenderer());
    }
    
    public void draw() {
        Gdx.gl.glLineWidth(30);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.line(initialPoint, finalPoint);
        shapeRenderer.end();
    }
    
    public void dispose() {
        shapeRenderer.dispose();
    }
    
    public void move(boolean isUp, boolean isUser) {
        
        if (isUp) {
            initialPoint.y += (isUser)? GameParameters.USER_VELOCITY:GameParameters.COMPUTER_VELOCITY;
            finalPoint.y += (isUser)? GameParameters.USER_VELOCITY:GameParameters.COMPUTER_VELOCITY;;
            
        } else {
            initialPoint.y -= (isUser)? GameParameters.USER_VELOCITY:GameParameters.COMPUTER_VELOCITY;;
            finalPoint.y -= (isUser)? GameParameters.USER_VELOCITY:GameParameters.COMPUTER_VELOCITY;;
        }
        
        if(finalPoint.y >= GameParameters.MAX_Y) {
            finalPoint.y = GameParameters.MAX_Y -5;
            initialPoint.y = finalPoint.y-200;
        }
        
        if (initialPoint.y <= GameParameters.MIN_X) {
            initialPoint.y = GameParameters.MIN_X +5;
            finalPoint.y = initialPoint.y+200;
        }
    }
    
    public Vector2 getPosition() {
        return initialPoint;
    }
}
