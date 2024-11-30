public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        if (!color.equals("White") && !color.equals("Black")) {
            throw new IllegalArgumentException("Invalid color for chess piece");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean hasMoved() {
        return !check;
    }

    public void setMoved() {
        this.check = false;
    }
}













