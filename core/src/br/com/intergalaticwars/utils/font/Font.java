package br.com.intergalaticwars.utils.font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Font
{
    public static BitmapFont font;

    public static BitmapFont getFont()
    {
        return font;
    }

    public static void setFont(BitmapFont font)
    {
        Font.font = font;
    }
    
    public Font()
    {
        font = new BitmapFont(Gdx.files.internal("Font/IntergalaticWars.fnt"));
    }
    
    public void write(SpriteBatch sb, String text, int x, int y)
    {
        font.draw(sb, text, x, y);
    }
    
    public void dispose()
    {
        font.dispose();
    }
}
