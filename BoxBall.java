import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;    // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
     public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                    Canvas drawingCanvas){
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition +=2;

        // check if it has hit the ground
        if(yPosition == 0) {
            yPosition = (int)(yPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }
    
    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
