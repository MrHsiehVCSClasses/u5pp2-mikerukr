package u5pp;

public class ChessPiece {
//instanciates instance variables
    ChessPiece[][] board; 
    int row;
    int col;
    boolean isWhite;
    boolean hasMoved;
public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite){
        //sets values of instance variables
        this.board = board;
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }//returns the instance variables
    public ChessPiece[][] getBoard(){
        return board;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return col;
    }
    public boolean getIsWhite(){
        return isWhite;
    }
    //checks whether it can move to a spot
    public boolean canMoveTo(int row, int col){
        //checks whether moving on your piece
        if (getRow() == row && getColumn() == col){
            return false;
        }
        //checks for boundaries
        if (row < 0 || row > 7 || col < 0 || col >7){
            return false; 
        }
        //checks for if on our piece
        if (board[row][col] != null && getIsWhite() == board[row][col].getIsWhite()){
            return false;
        }
        return true;
    }//moves piece to the specified coordinate
    public void moveTo(int row, int col){
        ChessPiece temp = board [getRow()][getColumn()];
        board [getRow()][getColumn()] = null;
        board [row][col] = temp;
        hasMoved = true;
    }//prints the position of the piece called
    public String toString(){
        return board [row][col].toString();
    }
}