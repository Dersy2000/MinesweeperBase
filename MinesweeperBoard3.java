
/**
 * Write a description of class MinesweeperBoard3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard3
{
    Cell[] board;
    int rows;
    int columns;

    public MinesweeperBoard3(int rows, int columns, int bombs){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell[rows*columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addboard());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        addBombs(bombs);
        addNums();
    }

    public MinesweeperBoard3(){
        this(10,10,98);
    }

    public void addBombs(int bombs) { //throws Exception{
        for (int i = 0; i < bombs;  i++) {
            int index = (int)((Math.random() * (rows * columns) - 1));
            if (board[index].getValue() == -1){
                i--;
            }else {
                board[index].setValue(-1); 
            }
        }
    }

    public void addNums(){
        for (int i = 0; i< (rows * columns); i++){
            if(board[i].getValue() == -1){
                if((i >= columns) && (i % columns != 0)){
                    board[i - columns - 1].incrementValue();
                }                   //top left
                if(i >= columns){
                    board[i - columns].incrementValue();
                }          //top
                if((i >= columns) && (i % columns != (columns -1))){
                    board[i - columns + 1].incrementValue();
                }                   //top right
                if((i % columns != 0)){
                    board[i - 1].incrementValue();
                }                   //left
                if(i % columns != (columns - 1)){
                    board[i + 1].incrementValue();
                }                   //right
                if((i < ((rows - 1) * columns)) && (i % columns != 0)){
                	board[i + columns - 1].incrementValue();
                }                   //bottom left
                if(i < ((rows - 1) * columns)){
                	board[i + columns].incrementValue();
                }                   //bottom
                if(i < ((rows - 1) * columns) && (i % columns != (columns - 1))){
                	board[i + columns + 1].incrementValue();
                }                   //bottom right
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
                if (board[x].getValue() == -1){
                    System.out.print("X" + " ");
                }else {
                    System.out.print(board[x].getValue() + " ");
                }
                x++;
            }
            System.out.println();
        }
    }

    public JPanel addboard(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell(this);
            panel.add(board[i].getButton());
        }
        return panel;
    }
}
