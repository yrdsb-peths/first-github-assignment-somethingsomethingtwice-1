import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int WIDTH = 600;
    private int HEIGHT = 400;
    private double hue = 0;
    private double saturation = 1;
    private double value = 1;
    
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
        
        // hsv to rgb formula
        // https://www.rapidtables.com/convert/color/hsv-to-rgb.html
        double colour = value * saturation;
        double x = colour * (1 - Math.abs((hue / 60) % 2 - 1));
        double m = value - colour;
        double[] rgbPrime;
        if (hue < 60)
            rgbPrime = new double[]{colour, x, 0};
        else if (hue < 120)
            rgbPrime = new double[]{x, colour, 0};
        else if (hue < 180)
            rgbPrime = new double[]{0, colour, x};
        else if (hue < 240)
            rgbPrime = new double[]{0, x, colour};
        else if (hue < 300)
            rgbPrime = new double[]{x, 0, colour};
        else
            rgbPrime = new double[]{colour, 0, x};
        Color finalColor = new Color(
            (int) ((rgbPrime[0] + m) * 255),
            (int) ((rgbPrime[1] + m) * 255),
            (int) ((rgbPrime[2] + m) * 255)
        );
        canvas.setColor(finalColor);
        hue = (hue + 1) % 360;
        
        canvas.fillOval(ball.getX() - ballImage.getWidth() / 2, ball.getY() - ballImage.getHeight() / 2, ballImage.getWidth() - 1, ballImage.getHeight() - 1);
    }
}
