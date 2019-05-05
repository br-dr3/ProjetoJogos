package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
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

public class StartScreen extends IntergalaticWarsScreen {

    private Texture background;
    private SpriteBatch spriteBatch;
    private Matrix4 viewMatrix;
    private Matrix4 transformationMatrix;
    private Font font;
    private ShapeRenderer shapeRenderer;

    public StartScreen(IntergalaticWars uw, String id) {
        super(uw, id);
        this.background = new Texture(Gdx.files.internal("Screen/StartScreen/blackscreen.png"));
        this.spriteBatch = new SpriteBatch();
        this.transformationMatrix = new Matrix4();
        this.viewMatrix = new Matrix4();
        this.font = new Font();
        this.shapeRenderer = new ShapeRenderer();
    }

    public void setGame(IntergalaticWars uw) {
        this.game = uw;
    }

    public void setScreenId(String s) {
        this.screenId = s;
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            this.setDone(true);
        }
    }

    @Override
    public void draw(float delta) {
        font.font.getData().setScale(0.8f, 0.8f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
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

        font.write(spriteBatch, "Brian Andreossi", 700, 775);
        font.write(spriteBatch, "Murilo Dionisio", 700, 725);
        font.write(spriteBatch, "Touch any button", 380, 420);
        Gdx.gl.glLineWidth(30);
        
        shapeRenderer.setColor(new Color(1, 1, 1, 0));
        shapeRenderer.line(29, 35, GameParameters.GAME_WIDTH-29, 35);
        shapeRenderer.line(GameParameters.GAME_WIDTH-35, 35, GameParameters.GAME_WIDTH-35, GameParameters.GAME_HEIGHT-30);
        shapeRenderer.line(GameParameters.GAME_WIDTH-29, GameParameters.GAME_HEIGHT-35, 29, GameParameters.GAME_HEIGHT-35);
        shapeRenderer.line(35, GameParameters.GAME_HEIGHT-35, 35, 35);
       
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
