import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class igloo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wario extends Actor
{
    private static int speed = 6;
    private int score = 0, imageIndex = 0;
    
    String direction = "left";
    GreenfootImage walk[] = new GreenfootImage[4];
    GreenfootImage leftWalk[] = new GreenfootImage[4];
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public wario()
    {
        for(int i = 0; i < walk.length; i++)
        {
            walk[i] = new GreenfootImage("walk" + i + ".png");
        }
        
        for(int i = 0; i < leftWalk.length; i++)
        {
            leftWalk[i] = new GreenfootImage("walk" + i + ".png");
            leftWalk[i].mirrorHorizontally();
            setImage(walk[0]);
        }
    }
    
    public void act()
    {
        move();
        coinCollisions();
        bulletCollision();
    }
    
    public void coinCollisions()
    {
        if(isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            ((MyWorld)getWorld()).spawnCoin();
            ((MyWorld)getWorld()).increaseScore();
            Greenfoot.playSound("vineboom.mp3");
        }
    }
    
    public void bulletCollision()
    {       
        if(isTouching(bullet.class))
        {
            Greenfoot.playSound("die.mp3");
            setImage("die.png");
            Greenfoot.delay(100);
            score = ((MyWorld)getWorld()).score();
            endScreen endScreen = new endScreen(score);
            Greenfoot.setWorld(endScreen);
        }
    }
    
    public void animateWalk()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(direction.equals("right"))
        {
            setImage(walk[imageIndex]);
            imageIndex = (imageIndex + 1) % walk.length;
        }
        if(direction.equals("left")) 
        {
            setImage(leftWalk[imageIndex]);
            imageIndex = (imageIndex + 1) % leftWalk.length;
        }
    }
    
    public void move()
    {
        if(Greenfoot.isKeyDown("right") == false && Greenfoot.isKeyDown("left") == false)
        {
            if(direction.equals("right"))
            {
                setImage("idle.png");
            }
            if(direction.equals("left"))
            {
                GreenfootImage idle = new GreenfootImage("idle.png");
                idle.mirrorHorizontally();
                setImage(idle);
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + speed, getY());
            direction = "right";
            animateWalk();
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - speed, getY());
            direction = "left";
            animateWalk();
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
        }
    }
    
    public int score()
    {
        return score;
    }
}
