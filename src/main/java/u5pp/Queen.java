package u5pp;

public class Queen extends ChessPiece {
    public Queen(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }
    //checks to see if it can move onto space
    public boolean canMoveTo(int row, int col){
        int rowMath = Math.abs(getRow()-row );
        int colMath = Math.abs(getColumn()-col);
        if (rowMath != 0 && colMath != 0 && rowMath != colMath){
            return false;
        }
        //checks to see if its in bounds
        if (row < 0 || row > 7 || col < 0 || col >7){
            System.out.println(false + "left boundary");
            return false; 
        }
        //checks if on same space
        if (getRow() == row && getColumn() == col){
            System.out.println(false + "no move");
            return false;
        }
        //checks to see if taking own piece or moving on one
        if (board[row][col] != null &&getIsWhite() == board[row][col].getIsWhite()){
            System.out.println(false + "friendly fire");
            return false;
        }
       //checks to move only up down left right and diagonally
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
        if (getRow() < row){
            for (int cr = getRow() +1 ; cr < row; cr++){
                if (board[cr][col] != null ){
                    System.out.println(false);
                    return false;
                }
            }
        }
        if (getRow() > row){
            for (int cr = getRow() -1; cr > row; cr --){
                if (board[cr][col] != null){
                    System.out.println(false);
                    return false;
                }
            }
        }
        if (getColumn()<col){
            for (int cc = getColumn() +1; cc < col; cc ++){
                if (board[row][cc] != null){
                    System.out.println(false);
                    return false;
                }
            }
        }
        if (getColumn()>col){
            for (int cc = getColumn()-1; cc > col; cc --){
                if (board[row][cc] != null){
                    System.out.println(false + "down 4");
                    return false;
                }
            }
        }
        return true;
    }

    //prints Q or q
    public String toString() {
        if (isWhite == true){
            return "Q";
        }
        else {
            return "q";
        }
    }
}