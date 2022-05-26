import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class bullet extends Actor
{
    GreenfootImage bullet[] = new GreenfootImage[3];
    GreenfootImage leftBullet[] = new GreenfootImage[3];
    GreenfootImage upBullet[] = new GreenfootImage[3];
    GreenfootImage downBullet[] = new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    
    private int imageIndex = 0;
    private int direction;
    
    public bullet(int x, int y, int moveDirection)
    {  
        for(int i = 0; i < bullet.length; i++)
        { 
            GreenfootImage image = new GreenfootImage("bullet" + i + ".png");
            image.scale(x, y);
            bullet[i] = image;
        }
        for(int i = 0; i < leftBullet.length; i++)
        {
            GreenfootImage image = new GreenfootImage("bullet" + i + ".png");
            image.scale(x, y);
            leftBullet[i] = image;
            leftBullet[i].mirrorHorizontally();
        }
        for(int i = 0; i < upBullet.length; i++)
        {
            GreenfootImage image = new GreenfootImage("bullet" + i + ".png");
            image.scale(x, y);
            image.rotate(90);
            upBullet[i] = image;
        }
        for(int i = 0; i < downBullet.length; i++)
        {
            GreenfootImage image = new GreenfootImage("bullet" + i + ".png");
            image.scale(x, y);
            image.rotate(-90);
            downBullet[i] = image;
        }
        
        direction = moveDirection;
    }
    
    public void act()
    {
        if(direction == 0)
        {
            setLocation(getX() - 5, getY());
            animateSpin();
        }
        if(direction == 1)
        {
            setLocation(getX(), getY() - 5);
            animateSpin();
        }
        if(direction == 2)
        {
            setLocation(getX() + 5, getY());
            animateSpin();
        }
        if(direction == 3)
        {
            setLocation(getX(), getY() + 5);
            animateSpin();
        }
        if(atEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean atEdge()
    {
        if(getX() == 0 || getY() == 0 || getX() == getWorld().getWidth() - 5|| getY() == getWorld().getHeight() - 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void animateSpin()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(direction == 0)
        {
            setImage(bullet[imageIndex]);
            imageIndex = (imageIndex + 1) % bullet.length;
        }
        if(direction == 1)
        {
            setImage(upBullet[imageIndex]);
            imageIndex = (imageIndex + 1) % upBullet.length;
        }
        if(direction == 2) 
        {
            setImage(leftBullet[imageIndex]);
            imageIndex = (imageIndex + 1) % leftBullet.length;
        }
        if(direction == 3) 
        {
            setImage(downBullet[imageIndex]);
            imageIndex = (imageIndex + 1) % downBullet.length;
        }
    }
}
