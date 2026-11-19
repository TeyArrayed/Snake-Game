
import javax.swing.*;

/**
 * The purpose of this class is to define the walls of the campus,
 * create some snakes to put on the roads, and then to turn them loose.
 * 
 * @author Nathan Axvig (Not anymore mostly)
 */

public class Tester extends JPanel{

public static final int sleepTime = 100;
public static final int TOTAL_TIME = 100;
public Timer timer;
public Tester()
{
   
    // this adds the key listener to the panel
    setFocusable(true); 
    addKeyListener(this);
    direction = INITIAL_DIRECTION;
    timer = new Timer(100, this); // Update every 100ms
    timer.start();
}
    /**
     * The main method.
     */
    public static void main(String[] args) {
        boolean[][] map ={
            {true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true },
            {true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true },
        };
        Campus campus = new Campus(map);
        campus.initializeCampus();
        campus.showCampus();

        Snake snake = new Snake(campus);

        snake.addBody(campus.getCell(8, 3));
        snake.addBody(campus.getCell(8, 2));
        //snake.addBody(campus.getCell(4, 5));
        //snake.addBody(campus.getCell(5, 5));

        snake.showSnake();

        // start the game.
        for(int time = 0; time < TOTAL_TIME; time++)
        {
            snake.testMove();
            if (time % 5 != 1)
            {
                snake.move();
            }
            else{
                System.out.println("Snake got longer. Time is " + time);
            }
        }
        
        
       
    }
/**
 * This method pauses the execution of the program for pauseTime milliseconds.
 * It keeps things from running so fast our eyes can't see them.  Large pauseTimes
 * cause the animation to run slowly, small pauseTimes cause the animation to run fast.
  
    public static void pause(int pauseTime)
    {
        try
        {
            Thread.sleep(pauseTime);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }*/
    public void startTimer()
    {
        timer.restart();
    }
    public void endTimer()
    {
        timer.stop();
    }

}
