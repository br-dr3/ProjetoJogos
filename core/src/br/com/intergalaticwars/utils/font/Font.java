package br.com.intergalaticwars.utils.font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font
{
    public FreeTypeFontGenerator generator;
    public FreeTypeFontParameter parameter;
    public BitmapFont font;
    
    public Font(int size)
    {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/galaxy_1.ttf"));
        parameter = new FreeTypeFontParameter();
        
        parameter.size = size;
        font = generator.generateFont(parameter);
    }
    
    public void generateText(SpriteBatch sb, String text, int x, int y)
    {
        font.draw(sb, text, x, y);
    }
    
    public void dispose()
    {
        font.dispose();
    }
}
