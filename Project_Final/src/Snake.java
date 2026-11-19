import java.util.Random;

import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


/**
 * This is a general superclass for snakes on the road.
 * 
 * It governs how they move and what they follow, and how others join them
 */


public class Snake extends JPanel implements KeyListener, ActionListener{

    public ArrayList<Cell> bodySegments = new ArrayList<Cell>();
    protected Campus campus;

    public static final Color BODY_COLOR = new Color(0,220,200);
    public static final Color HEAD_COLOR = Color.BLUE;

    private String direction;
    public static final String INITIAL_DIRECTION = "RIGHT";
    public boolean gameStarted = false;

    Cell headCell = bodySegments.get(bodySegments.size() - 1);
    public int headX = headCell.getRow();
    public int headY = headCell.getCol();

    //public static final Random randomNumberGenerator = new Random();


    public Snake(Campus newCampus)
    {
        campus = newCampus;
    }
    public void addBody(Cell newCell)
    {
        bodySegments.add(newCell);
    }
    public void showSnake()
    {
        for(Cell c : bodySegments)
        {
            c.setColor(BODY_COLOR);
        }
    }
    
    

    @Override
    public void keyPressed(KeyEvent e) {        
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
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)       // when the space key is pressed, start the game
        {
            setupGame();
        }
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

    public void setupGame()
    {
        direction = "RIGHT";
        bodySegments.clear();
        gameStarted = true;
    }
    public void shutdownGame()
    {
        gameStarted = false;
    }

    public void move()
    {
        //System.out.println("I may have gotten stuck here. Length currently is " + bodySegments.size());
        for (int ii = bodySegments.size() - 1; ii >= 0; ii--)
        {
            if (ii == 0)
            {
                bodySegments.get(0).removeSnake();
                bodySegments.remove(0);
            }
            //System.out.println("Body did something");
        }
    }


    /*This is explicitly for testing, gonna replace it once the merge starts */
    public void testMove()
    {
        Cell head = bodySegments.get(bodySegments.size() - 1);
        int headRow = head.getRow();
        int headCol = head.getCol();
        Cell headMove = head;

        if (headRow % 2 == 0)
        {
            headMove = campus.getCell(headRow, headCol + 1);
        }
        else if(headCol % 2 == 0)
        {
            headMove = campus.getCell(headRow + 1, headCol);
        }
        else{
            headMove = campus.getCell(headRow, headCol + 1);

        }
        bodySegments.add(headMove);
        headMove.addSnake(this);
    }


    public Color getBodyColor()
    {
        return BODY_COLOR;
    }
    public Color getHeadColor()
    {
        return HEAD_COLOR;
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
    
