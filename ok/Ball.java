import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends SmoothMover
{
    private double speed = 1;
    private double realSpeed = 1;
    
    public Ball() {
        turn((int) Math.round(Math.random() * 360.0));
    }
    
    public void act()
    {
        move(realSpeed);
        if (isAtEdge()) {
            turn(75 + (int) Math.round(Math.random() * 30.0));
            speed += 2;
            realSpeed = Math.sqrt(speed);
        }
    }
    
    public double getSpeed() {
        return realSpeed;
    }
}
