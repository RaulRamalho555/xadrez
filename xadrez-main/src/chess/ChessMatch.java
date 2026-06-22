package chess;

import board.Board;
import board.Piece;
import board.Position;

import chess.pieces.Rook;
import chess.pieces.King;

public class ChessMatch {

    private Board board;
    private int turn;
    private Color currentPlayer;

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;

        initialSetup();
    }

    public ChessPiece[][] getPieces() {

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return mat;
    }

    public ChessPiece performChessMove(Position source, Position target) {

        Piece p = board.piece(source);

        if (p == null) {
            throw new ChessException("There is no piece at source position");
        }

        if (!(p instanceof ChessPiece)) {
            throw new ChessException("Source piece is not a chess piece");
        }

        ChessPiece sourcePiece = (ChessPiece) p;

        if (!sourcePiece.possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }

        Piece capturedPiece = makeMove(source, target);

        nextTurn();

        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {

        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);

        board.placePiece(p, target);

        return capturedPiece;
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {

        // WHITE
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));

        placeNewPiece('e', 1, new King(board, Color.WHITE));

        // BLACK
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));

        placeNewPiece('e', 8, new King(board, Color.BLACK));
    }
}