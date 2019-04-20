
package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import br.com.intergalaticwars.utils.GameParameters;
import br.com.intergalaticwars.utils.font.Font;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class StartScreen extends IntergalaticWarsScreen
{
    private Texture background;
    private SpriteBatch spriteBatch;
    private Matrix4 viewMatrix;
    private Matrix4 transformationMatrix;
    private Font font;
    
    public StartScreen(IntergalaticWars uw, String id)
    {
        super(uw, id);      
        this.background = new Texture(Gdx.files.internal("StartScreen/StartScreen.jpg"));
        this.spriteBatch = new SpriteBatch();
        this.transformationMatrix = new Matrix4();
        this.viewMatrix = new Matrix4();
        this.font = new Font();
    }
    
    public void setGame(IntergalaticWars uw)
    {
        this.game = uw;
    }
    
    public void setScreenId(String s)
    {
        this.screenId = s;
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
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewMatrix.setToOrtho2D(0, 0, GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT);
        spriteBatch.setProjectionMatrix(viewMatrix);
        spriteBatch.setTransformMatrix(transformationMatrix);
        
        spriteBatch.begin();
        spriteBatch.draw(this.background,
                         0, 0,
                         GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT,
                         0, 0, 
                         GameParameters.GAME_WIDTH, GameParameters.GAME_HEIGHT,
                         false, false);
        
        font.write(spriteBatch, "IntergalaticWars | the very start", 25, 50);
        
        spriteBatch.end();
    }
    
    @Override
    public void dispose()
    {
        spriteBatch.dispose();
        background.dispose();
        font.dispose();
    }
    
    public Texture getBackground()
    {
        return background;
    }

    public void setBackground(Texture background)
    {
        this.background = background;
    }

    public SpriteBatch getSpriteBatch()
    {
        return spriteBatch;
    }

    public void setSpriteBatch(SpriteBatch spriteBatch)
    {
        this.spriteBatch = spriteBatch;
    }

    public Matrix4 getViewMatrix()
    {
        return viewMatrix;
    }

    public void setViewMatrix(Matrix4 viewMatrix)
    {
        this.viewMatrix = viewMatrix;
    }

    public Matrix4 getTransformationMatrix()
    {
        return transformationMatrix;
    }

    public void setTransformationMatrix(Matrix4 transformationMatrix)
    {
        this.transformationMatrix = transformationMatrix;
    }
}
