import chess.ChessMatch;
import chess.ChessPiece;

public class App {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        ChessPiece[][] pieces = chessMatch.getPieces();

        printBoard(pieces);
    }

    public static void printBoard(ChessPiece[][] pieces) {

        for (int i = 0; i < pieces.length; i++) {

            System.out.print((8 - i) + " ");

            for (int j = 0; j < pieces[i].length; j++) {

                if (pieces[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(pieces[i][j] + " ");
                }
            }

            System.out.println();
        }

        System.out.println("  a b c d e f g h");
    }
}