package br.com.intergalaticwars.games.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import br.com.intergalaticwars.games.IntergalaticWars;
import com.badlogic.gdx.Gdx;
import java.awt.Dimension;
import java.awt.Toolkit;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        config.resizable = false;
        new LwjglApplication(new IntergalaticWars(), config);
    }
}
