import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);
        while (true) {
            user1Move(board);
            if (isGameOver(board)){
                break;
            }
//            user2Move(board);
//            if (isGameOver(board)){
//                break;
//            }
            compMove(board);
            if (isGameOver(board)){
                break;
            }
        }
    }




    private static void compMove(char[][] board) {
        Random random = new Random();
        int compInput;
        while (true){
            compInput = random.nextInt(9)+1;
            if (isValidMove(board, String.valueOf(compInput))){
                break;
            }
        }
        System.out.println("computer choose : " + compInput);
        enterMove(board, String.valueOf(compInput),'O');
        printBoard(board);
    }


    private static void user1Move(char[][] board) {

        Scanner sc = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Player1 choose : (1-9)");
            userInput = sc.nextLine();
            if (isValidMove(board, userInput)){
                break;
            }
            System.out.println(userInput +" Invalid move! Try Again");
        }

        enterMove(board, userInput,'X');
        printBoard(board);
    }

//    private static void user2Move(char[][] board) {
//
//        Scanner sc = new Scanner(System.in);
//        String userInput;
//        while (true) {
//            System.out.println("Player2 choose : (1-9)");
//            userInput = sc.nextLine();
//            if (isValidMove(board, Integer.parseInt(userInput))){
//                break;
//            }
//            System.out.println(userInput +" Invalid move! Try Again");
//        }
//
//        enterMove(board, userInput,'O');
//        printBoard(board);
//    }


    private static boolean isValidMove(char[][] board, String position){
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }


    private static void enterMove(char[][] board, String input, char symbol) {
        switch (input){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid move !");
                break;
        }
//        printBoard(board);
    }


    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        System.out.println("| "+ board[0][0]+" | "+ board[0][1]+" | "+ board[0][2]+" |");
        System.out.println("----+---+----");
        System.out.println("| "+ board[1][0]+" | "+ board[1][1]+" | "+ board[1][2]+" |");
        System.out.println("----+---+----");
        System.out.println("| "+ board[2][0]+" | "+ board[2][1]+" | "+ board[2][2]+" |");
        System.out.println("-------------");
    }

    private static boolean isGameOver(char[][] board){

        if (winner(board,'X')){
            printBoard(board);
            System.out.println("Player1 is A WINNER");
            return true;
        }

        if (winner(board,'O')){
            printBoard(board);
            System.out.println("Player2 is A WINNER");
            return true;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]==' '){
                    return false;
                }
            }
        }printBoard(board);
        System.out.println("Game is over and it's a Draw !");
        return true;
    }

    private static boolean winner(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol ) ){
            return true;
        }
        return false;
    }

}
