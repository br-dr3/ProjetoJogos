package br.com.intergalaticwars.games.model;

import br.com.intergalaticwars.utils.GameParameters;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Ball {
    public Circle position;
    public ShapeRenderer shapeRenderer;
    public Vector2 direction;
    public boolean visible;
    
    public int isGoal;
    
    public static float MEDIUM_X = 512;
    public static float MEDIUM_Y = 420;
    public static Vector2 CENTER = new Vector2(MEDIUM_X, MEDIUM_Y);
    public static Circle MEDIUM_POSITION = new Circle(CENTER, 20);
    

    public Ball() {
        this(new Circle(MEDIUM_X, MEDIUM_Y, 20), new ShapeRenderer());
    }
    
    public Ball(Circle c, ShapeRenderer sr) {
        position = c;
        shapeRenderer = sr;
        visible = true;
       
        defineRandomDirection();
        
        isGoal = 0;
    }
    
    public void draw() {
        if(visible) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.circle(position.x, position.y, position.radius);
            shapeRenderer.end();
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setPosition(float x, float y, Player user, Player computer) {
        float newX = x, newY = y;
        
        if(x >= GameParameters.MAX_X) {
            isGoal = 1;
            
            newX = MEDIUM_X;
            newY = MEDIUM_Y;
            
            Random r = new Random();
            if(r.nextBoolean())
                setDirection(new Vector2(-1, -1));
            else
                setDirection(new Vector2(-1, 1));
        }
            
        if(x <= GameParameters.MIN_X) {
            isGoal = -1;
            
            newX = MEDIUM_X;
            newY = MEDIUM_Y;
            
            Random r = new Random();
            if(r.nextBoolean())
                setDirection(new Vector2(1, -1));
            else
                setDirection(new Vector2(1, 1));
        }
            
        if(y >= GameParameters.MAX_Y) {
            newY = GameParameters.MAX_Y;
            direction.y = -direction.y;
        }
            
        if(y <= GameParameters.MIN_Y) {
            newY = GameParameters.MIN_Y;
            direction.y = -direction.y;
        }
       
        if(checkContact(user, this, true)) {
            direction.x = 1;
        }
        
        if(checkContact(computer, this, false)) {
            direction.x = -1;
        }
        
        this.position.x = newX;
        this.position.y = newY;
    }
    
    public boolean checkContact(Player p, Ball b, boolean left) {
        if (left) {
            return p.initialPoint.x >= b.position.x - b.position.radius
                   && p.initialPoint.y -50 <= b.position.y-b.position.radius
                   && p.finalPoint.y  +50 >= b.position.y + b.position.radius;
        }
        
        else
            return p.initialPoint.x <= b.position.x + b.position.radius
                   && p.initialPoint.y -50 <= b.position.y-b.position.radius
                   && p.finalPoint.y +50 >= b.position.y + b.position.radius;
            
    }

    public int getIsGoal() {
        int value = isGoal;
        isGoal = 0;
        return value;
    }   
    
    public void dispose() {
        shapeRenderer.dispose();
    }
    
    public void defineRandomDirection() {
        Random r = new Random();
        if(r.nextBoolean()) {
            setDirection(new Vector2(1, 1));
        } else {
            setDirection(new Vector2(-1, -1));
        }
    }
    
    public void setDirection(Vector2 v) {
        direction = v;
    }
}