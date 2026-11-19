
import javax.swing.*;
import java.awt.*;

/*
 *The purpose of class is to ensure the proper functionality of the cells
 */

public class Cell{

    public static final Color WALL_COLOR = Color.BLACK;
    public static final Color EMPTY_COLOR = Color.GRAY;
    public static final Color BODY_COLOR = Color.GREEN;
    public static final Color HEAD_COLOR = Color.BLUE;

    
    private JButton button;
    private boolean occupied;
    private boolean isWallCell;
    private final int row;
    private final int col;

    /**
     * Constructor
     */
    public Cell(int rr, int cc, boolean wallCell)
    {
        row = rr;
        col = cc;
        occupied = false;
        isWallCell = wallCell;
        button = new JButton();
        button.setPreferredSize(new Dimension(Campus.CELL_SIZE,Campus.CELL_SIZE));
        button.setMargin(new Insets(0,0,0,0));
        if(isWallCell == true)
        {
            button.setBackground(WALL_COLOR);
        }
        else
        {
            button.setBackground(EMPTY_COLOR);
        }
        currentSnake = null;
    }
    
    /**
     * Accessor method
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Changes button text
     */
    public void setText(String text)
    {
        button.setText(text);
    }

    /**
     * Sets the color of the button
     * 
     */
    public void setColor(Color newColor)
    {
        button.setBackground(newColor);
    }

    /**
    * Checks to see if the cell is empty
    */
    public boolean getAvailability(){
        return !occupied;
    }

    /**
     * Accessor method
     */
    public boolean isWallCell() {
        return isWallCell;
    }

    /**
     * Accessor method
     */

    public int getRow() {
        return row;
    }

    /**
     * Accessor method
     */
    public int getCol() {
        return col;
    }

     
    Snake currentSnake;
    public void addSnake(Snake snake)
    {
        currentSnake = snake;
        occupied = true;
        button.setBackground(snake.getBodyColor());
    }

    public void removeSnake()
    {
        currentSnake= null;
        occupied = false;
        button.setBackground(EMPTY_COLOR);
    }



    public void setCell(int[] is, int[] is2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCell'");
    }

    
    
    /*May use this class for some special effect when the apple is eaten idk */
    // /**
    //  * Briefly turns a cell some color, then back to its previous color.
    //  *
    //  */

    // public void brieflyColor(Color color)
    // {
    //     Color oldColor = button.getBackground();
    //     button.setBackground(color);
    //     Tester.pause(100*Tester.sleepTime); //hold longer than usual it so we can see it
    //     button.setBackground(oldColor);
    // }

}
