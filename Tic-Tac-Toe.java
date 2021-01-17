package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                char[][] grid = new char[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        grid[i][j] = ' ';
                    }
                }
                System.out.println("---------");
                System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
                System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
                System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
                System.out.println("---------");
                boolean game = false;
                char xO = 'O';
                do {
                    if (xO == 'X') {
                        xO = 'O';
                    } else {
                        xO = 'X';
                    }
                    boolean flag = true;
                    do {
                        System.out.println("Enter the coordinates: ");
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        if ((x == 1 || x == 2 || x == 3) && (y == 1 || y == 2 || y == 3)) {
                            if (grid[x - 1][y - 1] == ' ' || grid[x - 1][y - 1] == '_') {
                                grid[x - 1][y - 1] = xO;
                                flag = false;
                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                        } else if ((x == 4 || x == 5 || x == 6 || x == 7 || x == 8 || x == 9 || x == 0) || (y == 4 || y == 5 || y == 6 || y == 7 || y == 8 || y == 9 || y == 0 )) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else {
                            System.out.println("You should enter numbers!");
                        }
                    } while (flag);
                    System.out.println("---------");
                    System.out.println("| " + grid[0][0] + " " + grid[0][1] + " " + grid[0][2] + " |");
                    System.out.println("| " + grid[1][0] + " " + grid[1][1] + " " + grid[1][2] + " |");
                    System.out.println("| " + grid[2][0] + " " + grid[2][1] + " " + grid[2][2] + " |");
                    System.out.println("---------");
                    char[] gridNew = new char[9];
                    int count = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            gridNew[count] = grid[i][j];
                            count++;
                        }
                    }
                    char winner = 'N';
                    char winnerI1 = 'A';
                    char winnerI2 = 'B';
                    boolean empty = false;
                    for (int i = 0; i <= 6; i += 3) {
                        if (gridNew[i] == 'X' && gridNew[i + 1] == 'X' && gridNew[i + 2] == 'X') {
                            winner = 'X';
                            winnerI1 = 'x';
                        } else if (gridNew[i] == 'O' && gridNew[i + 1] == 'O' && gridNew[i + 2] == 'O') {
                            winner = 'O';
                            winnerI2 = 'o';
                        }
                    }
                    for (int i = 0; i <= 2; i++) {
                        if (gridNew[i] == 'X' && gridNew[i + 3] == 'X' && gridNew[i + 6] == 'X') {
                            winner = 'X';
                            winnerI1 = 'x';
                        } else if (gridNew[i] == 'O' && gridNew[i + 3] == 'O' && gridNew[i + 6] == 'O') {
                            winner = 'O';
                            winnerI2 = 'o';
                        }
                    }
                    for (int i = 0; i <= 0; i++) {
                        if (gridNew[i] == 'X' && gridNew[i + 4] == 'X' && gridNew[i + 8] == 'X') {
                            winner = 'X';
                            winnerI1 = 'x';
                        } else if (gridNew[i] == 'O' && gridNew[i + 4] == 'O' && gridNew[i + 8] == 'O') {
                            winner = 'O';
                            winnerI2 = 'o';
                        }
                    }
                    for (int i = 2; i <= 2; i++) {
                        if (gridNew[i] == 'X' && gridNew[i + 2] == 'X' && gridNew[i + 4] == 'X') {
                            winner = 'X';
                            winnerI1 = 'x';
                        } else if (gridNew[i] == 'O' && gridNew[i + 2] == 'O' && gridNew[i + 6] == 'O') {
                            winner = 'O';
                            winnerI2 = 'o';
                        }
                    }
                    int countX = 0;
                    int countO = 0;
                    for (int i = 0; i < 9; i++) {
                        if (gridNew[i] == ' ' || gridNew[i] == '_') {
                            empty = true;
                        }
                        if (gridNew[i] == 'X') {
                            countX++;
                        }
                        if (gridNew[i] == 'O') {
                            countO++;
                        }
                    }
                    if ((winnerI1 == 'x' && winnerI2 == 'o') || (Math.abs(countO - countX)) >= 2) {
                        System.out.println("Impossible");
                        game = false;
                    } else if (winner == 'X') {
                        System.out.println("X wins");
                        game = false;
                    } else if (winner == 'O') {
                        System.out.println("O wins");
                        game = false;
                    } else if (winner == 'N' && empty == true) {
                        game = true;
                    } else if (winner == 'N' && empty == false) {
                        System.out.println("Draw");  
                        game = false;
                    }
                    count = 0;
                } while (game);
    }
}
