
/**
 * Write a description of class MinesweeperBoard4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard4
{
    Cell[][] board;
    int rows;
    int columns;

    public MinesweeperBoard4(int rows, int columns, int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell[rows][columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addBombs(bombs);
        addNums();
    }

    public MinesweeperBoard4(){
        this(10,10,98);
    }

    public void addBombs(int bombs) { //throws Exception{
        for (int i = 0; i < bombs;  i++) {
            int row = (int)((Math.random() * (rows)));
            int column = (int)((Math.random() * (columns)));
            if (board[row][column].getValue() == -1){
                i--;
            }else {
                board[row][column].setValue(-1); 
            }
        }
    }

    public void addNums(){
        for (int i = 0; i< rows; i++){
            for (int j = 0; j<columns; j++){
                if(board[i][j].getValue() == -1){
                    if((j > 0) && (i > 0)){
                        board[i-1][j-1].incrementValue();
                    }         //top left
                    if((j<9) && (i >0)){
                        board[i-1][j+1].incrementValue();
                    }        //top right
                    if (i>0){
                        board[i-1][j].incrementValue();
                    }        //top
                    if(j>0){
                        board[i][j-1].incrementValue();
                    }        //left
                    if(j<9){
                        board[i][j+1].incrementValue();
                    }       //right
                    if((j>0) && (i<9)){
                        board[i+1][j-1].incrementValue();
                    }       //bottom left
                    if((j<9) && (i<9)){
                        board[i+1][j+1].incrementValue();
                    } //bottom right
                    if(i<9){
                        board[i+1][j].incrementValue();
                    }//bottom
                }
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int x = 0;
        for (int i = 0; i <rows; i++){
            for (int j = 0; j < columns; j++){
                if (board[i][j].getValue() == -1){
                    System.out.print("X" + " ");
                }else {
                    System.out.print(board[i][j].getValue() + " ");
                }
                x++;
            }
            System.out.println();
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                board[r][c]= new Cell(this);
                panel.add(board[r][c].getButton());
            }
        }
        return panel;
    }
}

