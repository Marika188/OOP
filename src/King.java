public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {
        if (!board.isValidPosition(line, column, toLine, toColumn)) {
            return false;
        }


        int dx = Math.abs(line - toLine);
        int dy = Math.abs(column - toColumn);

        if (dx <= 1 && dy <= 1) {
            ChessPiece target = board.board[toLine][toColumn];
            return target == null || !target.getColor().equals(this.color);
        }

        return false;
    }


    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessBoard.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color) &&
                        piece.canMoveToPosition(chessBoard, i, j, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
