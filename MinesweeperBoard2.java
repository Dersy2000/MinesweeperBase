
/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;

    public MinesweeperBoard2(int rows, int columns, int bombs){
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

    public MinesweeperBoard2(){
        this(10,10,50);
    }

    public void addBombs(int bombs) { //throws Exception{
        for (int i = 0; i < bombs;  i++) {
            int index = (int)(Math.random() * (rows * columns));
            if (board[index].getValue() == -1){
                i--;
            }else {
                board[index].setValue(-1); 
            }
        }
    }

    public void addNums(){
        int x = 0;
        for (int i = 0; i <columns; i++){
            for (int j = 0; j<rows; j++){
                if ( board[x].getValue() != -1){
                    //TOP LEFT ROW
                    if (x == 0){
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                    }
                    //TOP RIGHT
                    else if (x == (rows - 1)){
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 9].getValue() == -1){
                            board[x].incrementValue();
                        }
                    }
                    //BOTTOM LEFT
                    else if (x == ((rows * columns) - 10)){
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 9].getValue()== -1){
                            board[x].incrementValue();
                        }
                    }
                    //BOTTOM RIGHT
                    else if (x == ((rows * columns) -1)){
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                    }
                    //TOP ROW
                    else if ( x < rows){
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 9].getValue() == -1){
                            board[x].incrementValue();
                        }
                    }
                    //BOTTOM ROW
                    else if( i == (columns - 1)){
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 9].getValue()== -1){
                            board[x].incrementValue();
                        }
                    }
                    //LEFT ROW
                    else if (x == (i * rows)){
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 9].getValue()== -1){
                            board[x].incrementValue();
                        }
                    }
                    //RIGHT ROW
                    else if( x== ((i + 1) * rows) - 1){
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 9].getValue()== -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 9].getValue() == -1){
                            board[x].incrementValue();
                        }
                    }
                    else{
                        if( board[x + 1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x -1].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 10].getValue() == -1){
                            board[x].incrementValue();
                        } 
                        if( board[x + 9].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x + 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 11].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 10].getValue() == -1){
                            board[x].incrementValue();
                        }
                        if( board[x - 9].getValue()== -1){
                            board[x].incrementValue();
                        }
                    }
                }
                x++;
            }

        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int x = 0;
        for (int i = 1; i <11; i++){
            for (int j = 0; j < 10; j++){
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
