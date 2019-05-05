package br.com.intergalaticwars.games.screen;

import br.com.intergalaticwars.games.IntergalaticWars;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;

public abstract class IntergalaticWarsScreen implements Screen {

    public String screenId;
    public IntergalaticWars game;
    public boolean done;
    public String intention;
    public Music gameMusic;

    public IntergalaticWarsScreen(IntergalaticWars uw, String id) {
        this.setGame(uw);
        this.setScreenId(id);
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("BitRush.mp3"));
    }

    public abstract void update(float delta);

    public abstract void draw(float delta);

    public void setDone(boolean done) {
        this.done = done;
    }

    public IntergalaticWars getGame() {
        return game;
    }

    public void setGame(IntergalaticWars game) {
        this.game = game;
    }

    public String getScreenId() {
        return screenId;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    @Override
    public void render(float f) {
        this.update(f);
        this.draw(f);
    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
