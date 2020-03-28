package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        b.displayBoard();
        System.out.println("select turn:\n1. Computer(X) /2. User(O):");
        int choice = scanner.nextInt();
      //  if (choice == Board.PLAYER_X) {


            ///
            while (!b.isGameOver()) {
                boolean moveOK = true;
                Point p = new Point(RANDOM.nextInt(3), RANDOM.nextInt(3));
                b.placeAMove(p, Board.PLAYER_X);
                b.displayBoard();
                do {
                    if (!moveOK) {
                        System.out.println("cell is already filled");
                    }
                    System.out.println("your move: ");
                    Point userMove = new Point(scanner.nextInt(), scanner.nextInt());
                    moveOK = b.placeAMove(userMove, Board.PLAYER_O);
                } while (!moveOK);
                b.displayBoard();

                if (b.isGameOver())
                    break;

                b.minMax(0, Board.PLAYER_X);
                System.out.println("computer chooses position " + p);
                b.placeAMove(p, Board.PLAYER_X);
                b.displayBoard();
            }
       // }




        if (b.hasPlayerWon(Board.PLAYER_X)) {
            System.out.println("you lost!");
        } else if (b.hasPlayerWon(Board.PLAYER_O)) {
            System.out.println("you win!");
        } else {
            System.out.println("draw");
        }
    }
}

