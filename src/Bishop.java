public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(line, column, toLine, toColumn) ||
                Math.abs(line - toLine) != Math.abs(column - toColumn)) {
            return false;
        }


        int stepLine = line < toLine ? 1 : -1;
        int stepColumn = column < toColumn ? 1 : -1;
        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;

        while (currentLine != toLine && currentColumn != toColumn) {
            if (board.board[currentLine][currentColumn] != null) return false;
            currentLine += stepLine;
            currentColumn += stepColumn;
        }


        ChessPiece target = board.board[toLine][toColumn];
        return target == null || !target.getColor().equals(this.color);
    }


    @Override
    public String getSymbol() {
        return "B"; // Символ слона
    }
}
