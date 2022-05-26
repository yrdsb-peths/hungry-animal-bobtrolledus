import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class endScreen extends World
{
    Label titleLabel = new Label("YOU DIED!!!", 150);
    Label description = new Label("Your score was", 100);
    Label playagain = new Label("Play again? (press space)", 50);
    Label endScore;
    /**
     * Constructor for objects of class endScreen.
     * 
     */
    public endScreen(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        
        addObject(titleLabel, getWidth() / 2, getHeight() / 2 - 50);
        endScore = new Label(score, 100);
        addObject(description, getWidth() / 2 - 50, getHeight() / 2 + 50);
        addObject(endScore, getWidth() / 2 + 300, getHeight() / 2 + 50);
        addObject(playagain, getWidth() / 2, getHeight() / 2 + 150);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
