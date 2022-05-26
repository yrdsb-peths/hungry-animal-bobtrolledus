import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    SimpleTimer bulletTimer = new SimpleTimer();
    Label scoreLabel;
    public int score = 0;
    public MyWorld()
    {    
        super(800, 800, 1, true); 
        
        wario mario = new wario();
        addObject(mario, getWidth() / 2, getHeight() / 2);
        Coin coin = new Coin(50, 50);
        addObject(coin, 100, 100);
        
        scoreLabel = new Label(0, 100);
        addObject(scoreLabel, getWidth() / 2, 100);
    }
    
    public void act()
    {
        if(bulletTimer.millisElapsed() < 5000)
        {
            return;
        }
        else
        {
            spawnBullet();
        }
        bulletTimer.mark();
    }
    
    public void increaseScore()
    {
        score += 1;
        scoreLabel.setValue(score);
    }
    
    public void spawnBullet()
    {
        int numBullets = Greenfoot.getRandomNumber(6);
        for(int i = 0; i < numBullets; i++)
        {
            int direction = Greenfoot.getRandomNumber(4);
            if(direction == 0)
            {
                bullet bullet = new bullet(100, 100, direction);
                addObject(bullet, getWidth(), Greenfoot.getRandomNumber(getHeight()));
            }
            if(direction == 1)
            {
                bullet bullet = new bullet(100, 100, direction);
                addObject(bullet, Greenfoot.getRandomNumber(getWidth()) , getHeight());
            }
            if(direction == 2)
            {
                bullet bullet = new bullet(100, 100, direction);
                addObject(bullet, 0, Greenfoot.getRandomNumber(getHeight()));
            }
            if(direction == 3)
            {
                bullet bullet = new bullet(100, 100, direction);
                addObject(bullet, Greenfoot.getRandomNumber(getWidth()), 0);
            }
        }
    }
    
    public void spawnCoin()
    {
        int xCoord = Greenfoot.getRandomNumber(getWidth());
        int yCoord = Greenfoot.getRandomNumber(getHeight());
        Coin coin = new Coin(50, 50);
        addObject(coin, xCoord, yCoord);
    }
    
    public int score()
    {
        return score;
    }
}
