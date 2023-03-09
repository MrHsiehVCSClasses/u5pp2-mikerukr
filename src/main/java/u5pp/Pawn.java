package u5pp;

public class Pawn extends ChessPiece {
    public Pawn(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }//checks to see if it can move onto the coord given
    public boolean canMoveTo(int row, int col){
        int tmp = 1;
        boolean isTaking = false;
        if (getIsWhite() == false){
            tmp = -1;
        }//checks if it is in boundary
        if (row < 0 || row > 7 || col < 0 || col >7){
            return false; 
        }//checks to ensure no friendly fire
        if(getColumn() != col && board [row] [col] != null &&getIsWhite() != board [row] [col].getIsWhite()){
            isTaking = true;
        }if (isTaking == true){
            return true;
        }//checks if move is allowed
        if (getColumn() != col && isTaking == false){
            return false;
        }if (getColumn() == col && board[row][col] != null){
            return false;
        }if (getRow() + tmp == row && board[row][col] == null) {
            return true;
        }if (getRow() - tmp == row){
            return false;
        }//checks if friendly fire
        if (hasMoved == false && getRow() +tmp*2==row&&board [row] [col] == null){
            return true;
        }return false;
    }//moves the piece to specified coord
    public void moveTo(int row, int col){
        ChessPiece temp = board [getRow()][getColumn()];
        board [getRow()][getColumn()] = null;
        board [row][col] = temp;
        hasMoved = true;
    }//to string for pawn
public String toString() {
        if (isWhite == true){
        return "P";
        }else {
        return "p";
        }
    }
}