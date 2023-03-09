package u5pp;

public class Rook extends ChessPiece {
    public Rook(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }
//checks whether it can move onto the space specified
    public boolean canMoveTo(int row, int col){
        if (row < 0 || row > 7 || col < 0 || col >7){
            System.out.println(false + "not in boundaries");
            return false; 
        }
        //checks if moving on same space
        if (getRow() == row && getColumn() == col){
            System.out.println(false + "didnt move");
            return false;
        }//checks if it was a line
        if (getRow() != row && getColumn() != col){
            System.out.println(false + "not straight");
            return false;
        }//checks if friendly fgire
        if (board[row][col] != null&&getIsWhite() == board[row][col].getIsWhite()){
            System.out.println(false + "friendly fire");
            return false;
        }//checks to see if only moving horizontal or vertical
        if (getRow() < row){
            for (int cr = getRow() +1 ; cr < row; cr++){
                if (board[cr][col] != null ){
                    System.out.println(false);
                    return false;
                }
            }
        }if (getRow() > row){
            for (int cr = getRow() -1; cr > row; cr --){
                if (board[cr][col] != null){
                    System.out.println(false);
                    return false;
                }
            }
        }if (getColumn()<col){
            for (int cc = getColumn() +1; cc < col; cc ++){
                if (board[row][cc] != null){
                    System.out.println( false);
                    return false;
                }
            }
        }if (getColumn()>col){
            for (int cc = getColumn()-1; cc > col; cc --){
                if (board[row][cc] != null){
                    System.out.println(false);
                    return false;
                }
            }
        }
        System.out.println(true +"done");
        return true;
    }//to string for rook
    public String toString() {
        if (isWhite == true){
            return "R";
        }
        else {
            return "r";
        }
    }
}