package br.com.intergalaticwars.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.com.intergalaticwars.games.IntergalaticWars;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new IntergalaticWars(), config);
    }
}
