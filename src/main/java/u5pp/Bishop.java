package u5pp;

public class Bishop extends ChessPiece {
    //the constructor and instance variables
    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }
    //checks to see if it can move there, aka boundary
    public boolean canMoveTo(int row, int col){
        if (row < 0 || row > 7 || col < 0 || col >7){
            System.out.println(false + "left boundary lmao");
            return false; 
        }
        //checks if its still in same spot
        if (getRow() == row && getColumn() == col){
            System.out.println(false + "same spot");
            return false;
        }
        //check to see if its moving diagonally
        if (getRow() == row || getColumn() == col){
            System.out.println(false + "can only move daigonal");
            return false;
        }
        //check to see friendly fire
        if (board[row][col] != null && getIsWhite() == board[row][col].getIsWhite()){
            System.out.println(false + "freidnlty fire");
            return false;
        }
//check to see if move isinvalid
        if (getRow() < row && getColumn()<col){
            for (int cr = getRow() +1 ; cr < row; cr++){
                for (int cc = getColumn() + 1; cc < col; cc ++){
                    if (board[cr][cc] != null ){
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }
        if (getRow() > row && getColumn()>col){
            for (int cr = getRow() -1; cr > row; cr --){
                for (int cc = getColumn() -1; cc > col; cc --){
                    if (board[cr][cc] != null){
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }
        if (getRow() > row && getColumn()<col){
            for (int cr = getRow() -1 ; cr > row; cr --){
                for (int cc = getColumn() +1; cc < col; cc ++){
                    if (board[cr][cc] != null){
                        System.out.println( false);
                        return false;
                    }
                }
            }
        }
        if (getRow() < row && getColumn()>col){
            for (int cr = getRow() +1; cr < row; cr ++){
                for (int cc = getColumn()-1; cc > col; cc --){
                    if (board[cr][cc] != null){
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }
        System.out.println(true + "fin");
        return true;
    }

    //to string for B
    public String toString() {
        if (isWhite == true){
            return "B";
        }
        else {
            return "b";
        }
    }
}