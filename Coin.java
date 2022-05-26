import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{   
    private int imageIndex = 0;
    GreenfootImage spin[] = new GreenfootImage[6];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public void act()
    {
        animateSpin();
    }
    
    public Coin(int x, int y)
    {  
        for(int i = 0; i < spin.length; i++)
        { 
            GreenfootImage image = new GreenfootImage("coin" + i + ".png");
            image.scale(x, y);
            spin[i] = image;
        }
        setImage(spin[0]);
    }
    
    public void animateSpin()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        setImage(spin[imageIndex]);
        imageIndex = (imageIndex + 1) % spin.length;
    }
    
}
