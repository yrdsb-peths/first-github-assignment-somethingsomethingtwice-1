import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Canvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Canvas extends Actor
{
    GreenfootImage background;
    public Canvas(GreenfootImage background) {
        this.background = background;        
    }
    
    public void act()
    {
        setImage(background);
    }
}
