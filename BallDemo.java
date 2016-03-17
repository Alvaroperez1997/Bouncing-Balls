import java.awt.Color;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBall)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        //Create arrayList
        ArrayList<BouncingBall> balls = new ArrayList<>();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int a = 0; a < numBall; a++) {
            BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
            balls.add(ball);
            ball.draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int b = 0; b < numBall; b++){
                balls.get(b).move();
                // stop once ball has travelled a certain distance on x axis
                if(balls.get(b).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
