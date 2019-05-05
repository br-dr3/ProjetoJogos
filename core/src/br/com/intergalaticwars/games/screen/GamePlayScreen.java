package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import br.com.intergalaticwars.games.model.Ball;
import br.com.intergalaticwars.games.model.Player;
import br.com.intergalaticwars.utils.GameParameters;
import br.com.intergalaticwars.utils.font.Font;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public class GamePlayScreen extends IntergalaticWarsScreen {

    private Texture background;
    private SpriteBatch spriteBatch;
    private Matrix4 transformationMatrix;
    private Matrix4 viewMatrix;
    private ShapeRenderer shapeRenderer;
    private Font font;
    private Ball ball;
    private Player user;
    private Player computer;
    public Vector2 scoreBoard;

    public GamePlayScreen(IntergalaticWars uw, String s) {
        super(uw, s);
        this.background = new Texture(Gdx.files.internal("Screen/StartScreen/blackscreen.png"));
        this.spriteBatch = new SpriteBatch();
        this.transformationMatrix = new Matrix4();
        this.viewMatrix = new Matrix4();
        this.shapeRenderer = new ShapeRenderer();
        this.font = new Font();
        this.ball = new Ball();
        this.user = new Player(new Vector2(60, 300));
        this.computer = new Player(new Vector2(GameParameters.GAME_WIDTH-60, 300));
        scoreBoard = new Vector2(0, 0);
    }

    @Override
    public void update(float delta) {
        
        ball.setPosition(ball.position.x + ball.direction.x * GameParameters.BALL_VELOCITY, 
                         ball.position.y + ball.direction.y * GameParameters.BALL_VELOCITY, user, computer);
        
        int isGoal = ball.getIsGoal();
        
        if(isGoal == 1) {
            scoreBoard.x++;
        } else if (isGoal == -1) {
            scoreBoard.y++;
        }
        
        this.setDone(scoreBoard.x >= 5 || scoreBoard.y >= 5);
        
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            user.move(true, true);
        } else if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            user.move(false, true);
        }
        
        if(ball.position.y > computer.getPosition().y +100) {
            computer.move(true, false);
        } else {
            computer.move(false, false);
        }
        
        System.out.println(user.getPosition().x + " " + user.getPosition().y);
    }

    @Override
    public void draw(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewMatrix.setToOrtho2D(0, 0, GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT);
        
        configureShapeRenderer(viewMatrix, transformationMatrix);
        
        begin();

        spriteBatch.draw(this.background,
                0, 0,
                GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT,
                0, 0,
                this.background.getWidth(), this.background.getHeight() - 100,
                false, false);

        Gdx.gl.glLineWidth(30);

        shapeRenderer.setColor(new Color(1, 1, 1, 0));
        shapeRenderer.line(29, 35, GameParameters.GAME_WIDTH-29, 35);
        shapeRenderer.line(GameParameters.GAME_WIDTH-35, 35, GameParameters.GAME_WIDTH-35, GameParameters.GAME_HEIGHT-30);
        shapeRenderer.line(GameParameters.GAME_WIDTH-29, GameParameters.GAME_HEIGHT-35, 29, GameParameters.GAME_HEIGHT-35);
        shapeRenderer.line(35, GameParameters.GAME_HEIGHT-35, 35, 35);
        shapeRenderer.line(GameParameters.GAME_WIDTH-29, GameParameters.GAME_HEIGHT-90, 29, GameParameters.GAME_HEIGHT-90);
        
        font.write(spriteBatch, (int) scoreBoard.x + " - You", 50, GameParameters.GAME_HEIGHT-50);
        font.write(spriteBatch, "Computer - " + (int) scoreBoard.y, GameParameters.GAME_WIDTH-310, GameParameters.GAME_HEIGHT-50);
        
        end();
        
        ball.draw();
        user.draw();
        computer.draw();
    }
    
    private void begin() {
        spriteBatch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
    }
    
    private void end() { 
        spriteBatch.end();
        shapeRenderer.end();
    }
    
    private void configureShapeRenderer(Matrix4 viewMatrix, Matrix4 transformationMatrix) {
        spriteBatch.setProjectionMatrix(viewMatrix);
        spriteBatch.setTransformMatrix(transformationMatrix);
        
        shapeRenderer.setProjectionMatrix(viewMatrix);
        shapeRenderer.setTransformMatrix(transformationMatrix);

        ball.shapeRenderer.setProjectionMatrix(viewMatrix);
        ball.shapeRenderer.setTransformMatrix(transformationMatrix);
        
        user.shapeRenderer.setProjectionMatrix(viewMatrix);
        user.shapeRenderer.setTransformMatrix(transformationMatrix);
        
        computer.shapeRenderer.setProjectionMatrix(viewMatrix);
        computer.shapeRenderer.setTransformMatrix(transformationMatrix);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        background.dispose();
        ball.dispose();
        user.dispose();
        computer.dispose();
    }
}
