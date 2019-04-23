package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import br.com.intergalaticwars.utils.GameParameters;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class GamePlayScreen extends IntergalaticWarsScreen
{   
    private Texture background;
    private SpriteBatch spriteBatch;
    private Matrix4 transformationMatrix;
    private Matrix4 viewMatrix;
    
    public GamePlayScreen(IntergalaticWars uw, String s)
    {
        super(uw, s);
        this.background = new Texture(Gdx.files.internal("Screen/GamePlayScreen/GamePlayScreen.jpg"));
        this.spriteBatch = new SpriteBatch();
        this.transformationMatrix = new Matrix4();
        this.viewMatrix = new Matrix4();
    }
    
    @Override
    public void update(float delta)
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY))
            this.setDone(true);
    }

    @Override
    public void draw(float delta)
    {
        viewMatrix.setToOrtho2D(0, 0, GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT);
        spriteBatch.setProjectionMatrix(viewMatrix);
        spriteBatch.setTransformMatrix(transformationMatrix);
        
        spriteBatch.begin();
        spriteBatch.draw(this.background,
                         0, 0,
                         this.background.getWidth(), this.background.getHeight(),
                         0, 0, 
                         GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT,
                         false, false);
        spriteBatch.end();
    }

    @Override
    public void dispose()
    {
        spriteBatch.dispose();
        background.dispose();
    }
}
