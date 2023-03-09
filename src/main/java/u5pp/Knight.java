package u5pp;

public class Knight extends ChessPiece {
    //sets constructor and variables
    public Knight(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }
    //checks to see if it can move onto that space, boundary
    public boolean canMoveTo(int row, int col){
        if (row < 0 || row > 7 || col < 0 || col >7){
            return false; 
        }//check to make sure no friendly fire
        if (getRow() == row && getColumn() == col){
            return false;
        }//check to see if its on friendly fire again
        if ((board[row][col] != null)&&getIsWhite() == board[row][col].getIsWhite()){
            System.out.println(false + "friendly fire");
            return false;
        }
        //check to see if move is allowed
        boolean valid = true;
        if (row > this.row + 2 || row < this.row - 2 || col > this.col + 2 || col < this.col - 2){
            valid = false;
        }else if (Math.abs(getRow() - row) == Math.abs(getColumn() - col)){
            valid = false;
        }else if (getRow() == row || getColumn() == col){
            valid = false;
        }if (valid == false){
            return false;
        }return true;
    }//To string for knight 
    public String toString() {
        if (isWhite == true){
            return "N";
        }
        else {
            return "n";
        }
    }
}