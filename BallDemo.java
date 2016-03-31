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
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBall)
    {
        int ground = 400;   // position of the ground line
        Random rndRadio = new Random(25);

        myCanvas.setVisible(true);
        //Create arrayList
        ArrayList<BouncingBall> balls = new ArrayList<>();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int a = 0; a < numBall; a++) {
            BouncingBall ball = new BouncingBall(50, 50, rndRadio.nextInt(), Color.RED, ground, myCanvas);
            balls.add(ball);
            
        }
        BouncingBall bola = null;
        for(int b = 0; b < balls.size(); b++) {
            bola = balls.get(b);
            bola.draw();
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
    
    /**
     * Dibuja un rectangulo y bolas dentro que rebotan en las paredes
     * de dicho rectangulo. Su direccion ha de ser oblicua
     * Nunca termina
     */
    public void boxBounce(int numBall) {
        myCanvas.setVisible(true);
        Random rndRadio = new Random(25);
        ArrayList<BouncingBall> balls = new ArrayList<>();
        
        myCanvas.drawLine(100, 100, 100, 400);
        myCanvas.drawLine(100, 400, 500, 400);
        myCanvas.drawLine(500, 400, 500, 100);
        myCanvas.drawLine(500, 100, 100, 100);
        
        
        BouncingBall ball = new BouncingBall(150, 150, 16, Color.RED, 0, myCanvas);
        ball.draw();
        //for(int a = 0; a < numBall; a++) {
        //    BouncingBall ball = new BouncingBall(150, 150, 16, Color.RED, 0, myCanvas);
        //    ball.draw();
        //    balls.add(ball);
        
        
    }
}
