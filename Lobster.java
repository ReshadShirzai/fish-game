import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Lobster()
    {
        getImage().scale(100, 100);
    }
    public void hitFish()
    {
        Actor fish = getOneIntersectingObject(Fish.class);
        if(fish != null)
        {
            getWorld().removeObject(fish);
            FishWorld myWorld = (FishWorld) getWorld();
            myWorld.updateScore();
            
            myWorld.addObject(fish, Greenfoot.getRandomNumber(600) + 100, Greenfoot.getRandomNumber(600) + 100);
        }
    }
    public void act()
    {
        // Add your action code here.
        checkKeyboard();
        hitFish();
    }
    
    public void checkKeyboard()
    {
        boolean key = Greenfoot.isKeyDown("right");
        if(key == true)
        {
            turnTowards(getX() + 2, getY());
            setLocation(getX() + 2, getY());
        }
        
        key = Greenfoot.isKeyDown("left");
        if(key == true)
        {
            turnTowards(getX() - 2, getY());
            setLocation(getX() - 2, getY());
        }
        
        key = Greenfoot.isKeyDown("up");
        if(key == true)
        {
            turnTowards(getX(), getY() - 2);
            setLocation(getX(), getY() - 2);
        }
        
        key = Greenfoot.isKeyDown("down");
        if(key == true)
        {
            turnTowards(getX(), getY() + 2);
            setLocation(getX(), getY() + 2);
        }
    }
}
