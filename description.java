import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class description here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class description extends World
{
    Label Instructions = new Label("Collect as many coins as you can", 50);
    Label move = new Label("Move with arrow keys", 50);
    Label avoid = new Label("Avoid the bullets >:)", 50);
    Label play = new Label("Ready to play? press space", 50);
    
    /**
     * Constructor for objects of class description.
     * 
     */
    public description()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        
        addObject(Instructions, getWidth() / 2, 100);
        addObject(move, getWidth() / 2, 200);
        addObject(avoid, getWidth() / 2, 300);
        addObject(play, getWidth() / 2, 500);
    }
    
    public void act()
    {
        Greenfoot.delay(1);
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
