import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class startmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startmenu extends World
{
    Label titleLabel = new Label("BANG BANG MARIO!!!!", 90);
    /**
     * Constructor for objects of class startmenu.
     * 
     */
    public startmenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        addObject(titleLabel, getWidth() / 2, getHeight() / 2);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            description descriptionWorld = new description();
            Greenfoot.setWorld(descriptionWorld);
        }
    }
    
}
