import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

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
    private ArrayList<Color> colores;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        ArrayList<Color> colores = new ArrayList<>();
        colores.add(Color.blue);
        colores.add(Color.red);
        colores.add(Color.green);
        colores.add(Color.pink);
        colores.add(Color.yellow);
        colores.add(Color.black);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBall)
    {
        int ground = 400;   // position of the ground line
        Random rndColor = new Random(7);
        Random rndRadio = new Random(25);

        myCanvas.setVisible(true);
        //Create arrayList
        ArrayList<BouncingBall> balls = new ArrayList<>();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int a = 0; a < numBall; a++) {
            int x = 50;
            Color color = colores.get(rndColor.nextInt());
            BouncingBall ball = new BouncingBall(x, 50, rndRadio.nextInt(), color, ground, myCanvas);
            balls.add(ball);
            ball.draw();
            x= x + 10;
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int b = 0; b < balls.size(); b++){
                balls.get(b).move();
                // stop once ball has travelled a certain distance on x axis
                if(balls.get(b).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
