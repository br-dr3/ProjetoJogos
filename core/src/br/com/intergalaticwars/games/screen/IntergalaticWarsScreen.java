package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import com.badlogic.gdx.Screen;

public abstract class IntergalaticWarsScreen implements Screen
{
    String screenId;
    IntergalaticWars game;
    boolean done;

    public IntergalaticWarsScreen(IntergalaticWars uw, String id)
    {
        this.setGame(uw);
        this.setScreenId(id);
    }
    
    public abstract void update(float delta);
    public abstract void draw(float delta);
    

    
    public void setDone(boolean done)
    {
        this.done = done;
    }
    
    public IntergalaticWars getGame()
    {
        return game;
    }

    public void setGame(IntergalaticWars game)
    {
        this.game = game;
    }

    public String getScreenId()
    {
        return screenId;
    }
    
    public boolean isDone()
    {
        return this.done;
    }

    public void setScreenId(String screenId)
    {
        this.screenId = screenId;
    }
        
    @Override
    public void render(float f)
    {
        this.update(f);
        this.draw(f);
    }
    
    @Override
    public void show()
    {
        
    }
    
    @Override
    public void resize(int i, int i1)
    {
        
    }
    
    @Override
    public void pause()
    {
        
    }
    
    @Override
    public void resume()
    {
        
    }
    
    @Override
    public void hide()
    {
        
    }
    
    @Override
    public void dispose()
    {
        
    }
}
