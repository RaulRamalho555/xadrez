import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {

            printBoard(chessMatch.getPieces());

            System.out.print("Origem: ");
            String source = sc.nextLine();

            System.out.print("Destino: ");
            String target = sc.nextLine();

            ChessPosition sourcePosition = new ChessPosition(
                source.charAt(0),
                Integer.parseInt(source.substring(1))
            );

            ChessPosition targetPosition = new ChessPosition(
                target.charAt(0),
                Integer.parseInt(target.substring(1))
            );

            chessMatch.performChessMove(
                sourcePosition.toPosition(),
                targetPosition.toPosition()
            );
        }
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