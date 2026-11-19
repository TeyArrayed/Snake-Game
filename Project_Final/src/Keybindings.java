
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class Keybindings extends JPanel implements KeyListener, ActionListener{        //extends Snake?

    private int headX = 2;  //What I put here should be the initial starting point
    private int headY = 8;
    private String direction;
    public static final String INITIAL_DIRECTION = "RIGHT";
    public Timer timer;
    public boolean gameStarted = false;


    public Keybindings() {                           //Begins the game and sets up all initial settings
        // this adds the key listener to the panel
        setFocusable(true); 
        addKeyListener(this);
        direction = INITIAL_DIRECTION;
        timer = new Timer(100, this); // Update every 100ms
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)      //Correlating the pressing of the keys to directions and the strings
    {
        if (!gameStarted) // if the game has started, do nothing. however if it hasnt started wait until the space bar.
        {
            return;
        }
        if(direction.equals("UP"))
        {
            headX = headX;
            headY = headY - 1; // Move up
        }
        else if(direction.equals("DOWN"))
        {
            headX = headX;
            headY = headY + 1; // Move down
        }
        else if(direction.equals("RIGHT"))
        {
            headY = headY;
            headX = headX + 1; // Move right
        }
        else if(direction.equals("LEFT"))
        {
            headY = headY;
            headX = headX - 1; // Move left
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {        //Pretty sure that this is to prevent the head from backtracking
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(!direction.equals("DOWN"))
            {
                direction = "UP";
            }  
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(!direction.equals("UP"))
            {
                direction = "DOWN";
            }
        } 
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(!direction.equals("RIGHT"))
            {
                direction = "LEFT";
            } 
        } 
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(!direction.equals("LEFT"))
            {
                direction = "RIGHT";
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            // when the space key is pressed, start the game
            startGame();
        }
    }

    public void startGame()
    {
        direction = "RIGHT";
        snake.bodySegments.clear();

        gameStarted = true;
        timer.restart();
        
    }

    public void gameOver()
    {
        gameStarted = false;
        timer.stop();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // i didnt need to use it
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // i didnt need to use it
    }
}
