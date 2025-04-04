import java.util.Arrays;
import java.util.Scanner;

public class CliTicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        int[][] boardPlaces = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 },
                { 3, 3 } };
        int[][] enteredPlaces = new int[9][2];

        int indexCount = 0, flag = 0;
        int num1 = 0, num2 = 0, x = 0, y = 0;
        char player = 'X';
        System.out.println("Default Board :");
        setBoard(board);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Player " + player);
            System.out.print("Enter the Square number, in matrix form, you want to place your pattern : ");

            String placeInString = sc.nextLine();
            String[] placeInArrayString = placeInString.split(",");
            String tempPlace = Arrays.toString(placeInArrayString);

            try {
                for (int[] i : boardPlaces) {
                    if (Arrays.toString(i).equals(tempPlace)) {
                        for (int[] j : enteredPlaces) {
                            if (Arrays.toString(j).equals(tempPlace))
                                throw new AlreadyExistingError("This Place is Already Occupied.");
                        }
                        for (String j : placeInArrayString) {
                            enteredPlaces[indexCount][flag] = Integer.parseInt(j);
                            if (flag == 0) {
                                num1 = Integer.parseInt(j);
                            } else {
                                num2 = Integer.parseInt(j);
                            }
                            flag = (flag == 1) ? 0 : 1;
                        }
                        board[num1 - 1][num2 - 1] = player;
                        break;
                    }
                }
                if (flag == 1) {
                    flag = 0;
                    throw new OutOfBoundError(
                            "Enter a valid Integer Value Number in Matrix form within 1,1 to 3,3");
                }
                indexCount++;
            } catch (OutOfBoundError e) {
                System.out.println(e.getMessage());
                continue;
            } catch (AlreadyExistingError e) {
                System.out.println(e.getMessage());
                continue;
            }

            printBoard(board);
            
            if(ifWon(board, x, y)) {
                System.out.println("Player " + player + " wins.");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    public static void setBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 0 && i != 9) {
                System.out.println("___|___|___");
            } else {
                System.out.println("   |   |   ");
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println("   |   |   ");
                System.out.println(" " + board[i][j] + " | " + board[i][j + 1] + " | " + board[i][j + 2]);
                if (i != 2) {
                    System.out.println("___|___|___");
                } else {
                    System.out.println("   |   |   ");
                }
            }
        }
    }

    public static boolean ifWon(char[][] board, int x, int y) {
        if (board[x][y] == board[x][y + 1] && board[x][y + 1] == board[x][y + 2]) {
            return true;
        } else if (board[x][y] == board[x + 1][y] && board[x + 1][y] == board[x + 2][y]) {
            return true;
        } else if (board[x][y] == board[x + 1][y + 1] && board[x + 1][y + 1] == board[x + 2][y + 2]) {
            return true;
        } else {
            return false;
        }
    }
}

class OutOfBoundError extends Exception {
    public OutOfBoundError(String message) {
        super(message);
    }
}

class AlreadyExistingError extends Exception {
    public AlreadyExistingError(String message) {
        super(message);
    }
}