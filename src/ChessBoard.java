public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (!checkPos(startLine) || !checkPos(startColumn) ||
                !checkPos(endLine) || !checkPos(endColumn)) {
            return false;
        }

        ChessPiece piece = board[startLine][startColumn];
        if (piece == null || !nowPlayer.equals(piece.getColor())) {
            return false;
        }

        if (piece.canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
            board[endLine][endColumn] = piece; // Перемещение фигуры
            board[startLine][startColumn] = null; // Очищаем прежнее поле
            piece.setMoved(); // Отмечаем, что фигура двигалась
            nowPlayer = nowPlayer.equals("White") ? "Black" : "White"; // Меняем игрока
            return true;
        }
        return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        int row = nowPlayer.equals("White") ? 0 : 7; // Белые на 0-й, черные на 7-й строке
        if (board[row][4] instanceof King king &&
                board[row][0] instanceof Rook rook &&
                !king.hasMoved() && !rook.hasMoved()) {

            // Проверяем, что между королем и ладьей нет фигур
            for (int col = 1; col < 4; col++) {
                if (board[row][col] != null) return false;
            }
            // Выполняем рокировку
            board[row][2] = king;
            board[row][3] = rook;
            board[row][4] = null;
            board[row][0] = null;
            king.setMoved();
            rook.setMoved();
            nowPlayer = nowPlayer.equals("White") ? "Black" : "White"; // Меняем игрока
            return true;
        }
        return false;
    }
    public boolean castling7() {
        int row = nowPlayer.equals("White") ? 0 : 7; // Белые на 0-й, черные на 7-й строке
        if (board[row][4] instanceof King king &&
                board[row][7] instanceof Rook rook &&
                !king.hasMoved() && !rook.hasMoved()) {

            // Проверяем, что между королем и ладьей нет фигур
            for (int col = 5; col < 7; col++) {
                if (board[row][col] != null) return false;
            }
            // Выполняем рокировку
            board[row][6] = king;
            board[row][5] = rook;
            board[row][4] = null;
            board[row][7] = null;
            king.setMoved();
            rook.setMoved();
            nowPlayer = nowPlayer.equals("White") ? "Black" : "White"; // Меняем игрока
            return true;
        }
        return false;
    }

    public boolean isValidPosition(int line, int column, int toLine, int toColumn) {
        return checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                (line != toLine || column != toColumn); // Позиции не совпадают
    }


}
