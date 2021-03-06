package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import br.com.intergalaticwars.utils.GameParameters;
import br.com.intergalaticwars.utils.font.Font;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;

public class CreditsScreen extends IntergalaticWarsScreen {

    private Texture background;
    private SpriteBatch spriteBatch;
    private Matrix4 viewMatrix;
    private Matrix4 transformationMatrix;
    private Font font;
    private ShapeRenderer shapeRenderer;
    private float time;
    private boolean countdown;
    private Music music;
    private boolean isWinner;

    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }

    public CreditsScreen(IntergalaticWars uw, String id) {
        super(uw, id);
        this.background = new Texture(Gdx.files.internal("Screen/StartScreen/blackscreen.png"));
        this.spriteBatch = new SpriteBatch();
        this.transformationMatrix = new Matrix4();
        this.viewMatrix = new Matrix4();
        this.font = new Font();
        this.shapeRenderer = new ShapeRenderer();
        countdown = false;
        time = 0;
        music = Gdx.audio.newMusic(Gdx.files.internal("Countdown-Me-728881159.mp3"));
        music.setLooping(false);
    }

    public void setGame(IntergalaticWars uw) {
        this.game = uw;
    }

    public void setScreenId(String s) {
        this.screenId = s;
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) && !countdown) {
            time = 0; 
            countdown = true;
            music.play();
        }
         
        setDone(time > 6f);
        
    }

    @Override
    public void draw(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        font.font.getData().setScale(0.8f, 0.8f);
        viewMatrix.setToOrtho2D(0, 0, GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT);
        spriteBatch.setProjectionMatrix(viewMatrix);
        spriteBatch.setTransformMatrix(transformationMatrix);
        shapeRenderer.setProjectionMatrix(viewMatrix);
        shapeRenderer.setTransformMatrix(transformationMatrix);

        spriteBatch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        spriteBatch.draw(this.background,
                         0, 0,
                         GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT,
                         0, 0,
                         this.background.getWidth(), this.background.getHeight()-100,
                         false, false);
    
        if (!countdown) {
            font.write(spriteBatch, "Brian Andreossi", 700, 775);
            font.write(spriteBatch, "Murilo Dionisio", 700, 725); 
            
            if(isWinner) {
                font.write(spriteBatch, "You win", 380, 370);
            } else {
                font.write(spriteBatch, "You lose", 380, 370);
            }
            
            font.write(spriteBatch, "Touch any button", 380, 320);
            Gdx.gl.glLineWidth(30);

            shapeRenderer.setColor(new Color(1, 1, 1, 0));
            shapeRenderer.line(29, 35, GameParameters.GAME_WIDTH-29, 35);
            shapeRenderer.line(GameParameters.GAME_WIDTH-35, 35, GameParameters.GAME_WIDTH-35, GameParameters.GAME_HEIGHT-30);
            shapeRenderer.line(GameParameters.GAME_WIDTH-29, GameParameters.GAME_HEIGHT-35, 29, GameParameters.GAME_HEIGHT-35);
            shapeRenderer.line(35, GameParameters.GAME_HEIGHT-35, 35, 35);

        } else {
            time += delta;
            font.font.getData().setScale(3f, 3f);            
 
            if(time <= 1) {
                font.write(spriteBatch, "5", 480, 450);
            } else if (time <= 2) {
                font.write(spriteBatch, "4", 480, 450);
            } else if (time <= 3) {
                font.write(spriteBatch, "3", 480, 450);
            } else if (time <= 4) {
                font.write(spriteBatch, "2", 480, 450);
            } else if (time <= 5) {
                font.write(spriteBatch, "1", 480, 450);
            } else {
                font.font.getData().setScale(2f, 2f); 
                font.write(spriteBatch, "Go!", 465, 480);
                font.write(spriteBatch, "5 goals to win!", 215, 390);
            }
            
        }
        
        spriteBatch.end();
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        background.dispose();
        font.dispose();
        shapeRenderer.dispose();
    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public Matrix4 getViewMatrix() {
        return viewMatrix;
    }

    public void setViewMatrix(Matrix4 viewMatrix) {
        this.viewMatrix = viewMatrix;
    }

    public Matrix4 getTransformationMatrix() {
        return transformationMatrix;
    }

    public void setTransformationMatrix(Matrix4 transformationMatrix) {
        this.transformationMatrix = transformationMatrix;
    }
}
