package br.com.intergalaticwars.games;

import br.com.intergalaticwars.games.screen.CreditsScreen;
import br.com.intergalaticwars.games.screen.GamePlayScreen;
import br.com.intergalaticwars.games.screen.StartScreen;
import br.com.intergalaticwars.games.screen.IntergalaticWarsScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class IntergalaticWars extends Game {

    public static IntergalaticWarsScreen currentScreen;
    String screenId;

    @Override
    public void create() {
        this.setCurrentScreen(new StartScreen(this, "Start"));
    }

    @Override
    public void render() {
        IntergalaticWars.currentScreen = this.getCurrentScreen();
        IntergalaticWars.currentScreen.render(Gdx.graphics.getDeltaTime());

        if (IntergalaticWars.currentScreen.isDone()) {
            this.setScreenId(IntergalaticWars.currentScreen.getScreenId());

            currentScreen.dispose();

            if (this.getScreenId().equals("Start")) {
                this.setCurrentScreen(new GamePlayScreen(this, "GamePlay"));
                System.out.println("Teste");
            } else if (this.getScreenId().equals("GamePlay")) {
                this.setCurrentScreen(new CreditsScreen(this, "Credits"));
            } else if (this.getScreenId().equals("Credits")) {
                this.setCurrentScreen(new StartScreen(this, "Start"));
            }
        }
    }

    public void setCurrentScreen(IntergalaticWarsScreen screen) {
        IntergalaticWars.currentScreen = screen;
    }

    public IntergalaticWarsScreen getCurrentScreen() {
        return IntergalaticWars.currentScreen;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenId() {
        return screenId;
    }
}
