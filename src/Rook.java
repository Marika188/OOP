public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(line, column, toLine, toColumn) ||
                (line != toLine && column != toColumn)) {
            return false;
        }


        if (line == toLine) {
            int step = column < toColumn ? 1 : -1;
            for (int col = column + step; col != toColumn; col += step) {
                if (board.board[line][col] != null) return false;
            }
        } else {
            int step = line < toLine ? 1 : -1;
            for (int row = line + step; row != toLine; row += step) {
                if (board.board[row][column] != null) return false;
            }
        }


        ChessPiece target = board.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }


    @Override
    public String getSymbol() {
        return "R";
    }
}
