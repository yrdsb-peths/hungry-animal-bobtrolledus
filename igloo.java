import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class igloo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class igloo extends Actor
{
    /**
     * Act - do whatever the igloo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
    }
    
    public void move()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
    }
}
