public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(line, column, toLine, toColumn)) {
            return false;
        }


        int direction = this.color.equals("White") ? 1 : -1;


        if (column == toColumn) {

            if (line + direction == toLine && board.board[toLine][toColumn] == null) {
                return true;
            }

            if ((line == 1 && this.color.equals("White") || line == 6 && this.color.equals("Black")) &&
                    line + 2 * direction == toLine && board.board[toLine][toColumn] == null &&
                    board.board[line + direction][toColumn] == null) {
                return true;
            }
        }


        if (Math.abs(column - toColumn) == 1 && line + direction == toLine) {
            ChessPiece target = board.board[toLine][toColumn];
            return target != null && !target.getColor().equals(this.color);
        }

        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}

