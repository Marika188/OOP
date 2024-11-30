public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(line, column, toLine, toColumn)) {
            return false;
        }

        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
            return false;
        }


        ChessPiece target = board.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }


    @Override
    public String getSymbol() {
        return "H";
    }
}