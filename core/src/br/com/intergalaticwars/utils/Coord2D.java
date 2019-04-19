package br.com.intergalaticwars.utils;

public class Coord2D
{
    public float x, y;

    public Coord2D(float x, float y)
    {
        this.setX(x);
        this.setY(y);
    }
    
    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }
}
