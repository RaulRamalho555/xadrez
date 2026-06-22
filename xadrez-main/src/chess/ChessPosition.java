package chess;

import board.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}