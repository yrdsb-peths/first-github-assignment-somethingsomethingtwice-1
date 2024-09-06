import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int WIDTH = 600;
    int HEIGHT = 400;
    
    GreenfootImage canvas = new GreenfootImage(WIDTH, HEIGHT);
    Canvas canvasObject = new Canvas(canvas);
    Ball ball = new Ball();
    GreenfootImage ballImage = ball.getImage();
    Label label = new Label(Double.toString(ball.getSpeed()), 32);
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(canvasObject, 300, 200);
        addObject(ball, 300, 200);
        addObject(label, 300, 32);
    }
    
    public void act() {
        label.setValue(Double.toString(ball.getSpeed()));
        canvas.setColor(new Color((int) Math.round(Math.random() * 255.0), (int) Math.round(Math.random() * 255.0), (int) Math.round(Math.random() * 255.0), 255));
        canvas.fillOval(ball.getX() - ballImage.getWidth() / 2, ball.getY() - ballImage.getHeight() / 2, ballImage.getWidth() - 1, ballImage.getHeight() - 1);
    }
}
