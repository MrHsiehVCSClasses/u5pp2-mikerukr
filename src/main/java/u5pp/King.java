package u5pp;

public class King extends ChessPiece {
    //king constructor and variables
    public King(ChessPiece[][] board, int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
    }
    public boolean canMoveTo(int row, int col){
        //checks for boundary
        if (row < 0 || row > 7 || col < 0 || col >7){
            System.out.println("not in boundary");
            return false; 
        }
        //no more
        if (getRow() == row && getColumn() == col){
            System.out.println("no move");
            return false;
        }
        //sees whether it is in self space
        if (board [row][col] != null && board [row][col].getIsWhite()==getIsWhite()){
            System.out.println("friendly fire not valid");
            return false;
        }
        //moves in ony available spaces
        if ((col > getColumn() + 1 || col < getColumn() - 1 ) || (row > getRow() + 1 || row < getRow() - 1 )){
            System.out.println("not in available space");
            return false;
        }return true;
    } 
    //moves piece to coordinate
    public void moveTo(int row, int col){
        ChessPiece temp = board [getRow()][getColumn()];
        board [getRow()][getColumn()] = null;
        board [row][col] = temp;
        hasMoved = true;
    }

    //to String for K
    public String toString() {
        if (isWhite == true){
            return "K";
        }
        else {
            return "k";
        }
    }

    //checks whether King is in area
    boolean isKingThere(int row, int col){
        if (row -1 >0 && col - 1 > 0){
            if (board[row -1][col-1] instanceof King){
                return true;
            }
        }
        else if (row -1 >0 && col + 1 < board[0].length-1 ){
            if (board[row -1][col+1] instanceof King){
                return true;
            }
        }
        else if (row +1 >board.length-1 && col - 1 > 0){
            if (board[row +1][col-1] instanceof King){
                return true;
            }
        }
        else if (row +1 <board.length-1 && col + 1 < board[0].length-1){
            if (board[row +1][col+1] instanceof King){
                return true;
            }
        }
        else if (col +1 <board[0].length){
            if (board[row][col +1] instanceof King){
                return true;
            }
        }
        else if (row -1 >0){
            if (board[row -1][col] instanceof King){
                return true;
            }
        }
        else if (row +1 < board.length){
            if (board[row +1][col] instanceof King){
                return true;
            }
        }
        else if (col -1 >0){
            if (board[row][col -1] instanceof King){
                return true;
            }
        }
            return false;
    }
}